package com.queuedye.skiamerica.model.dao;

import androidx.room.Insert;
import androidx.room.Query;
import com.queuedye.skiamerica.model.entity.SkiResort;
import java.util.Collection;
import java.util.List;

public interface SkiResortDao {

  @Insert
  List<Long> insert(Collection<SkiResort> skiResorts);

  @Query("GET * FROM ")
}
