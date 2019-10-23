package com.queuedye.skiamerica.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
public class SkiResort {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ski_resort_id")
  private long id;

  @ColumnInfo(name = "ski_resort_name", index = true)
  private String name;

  @ColumnInfo(name = "favorite")
  private boolean favorite;

  @ColumnInfo(name = "seven_day_forecast", index = true)
  private String sevenDayForecast;

  @ColumnInfo(name = "temp", index = true)
  private float temp;

  @ColumnInfo(name = "wind_dir", index = true)
  private int windDir;

  @ColumnInfo(name = "wind_spd", index = true)
  private int windSpd;

  @ColumnInfo(name = "cloud_cover", index = true)
  private int cloudCover;

  @ColumnInfo(name = "vis", index = true)
  private int vis;

  @ColumnInfo(name = "rel_humid", index = true)
  private int relHumid;

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


  public String getSevenDayForecast() {
    return sevenDayForecast;
  }

  public void setSevenDayForecast(String sevenDayForecast) {
    this.sevenDayForecast = sevenDayForecast;
  }

  public float getTemp() {
    return temp;
  }

  public void setTemp(float temp) {
    this.temp = temp;
  }

  public int getWindDir() {
    return windDir;
  }

  public void setWindDir(int windDir) {
    this.windDir = windDir;
  }

  public int getWindSpd() {
    return windSpd;
  }

  public void setWindSpd(int windSpd) {
    this.windSpd = windSpd;
  }

  public int getCloudCover() {
    return cloudCover;
  }

  public void setCloudCover(int cloudCover) {
    this.cloudCover = cloudCover;
  }

  public int getVis() {
    return vis;
  }

  public void setVis(int vis) {
    this.vis = vis;
  }

  public int getRelHumid() {
    return relHumid;
  }

  public void setRelHumid(int relHumid) {
    this.relHumid = relHumid;
  }
}
