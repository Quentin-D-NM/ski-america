package com.queuedye.skiamerica.model.pojo;

import java.util.List;

public class GeoLocationResponse {

  private List<Item> results;

  public List<Item> getResults() {
    return results;
  }

  public void setResults(
      List<Item> results) {
    this.results = results;
  }

  public static class Item {
    private Geometry geometry;

    public Geometry getGeometry() {
      return geometry;
    }

    public void setGeometry(Geometry geometry) {
      this.geometry = geometry;
    }
  }
}
