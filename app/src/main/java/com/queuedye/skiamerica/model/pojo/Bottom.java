package com.queuedye.skiamerica.model.pojo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Bottom {

    @SerializedName("maxtempF")
    private String maxTempF;

    @SerializedName("mintempF")
    private String minTempF;

    public String getMaxTempF() {
      return maxTempF;
    }

    public void setMaxTempF(String maxTempF) {
      this.maxTempF = maxTempF;
    }

    public String getMinTempF() {
      return minTempF;
    }

    public void setMinTempF(String minTempF) {
      this.minTempF = minTempF;
    }
}
