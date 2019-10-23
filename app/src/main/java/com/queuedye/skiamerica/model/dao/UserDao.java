package com.queuedye.skiamerica.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import com.queuedye.skiamerica.model.entity.User;

@Dao
public interface UserDao {

  @Insert
  Long insert(User user);

  @Delete
  int delete(User... users);
}
