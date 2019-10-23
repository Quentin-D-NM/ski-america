package com.queuedye.skiamerica.model.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.queuedye.skiamerica.model.dao.SkiResortDao;
import com.queuedye.skiamerica.model.dao.UserDao;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.entity.User;
import java.util.Date;

@Database(
    entities = {SkiResort.class, User.class},
    version = 1, exportSchema = true
)
//@TypeConverters(SkiAmericaDatabase.Converters.class)
public abstract class SkiAmericaDatabase extends RoomDatabase {

  protected SkiAmericaDatabase() {
  }

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    SkiAmericaDatabase.applicationContext = applicationContext;
  }

  public static SkiAmericaDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract SkiResortDao getSkiResortDao();

  public abstract UserDao getUserDao();
//
//    public abstract RoundDao getRoundDao();
//
//    public abstract HandDao getHandDao();

  private static class InstanceHolder {

    private static final SkiAmericaDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, SkiAmericaDatabase.class, "ski_america_db")
              .build();
    }

  }

//  public static class Converters {
//  }

}
