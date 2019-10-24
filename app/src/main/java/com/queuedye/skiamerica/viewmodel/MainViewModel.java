package com.queuedye.skiamerica.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.queuedye.skiamerica.model.service.SkiAmericaDatabase;

public class MainViewModel extends AndroidViewModel {

  private final SkiAmericaDatabase database;

  public MainViewModel(@NonNull Application application) {
    super(application);
    database = SkiAmericaDatabase.getInstance();
  }


}
