package com.queuedye.skiamerica.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.queuedye.skiamerica.model.entity.User;

/**
 * Google Sign In Service class
 */
public class GoogleSignInService {

  private static Application applicationContext;

  private GoogleSignInClient client;
  private MutableLiveData<GoogleSignInAccount> account = new MutableLiveData<>();
  private MutableLiveData<Exception> exception = new MutableLiveData<>();

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        //.requestIdToken()
        .build();
    client = GoogleSignIn.getClient(applicationContext, options);
  }

  /**
   * Sets the context required by a {@link GoogleSignInClient} used by this service.
   *
   * @param applicationContext {@link android.content.Context} used for signing in.
   */
  public static void setApplicationContext(Application applicationContext) {
    GoogleSignInService.applicationContext = applicationContext;
  }

  /**
   * Returns the singleton instance of this service.
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns {@link LiveData} allowing observation of the currently logged-in {@link
   * GoogleSignInAccount}.
   */
  public LiveData<GoogleSignInAccount> getAccount() {
    return account;
  }

  /**
   * Returns {@link LiveData} allowing observation of the most recent {@link Exception} caught
   * while attempting to sign in or out.
   */
  public LiveData<Exception> getException() {
    return exception;
  }

  /**
   * Refreshes the most recently logged-in credentials, if possible.
   *
   * @return asynchronous operation on which completion/success/failures listeners can be set.
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::update)
        .addOnFailureListener(this::update);
  }

  private void update(GoogleSignInAccount account) {
    this.account.setValue(account);
    this.exception.setValue(null);
  }

  private void update(Exception ex) {
    account.setValue(null);
    exception.setValue(ex);
  }

  /**
   * Opens an {@link Activity} displaying Google Sign In controls.
   *
   * @param activity receiver for result of Google Sign In.
   * @param requestCode consumer-specifiable request code, passed back with result; should be
   * checked by receiver.
   */
  public void startSignIn(Activity activity, int requestCode) {
    update((GoogleSignInAccount) null);
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Processes result of Google Sign In operation and returns an asynchronous task.
   *
   * @param data payload of result.
   * @return asynchronous operation on which completion/success/failures listeners can be set.
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      account.setValue(task.getResult(ApiException.class));
    } catch (ApiException e) {
      exception.setValue(e);
    }
    return task;
  }

  /**
   * Initiates sign-out and returns asynchronous task.
   *
   * @return asynchronous operation on which completion/success/failures listeners can be set.
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((account) -> update((GoogleSignInAccount) null));
  }

  private static class InstanceHolder {
    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }
}
