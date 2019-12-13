package com.queuedye.skiamerica.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.view.SkiResortRecyclerAdapter;
import com.queuedye.skiamerica.viewmodel.MainViewModel;
import java.util.ArrayList;

/**
 * Simple fragment class to inflate a fragment
 */
public class MainFragment extends Fragment {


  private ListView listView;
  private MainViewModel viewModel;
  private ArrayList<SkiResort> skiResorts = new ArrayList<>();
  private RecyclerView recyclerView;

  /**
   * Inflates the main fragment in the specified container
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return {@link View}
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    recyclerView = (RecyclerView) view.findViewById(R.id.ski_resort_list);
    viewModel.getResorts().observe(this, resorts -> {
      SkiResortRecyclerAdapter newAdapter = new SkiResortRecyclerAdapter((ArrayList) resorts);
      recyclerView.setAdapter(newAdapter);
      recyclerView.getAdapter().notifyDataSetChanged();
      view.invalidate();
//      skiResorts.addAll(resorts);
//      recyclerView = (RecyclerView) view.findViewById(R.id.ski_resort_list);
//      SkiResortRecyclerAdapter adapter = new SkiResortRecyclerAdapter(skiResorts);
//      recyclerView.setAdapter(adapter);
//      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    });
    return view;
  }

  /**
   * Currently does not do anything other than calling the onViewCreated Super method.
   * @param view
   * @param savedInstanceState
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
