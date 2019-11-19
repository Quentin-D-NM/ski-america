package com.queuedye.skiamerica.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.queuedye.skiamerica.model.entity.User;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Long insert(User user);

  @Query("SELECT * FROM user")
  List<User> getUsers();

  @Query("UPDATE user SET username = :username WHERE user_id = :userId")
  void setUsername(String username, Long userId);

  @Delete
  int delete(User... users);
}
