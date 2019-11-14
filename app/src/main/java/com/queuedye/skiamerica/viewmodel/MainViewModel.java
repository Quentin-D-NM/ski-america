package com.queuedye.skiamerica.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.queuedye.skiamerica.model.dao.SkiResortDao;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.entity.User;
import com.queuedye.skiamerica.service.GoogleGeoCoderService;
import com.queuedye.skiamerica.service.SkiAmericaDatabase;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Executor;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private SkiAmericaDatabase database;
  private Executor executor;
  private CompositeDisposable pending = new CompositeDisposable();
  private User user;

  private MutableLiveData<Long> skiResortId;
  private LiveData<SkiResort> skiResort;
  private MutableLiveData<GoogleSignInAccount> account;

  private SkiResortDao skiResortDao;

  public MainViewModel(@NonNull Application application) {
    super(application);
  }

  public void setUpBaseLiveData() {
    skiResortId = new MutableLiveData<>();
    skiResort = new MutableLiveData<>();
  }

  public LiveData<SkiResort> getskiResort() {return skiResort;}

  public void setAccount(GoogleSignInAccount account) {
    this.account.setValue(account);
  }

  public void addressToCoordinates(String user) {
    pending.add(
        GoogleGeoCoderService.getInstance().getCoordinates(skiResortDao.getById(skiResortId.getValue()).getAddress())
        .subscribeOn(Schedulers.io())
        .subscribe((skiResort) -> {
          database.getSkiResortDao().insert(skiResort);
        })
    );
  }


}
