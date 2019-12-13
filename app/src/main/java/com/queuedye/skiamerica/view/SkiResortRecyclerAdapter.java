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
import java.util.List;

/**
 * Simple Adapter class to display {@link SkiResort} data
 */
public class SkiResortRecyclerAdapter extends RecyclerView.Adapter<SkiResortRecyclerAdapter.SkiResortHolder> {

  private ArrayList<SkiResort> skiResorts = new ArrayList<>();

  /**
   * Initialization of the skiResorts object held within
   * @param skiResorts
   */
  public SkiResortRecyclerAdapter(ArrayList<SkiResort> skiResorts) {
    this.skiResorts = skiResorts;
  }

  /**
   * Update the skiResorts List by clearing, adding the new data, and notifying a data set change
   * @param skiResorts
   */
  public void updateSkiResorts(List<SkiResort> skiResorts) {
    this.skiResorts.clear();
    this.skiResorts.addAll(skiResorts);
    notifyDataSetChanged();
  }

  /**
   * Inflates the list_item layout resource for each {@link SkiResort}
   * @param parent
   * @param viewType
   * @return SkiResortHolder
   */
  @NonNull
  @Override
  public SkiResortRecyclerAdapter.SkiResortHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new SkiResortHolder(view);
  }

  /**
   * Sets the correct text for each element by retrieving them from the skiResort object
   * @param holder
   * @param position
   */
  @Override
  public void onBindViewHolder(@NonNull SkiResortRecyclerAdapter.SkiResortHolder holder,
      int position) {
    TextView name = (TextView) holder.itemView.findViewById(R.id.ski_resort_name_adapter);
    name.setText(skiResorts.get(position).getName());

    TextView maxTemp = (TextView) holder.itemView.findViewById(R.id.max_temp_adapter);
    //String maxTempStr = "Temp High: " + String.valueOf(skiResorts.get(position).getMaxTemp());
    maxTemp.setText(String.valueOf(skiResorts.get(position).getMaxTemp()));

    TextView minTemp = (TextView) holder.itemView.findViewById(R.id.min_temp_adapter);
    //String minTempStr = "Temp Low: " + String.valueOf(skiResorts.get(position).getMinTemp());
    minTemp.setText(String.valueOf(skiResorts.get(position).getMinTemp()));

    TextView chanceOfSnow = (TextView) holder.itemView.findViewById(R.id.chance_of_snow_adapter);
    //String chanceOfSnowStr = "Chance of Snow: " + String.valueOf(skiResorts.get(position).getChanceOfSnow());
    chanceOfSnow.setText(String.valueOf(skiResorts.get(position).getChanceOfSnow()));

    TextView totalSnowFall = (TextView) holder.itemView.findViewById(R.id.total_snow_fall);
    //String totalSnowFallStr = "Total Snow Fall: " + String.valueOf(skiResorts.get(position).getTotalSnowFallCm());
    totalSnowFall.setText(String.valueOf(skiResorts.get(position).getTotalSnowFallCm()));
  }

  /**
   * Get the number of Items in the skiResorts List
   * @return Size of skiResorts
   */
  @Override
  public int getItemCount() {
    return skiResorts.size();
  }

  /**
   * Simple holds a {@link View} object for the current list item
   */
  public class SkiResortHolder extends RecyclerView.ViewHolder {

    public View itemView;

    public SkiResortHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
    }
  }
}
