package com.queuedye.skiamerica.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.queuedye.skiamerica.model.entity.SkiResort;
import java.util.Collection;
import java.util.List;

@Dao
public interface SkiResortDao {

  @Insert
  long insert(SkiResort skiResort);

  @Insert
  List<Long> insert(Collection<SkiResort> skiResortIds);

  @Query("SELECT * FROM SkiResort WHERE ski_resort_id =:skiResortId ORDER BY ski_resort_id ASC")
  SkiResort getById(long skiResortId);

  @Query("SELECT * FROM SkiResort")
  LiveData<List<SkiResort>> getAll();
//
//  @Query("SELECT * FROM User WHERE ski_resort =:bool")
//  List<SkiResort> getByFavorites(boolean bool);

  @Delete
  int delete(SkiResort... skiResorts);

}
