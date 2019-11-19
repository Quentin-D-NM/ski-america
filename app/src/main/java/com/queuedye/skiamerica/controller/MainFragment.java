package com.queuedye.skiamerica.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.queuedye.skiamerica.R;

/**
 * Simple fragment class to inflate a fragment
 */
public class MainFragment extends Fragment {

  private ListView listView;

  /**
   * Inflates the main fragment in the specified container
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    return view;
  }

}
