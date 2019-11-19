package com.queuedye.skiamerica.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Entity(
    foreignKeys = {
        @ForeignKey(
          entity = User.class,
          childColumns = "user_id",
          parentColumns = "user_id",
          onDelete = ForeignKey.CASCADE
        )
    }
)
public class SkiResort implements Serializable {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ski_resort_id")
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "ski_resort_name", index = true)
  private String name;

  @ColumnInfo(name = "favorite")
  private boolean favorite;

//  @ColumnInfo(name = "seven_day_forecast", index = true)
//  private String sevenDayForecast;

  @ColumnInfo(name = "max_temp", index = true)
  private float maxTemp;

  @ColumnInfo(name = "min_temp", index = true)
  private float minTemp;

  @ColumnInfo(name = "chance_of_snow")
  private int chanceOfSnow;

  @ColumnInfo(name = "total_snow_fall_cm", index = true)
  private float totalSnowFallCm;

//  @ColumnInfo(name = "wind_dir", index = true)
//  private int windDir;
//
//  @ColumnInfo(name = "wind_spd", index = true)
//  private int windSpd;
//
//  @ColumnInfo(name = "cloud_cover", index = true)
//  private int cloudCover;
//
//  @ColumnInfo(name = "vis", index = true)
//  private int vis;
//
//  @ColumnInfo(name = "rel_humid", index = true)
//  private int relHumid;

  @ColumnInfo(name = "address", index = true)
  private String address;

  @ColumnInfo(name = "lat")
  private double latitude;

  @ColumnInfo(name = "lng")
  private double longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

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


  public boolean isFavorite() {
    return favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public float getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(float maxTemp) {
    this.maxTemp = maxTemp;
  }

  public float getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(float minTemp) {
    this.minTemp = minTemp;
  }

  public int getChanceOfSnow() {
    return chanceOfSnow;
  }

  public void setChanceOfSnow(int chanceOfSnow) {
    this.chanceOfSnow = chanceOfSnow;
  }

  public float getTotalSnowFallCm() {
    return totalSnowFallCm;
  }

  public void setTotalSnowFallCm(float totalSnowFallCm) {
    this.totalSnowFallCm = totalSnowFallCm;
  }

  //
//  public int getWindDir() {
//    return windDir;
//  }
//
//  public void setWindDir(int windDir) {
//    this.windDir = windDir;
//  }
//
//  public int getWindSpd() {
//    return windSpd;
//  }
//
//  public void setWindSpd(int windSpd) {
//    this.windSpd = windSpd;
//  }

//  public int getCloudCover() {
//    return cloudCover;
//  }
//
//  public void setCloudCover(int cloudCover) {
//    this.cloudCover = cloudCover;
//  }
//
//  public int getVis() {
//    return vis;
//  }
//
//  public void setVis(int vis) {
//    this.vis = vis;
//  }
//
//  public int getRelHumid() {
//    return relHumid;
//  }
//
//  public void setRelHumid(int relHumid) {
//    this.relHumid = relHumid;
//  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
