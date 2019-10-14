package com.queuedye.skiamerica.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "username", index = true)
  private String name;

  @ColumnInfo(name = "ski_resort", index = true)
  private SkiResort favorites;

  @ColumnInfo(name = "postal_code", index = true)
  private int postalCode;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SkiResort getFavorites() {
    return favorites;
  }

  public void setFavorites(SkiResort favorites) {
    this.favorites = favorites;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }
}
