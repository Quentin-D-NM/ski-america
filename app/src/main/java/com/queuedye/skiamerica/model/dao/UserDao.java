package com.queuedye.skiamerica.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.queuedye.skiamerica.model.entity.User;

@Dao
public interface UserDao {

  @Insert
  Long insert(User user);

  @Query("SELECT * FROM User WHERE oauth_key = :oAuthKey")
  User getbyOAuth(String oAuthKey);

  @Delete
  int delete(User... users);
}
