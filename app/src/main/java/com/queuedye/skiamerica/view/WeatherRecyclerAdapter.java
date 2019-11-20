package com.queuedye.skiamerica.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;
import java.util.ArrayList;

public class WeatherRecyclerAdapter extends ArrayAdapter<SkiResort> {

  private Context context;
  private ArrayList<SkiResort> skiResortList;

  public WeatherRecyclerAdapter(@NonNull Context context, ArrayList<SkiResort> list) {
    super(context, 0, list);
    this.context = context;
    skiResortList = list;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View listitem = convertView;
    if (listitem == null) {
      listitem = LayoutInflater.from(context).inflate(R.layout.fragment_main, parent, false);
    }

    SkiResort currentSkiResort = skiResortList.get(position);



    return listitem;
  }
}
