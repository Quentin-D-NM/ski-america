package com.queuedye.skiamerica.model.dao;

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
  List<Long> insert(Collection<SkiResort> skiResorts);

  @Query("SELECT * FROM SkiResort WHERE ski_resort_id =:skiResortId ORDER BY ski_resort_id ASC")
  SkiResort getById(long skiResortId);

//  @Query("SELECT * FROM User WHERE ski_resort")
//  List<SkiResort> getByFavorites();

  @Delete
  int delete(SkiResort... skiResorts);

}
