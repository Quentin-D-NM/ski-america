package com.queuedye.skiamerica.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkiResortRecyclerAdapter extends RecyclerView.Adapter<SkiResortRecyclerAdapter.SkiResortHolder> {

  private ArrayList<SkiResort> skiResorts = new ArrayList<>();

  public SkiResortRecyclerAdapter(ArrayList<SkiResort> skiResorts) {
    this.skiResorts = skiResorts;
  }

  public void updateSkiResorts(List<SkiResort> skiResorts) {
    this.skiResorts.clear();
    this.skiResorts.addAll(skiResorts);
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public SkiResortRecyclerAdapter.SkiResortHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new SkiResortHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SkiResortRecyclerAdapter.SkiResortHolder holder,
      int position) {
    TextView name = (TextView) holder.itemView.findViewById(R.id.ski_resort_name_adapter);
    name.setText(skiResorts.get(position).getName());

    TextView maxTemp = (TextView) holder.itemView.findViewById(R.id.max_temp_adapter);
    maxTemp.setText(String.valueOf(skiResorts.get(position).getMaxTemp()));

    TextView minTemp = (TextView) holder.itemView.findViewById(R.id.min_temp_adapter);
    minTemp.setText(String.valueOf(skiResorts.get(position).getMinTemp()));

    TextView chanceOfSnow = (TextView) holder.itemView.findViewById(R.id.chance_of_snow_adapter);
    chanceOfSnow.setText(String.valueOf(skiResorts.get(position).getChanceOfSnow()));

    TextView totalSnowFall = (TextView) holder.itemView.findViewById(R.id.total_snow_fall);
    totalSnowFall.setText(String.valueOf(skiResorts.get(position).getTotalSnowFallCm()));
  }

  @Override
  public int getItemCount() {
    return skiResorts.size();
  }

  public class SkiResortHolder extends RecyclerView.ViewHolder {

    public View itemView;

    public SkiResortHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
    }
  }
}
