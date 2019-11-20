package com.queuedye.skiamerica.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.queuedye.skiamerica.model.dao.SkiResortDao;
import com.queuedye.skiamerica.model.dao.UserDao;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.entity.User;

@Database(
    entities = {SkiResort.class, User.class},
    version = 1, exportSchema = true
)
public abstract class SkiAmericaDatabase extends RoomDatabase {

  protected SkiAmericaDatabase() {
  }

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    SkiAmericaDatabase.applicationContext = applicationContext;
  }

  /**
   * Get a single instance of database
   * @return SkiAmericaDatabase
   */
  public static SkiAmericaDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns a Skiresort Data Access object
   * @return {@link UserDao}
   */
  public abstract SkiResortDao getSkiResortDao();

  /**
   * Returns a User Data Access object
   * @return {@link UserDao}
   */
  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final SkiAmericaDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, SkiAmericaDatabase.class, "ski_america_db")
              .build();
    }

  }

}
