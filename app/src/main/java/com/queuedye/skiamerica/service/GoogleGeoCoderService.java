package com.queuedye.skiamerica.service;

import com.queuedye.skiamerica.BuildConfig;
import com.queuedye.skiamerica.model.entity.SkiResort;
import com.queuedye.skiamerica.model.pojo.Coordinates;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleGeoCoderService {

  static GoogleGeoCoderService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @GET("json/")
  Single<Coordinates> getCoordinates(@Query("address") String address, @Query("key") String key);

  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
