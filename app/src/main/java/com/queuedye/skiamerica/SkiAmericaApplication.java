package com.queuedye.skiamerica;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.queuedye.skiamerica.model.service.SkiAmericaDatabase;

public class SkiAmericaApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    SkiAmericaDatabase.setApplicationContext(this);
    final SkiAmericaDatabase database = SkiAmericaDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getSkiResortDao().delete();
        database.getUserDao().delete();
      }
    }).start();
  }

}