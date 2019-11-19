package com.queuedye.skiamerica.controller;

import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.queuedye.skiamerica.R;
import com.queuedye.skiamerica.service.GoogleSignInService;

/**
 * Simple {@link AppCompatActivity} subclass, displaying a button and transferring control to Google
 * Sign In, switching to {@link MainActivity}
 */
public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  private GoogleSignInService service;

  /**
   * Attempting to refresh google sign in and switching to {@link MainActivity} if successful,
   * otherwise displaying a google sign in button
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    service = GoogleSignInService.getInstance();
    service.refresh()
        .addOnSuccessListener((account) -> switchToMain())
        .addOnFailureListener((ex) -> {
          setContentView(R.layout.activity_login);
          findViewById(R.id.sign_in).setOnClickListener((view) ->
              service.startSignIn(this, LOGIN_REQUEST_CODE));
        });
  }

  /**
   * Receives result returned from {@link #startActivityForResult(Intent, int)}, checking Google
   * Sign In result if appropriate.
   * @param requestCode
   * @param resultCode
   * @param data
   */
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if(requestCode == LOGIN_REQUEST_CODE) {
      service.completeSignIn(data)
          .addOnSuccessListener((account) -> switchToMain())
          .addOnFailureListener((ex) ->
              Toast.makeText(this, R.string.login_failure_message, Toast.LENGTH_LONG).show());
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  /**
   * If login was successful this method is called to switch to the {@link MainActivity}
   */
  private void switchToMain() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }
}
