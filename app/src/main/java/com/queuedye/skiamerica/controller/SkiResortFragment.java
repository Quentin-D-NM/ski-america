package com.queuedye.skiamerica.controller;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.model.entity.SkiResort;

/**
 * Simple Dialog fragment to allow the user to insert Ski Resort Info
 */
public class SkiResortFragment extends DialogFragment {

  private EditText skiResortName;
  private EditText skiResortAddress;
  private SkiResort skiResort;

  /**
   * Creates a new instance of SkiResortFragment
   * @param skiResort
   * @return SkiResortFragment Instance
   */
  public static SkiResortFragment newInstance(SkiResort skiResort) {
    SkiResortFragment fragment = new SkiResortFragment();
    Bundle args = new Bundle();
    if (skiResort != null) {
      args.putSerializable("skiResort", skiResort);
    }
    fragment.setArguments(args);
    return fragment;
  }

  /**
   * Setup and Creation of Dialog Fragment for taking inputs
   * @param savedInstanceState
   * @return {@link Dialog}
   */
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
          populateSkiResort();
        })
        .create();
  }

  private void populateSkiResort() {
    if (skiResort == null) {
      skiResort = new SkiResort();
      skiResort.setAddress(skiResortAddress.getText().toString().trim());
      skiResort.setName(skiResortName.getText().toString().trim());
    }
    ((OnCompleteListener) getActivity()).addNewSkiResort(skiResort);
  }

  /**
   * calls the super show method to make the Dialog visible
   * @param transaction
   * @param tag
   * @return int
   */
  @Override
  public int show(@NonNull FragmentTransaction transaction, @Nullable String tag) {
    return super.show(transaction, tag);
  }

  /**
   * On Completion of the entering of info you pass the object to the abstract addNewSkiResort
   */
  @FunctionalInterface
  public interface OnCompleteListener {

    void addNewSkiResort(SkiResort skiResort);
  }
}
