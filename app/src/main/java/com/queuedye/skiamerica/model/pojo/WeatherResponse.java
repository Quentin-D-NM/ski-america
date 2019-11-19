package com.queuedye.skiamerica.model.pojo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {

  private Data data;

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public static class Data {

    @SerializedName("weather")
    private List<Weather> weather;

    public List<Weather> getWeather() {
      return weather;
    }

    public void setWeather(
        List<Weather> weather) {
      this.weather = weather;
    }

    public static class Weather {

      @SerializedName("bottom")
      private List<Bottom> bottom;

      @SerializedName("totalSnowfall_cm")
      private String totalSnowFall;

      @SerializedName("chanceofsnow")
      private String chanceOfSnow;

      public String getChanceOfSnow() {
        return chanceOfSnow;
      }

      public void setChanceOfSnow(String chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
      }

      public List<Bottom> getBottom() {
        return bottom;
      }

      public void setBottom(List<Bottom> bottom) {
        this.bottom = bottom;
      }

      public String getTotalSnowFall() {
        return totalSnowFall;
      }

      public void setTotalSnowFall(String totalSnowFall) {
        this.totalSnowFall = totalSnowFall;
      }
    }
  }
}
