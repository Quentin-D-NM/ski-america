package com.queuedye.skiamerica.service;

import com.queuedye.skiamerica.BuildConfig;
import com.queuedye.skiamerica.model.pojo.GeoLocationResponse;
import com.queuedye.skiamerica.model.pojo.Geometry;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Service class to call the GeoCoder Api
 */
public interface GoogleGeoCoderService {

  /**
   * Gives and Instance of GoogleGeoCoderService
   * @return GoogleGeoCoderService
   */
  static GoogleGeoCoderService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Sends a request and maps the returned object to a GeoLocationRespone
   * @param address
   * @param key
   * @return Single GeoLocationResponse
   */
  @GET("json")
  Single<GeoLocationResponse> getCoordinates(@Query("address") String address, @Query("key") String key);

  /**
   * Simple instance holder class for the {@link GoogleGeoCoderService}
   */
  class InstanceHolder {

    private static final GoogleGeoCoderService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL_GEO_CODER)
          .client(client)
          .build();
      INSTANCE = retrofit.create(GoogleGeoCoderService.class);
    }
  }
}
