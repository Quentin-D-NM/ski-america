package com.queuedye.skiamerica.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.queuedye.skiamerica.BuildConfig;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.entity.User;
import com.queuedye.skiamerica.model.pojo.Bottom;
import com.queuedye.skiamerica.model.pojo.Geometry.Location;
import com.queuedye.skiamerica.service.GoogleGeoCoderService;
import com.queuedye.skiamerica.service.SkiAmericaDatabase;
import com.queuedye.skiamerica.service.WeatherOnlineService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Supplier of {@link LiveData} for cosumption by the {@link com.queuedye.skiamerica.controller.MainActivity}
 * or any other fragments that might display data
 */
public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private Executor executor;
  private SkiAmericaDatabase database;
  private CompositeDisposable pending = new CompositeDisposable();
  private GoogleGeoCoderService geoCoderService;
  private WeatherOnlineService weatherService;
  private MutableLiveData<SkiResort> skiResort;
  private MutableLiveData<GoogleSignInAccount> account;
  private MutableLiveData<User> user;

  /**
   * Initializes the {@link LiveData} containers along with the {@link SkiAmericaDatabase},
   * the {@link GoogleGeoCoderService}, and the {@link WeatherOnlineService} used by this
   * instance.
   * @param application
   */
  public MainViewModel(@NonNull Application application) {
    super(application);
    executor = Executors.newSingleThreadExecutor();
    database = SkiAmericaDatabase.getInstance();
    geoCoderService = GoogleGeoCoderService.getInstance();
    weatherService = WeatherOnlineService.getInstance();
    skiResort = new MutableLiveData<>();
    account = new MutableLiveData<>();
    user = new MutableLiveData<>();
  }

  /**
   * Returns all of the SkiResort Objects saved to the data base
   * @return {@link LiveData} of a {@link List} of a {@link SkiResort}
   */
  public LiveData<List<SkiResort>> getResorts() {
    return database.getSkiResortDao().getAll();
  }

  /**
   * This returns an observable list of {@link SkiResort} form the database
   * @return A live data bucket with a skiResort object within
   */
  public LiveData<SkiResort> getSkiResort() {
    return skiResort;
  }

  /**
   * sets the currently logged in user and creates a user in the database if one does not exist
   * @param account
   */
  public void setAccount(GoogleSignInAccount account) {
    this.account.setValue(account);
    executor.execute(() -> {
      if (database.getUserDao().getUsers().size() != 0) {
        database.getUserDao().setUsername(account.getDisplayName(), database.getUserDao().getUsers().get(0).getId());
        this.user.postValue(database.getUserDao().getUsers().get(0));
      } else {
        User user = new User();
        user.setName(account.getDisplayName());
        database.getUserDao().insert(user);
        this.user.postValue(user);
      }
    });
  }

  /**
   * Adds a SkiResort to the database with the specified location by calling the two appropriate API's for data and notifies observers
   * @param skiResort
   */
  public void addSkiResort(SkiResort skiResort) {
    pending.add(
        geoCoderService.getCoordinates(skiResort.getAddress(), BuildConfig.API_KEY_GEO_CODING)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((response) -> {
          Location location = response.getResults().get(0).getGeometry().getLocation();
          StringBuilder latlng = new StringBuilder();
          latlng.append(location.getLatitude());
          latlng.append(",");
          latlng.append(location.getLongitude());
          weatherService.getWeather(BuildConfig.API_KEY_SKI_WEATHER, latlng.toString(), 1, "json")
              .subscribeOn(Schedulers.from(executor))
              .subscribe((weatherResponse) -> {
                Bottom bottom = weatherResponse.getData().getWeather().get(0).getBottom().get(0);
                skiResort.setMaxTemp(Float.parseFloat(bottom.getMaxTempF()));
                skiResort.setMinTemp(Float.parseFloat(bottom.getMinTempF()));
                skiResort.setChanceOfSnow(Integer.parseInt(weatherResponse.getData().getWeather().get(0).getChanceOfSnow()));
                skiResort.setTotalSnowFallCm(Float.parseFloat(weatherResponse.getData().getWeather().get(0).getTotalSnowFall()));
                skiResort.setFavorite(true);
                skiResort.setUserId(this.user.getValue().getId());
                skiResort.setLatitude(location.getLatitude());
                skiResort.setLongitude(location.getLongitude());
                this.skiResort.postValue(skiResort);
                database.getSkiResortDao().insert(skiResort);
              });
        })
    );
  }

}
