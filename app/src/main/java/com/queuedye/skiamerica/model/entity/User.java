package com.queuedye.skiamerica.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private Long id;

  @ColumnInfo(name = "username", index = true)
  private String name;

  @ColumnInfo(name = "postal_code", index = true)
  private int postalCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPostalCode() {
    return postalCode;

  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }
}
