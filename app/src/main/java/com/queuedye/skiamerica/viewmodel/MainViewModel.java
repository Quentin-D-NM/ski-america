package com.queuedye.skiamerica.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.queuedye.skiamerica.BuildConfig;
import com.queuedye.skiamerica.model.dao.SkiResortDao;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.entity.User;
import com.queuedye.skiamerica.service.GoogleGeoCoderService;
import com.queuedye.skiamerica.service.SkiAmericaDatabase;
import com.queuedye.skiamerica.service.WeatherOnlineService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private Executor executor;
  private SkiAmericaDatabase database;
  private CompositeDisposable pending = new CompositeDisposable();
  private GoogleGeoCoderService geoCoderService;
  private WeatherOnlineService weatherService;
  private MutableLiveData<SkiResort> skiResort;
  private MutableLiveData<GoogleSignInAccount> account;

  private Long skiResortId;

  public MainViewModel(@NonNull Application application) {
    super(application);
    executor = Executors.newSingleThreadExecutor();
    database = SkiAmericaDatabase.getInstance();
    geoCoderService = GoogleGeoCoderService.getInstance();
    weatherService = WeatherOnlineService.getInstance();
    skiResort = new MutableLiveData<>();
    account = new MutableLiveData<>();
  }

  public LiveData<SkiResort> getskiResort() {return skiResort;}

  public void setAccount(GoogleSignInAccount account) {
    this.account.setValue(account);
  }

  public void addSkiResort(SkiResort skiResort) {
    pending.add(
        geoCoderService.getCoordinates(skiResort.getAddress(), BuildConfig.BASE_URL_GEO_CODER)
        .subscribeOn(Schedulers.from(executor))
        .subscribe((coordinates) -> {
          StringBuilder latlng = new StringBuilder();
          latlng.append(coordinates.getLat());
          latlng.append(",");
          latlng.append(coordinates.getLng());
          weatherService.getWeather(latlng.toString(), 1, BuildConfig.BASE_URL_SKI_WEATHER)
              .subscribeOn(Schedulers.from(executor))
              .subscribe((skiResort1) -> {
                skiResort1.setName(skiResort.getName());
                skiResort1.setAddress(skiResort.getAddress());
                skiResort1.setLatitude(coordinates.getLat());
                skiResort1.setLongitude(coordinates.getLng());
                database.getSkiResortDao().insert(skiResort1);
              });
        })
    );
  }

}
