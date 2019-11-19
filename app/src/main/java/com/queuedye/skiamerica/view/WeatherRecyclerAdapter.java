package com.queuedye.skiamerica.view;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;

public class WeatherRecyclerAdapter extends ArrayAdapter<SkiResort> {

  public WeatherRecyclerAdapter(@NonNull Context context) {
    super(context, R.layout.ski_resort_fragment);
    Resources res = getContext().getResources();
    String pkg = context.getPackageName();

  }
}
