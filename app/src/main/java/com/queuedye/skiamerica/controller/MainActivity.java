package com.queuedye.skiamerica.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.controller.SkiResortFragment.OnCompleteListener;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.service.GoogleSignInService;
import com.queuedye.skiamerica.view.SkiResortRecyclerAdapter;
import com.queuedye.skiamerica.view.WeatherRecyclerAdapter;
import com.queuedye.skiamerica.viewmodel.MainViewModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnCompleteListener {

  private TextView mTextMessage;
  private ProgressBar waiting;
  private MainViewModel viewModel;
  private GoogleSignInService signInService;
  private ListView listView;
  private WeatherRecyclerAdapter adapter;
  private ArrayList<SkiResort> skiResortList = new ArrayList<>(1);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupViewModel();
    setupSignIn();
    setupUI();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) { //create options menu under the three dots
    getMenuInflater().inflate(R.menu.options, menu);
    return true | super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    switch(item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void signOut() {
    GoogleSignInService.getInstance().signOut()
        .addOnCompleteListener((task) -> {
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        });
  }

  private void setupViewModel() {
    viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel.getSkiResort().observe(this, (skiResort) -> {
      skiResortList.add(skiResort);
    });
  }

  public void setupUI() {
    setContentView(R.layout.activity_main);
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(v -> addSkiResort(null));
  }

  private void setupSignIn() {
    signInService = GoogleSignInService.getInstance();
    signInService.getAccount().observe(this, (account) -> viewModel.setAccount(account));
  }

  private void addSkiResort(SkiResort skiResort) {
    SkiResortFragment fragment = SkiResortFragment.newInstance(skiResort);
    fragment.show(getSupportFragmentManager(), fragment.getClass().getSimpleName());
  }

  @Override
  public void addNewSkiResort(SkiResort skiResort) {
    viewModel.addSkiResort(skiResort);
  }

  private void refreshSignIn(Runnable runnable) {
    waiting.setVisibility(View.VISIBLE);
    signInService.refresh()
        .addOnSuccessListener((account) -> runnable.run())
        .addOnFailureListener((e) -> signOut());
  }
}
