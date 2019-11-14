package com.queuedye.skiamerica.controller;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;

public class SkiResortFragment extends DialogFragment {

  private EditText skiResortName;
  private EditText skiResortAddress;
  private SkiResort skiResort;

  public static SkiResortFragment newInstance(SkiResort skiResort) {
    SkiResortFragment fragment = new SkiResortFragment();
    Bundle args = new Bundle();
    if (skiResort != null) {
      args.putSerializable("skiResort", skiResort);
    }
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.ski_resort_fragment, null);
    skiResortAddress = view.findViewById(R.id.ski_resort_address);
    skiResortName = view.findViewById(R.id.ski_resort_name);
    skiResort = (SkiResort) getArguments().getSerializable("SkiResort");
    return new Builder(getContext())
        .setTitle("Add Ski Resort")
        .setView(view)
        .setNegativeButton("Cancel", (dialog, button) -> {
        })
        .setPositiveButton("Ok", (dialog, button) -> {

        })
        .create();
  }
}
