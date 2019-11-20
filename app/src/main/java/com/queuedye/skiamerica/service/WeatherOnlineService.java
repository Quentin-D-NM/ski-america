package com.queuedye.skiamerica.service;

import com.queuedye.skiamerica.BuildConfig;
import com.queuedye.skiamerica.model.pojo.WeatherResponse;
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
 * Service class to call the Ski Weather API
 */
public interface WeatherOnlineService {

  static WeatherOnlineService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Makes a request to the Weather Api and maps the response to a {@link WeatherResponse} object, then returns it
   * @param key
   * @param latLng
   * @param numOfDays
   * @param format
   * @return {@link WeatherResponse}
   */
  @GET("ski.ashx")
  Single<WeatherResponse> getWeather(@Query("key") String key, @Query("q") String latLng,
      @Query("num_of_days") int numOfDays, @Query("format") String format);

  /**
   * Simple instance holder class for the {@link WeatherOnlineService}
   */
  class InstanceHolder {

    private static final WeatherOnlineService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL_SKI_WEATHER)
          .client(client)
          .build();
      INSTANCE = retrofit.create(WeatherOnlineService.class);
    }

  }


}
