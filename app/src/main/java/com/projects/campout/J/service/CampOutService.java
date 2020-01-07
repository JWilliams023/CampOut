package com.projects.campout.J.service;

import com.projects.campout.J.model.api.entity.ResponseWrapper;
import com.projects.campout.J.BuildConfig;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CampOutService {

  String baseUrl = BuildConfig.BASE_URL;


  static CampOutService getInstance(){
    return InstanceHolder.INSTANCE;
  }

  @GET("{venueId}/menu")
  Single<ResponseWrapper> getMenu(@Path("venueId") String venueId,
                                  @Query("client_id") String clientId, @Query("client_secret") String clientSecret,
                                  @Query("v") String date, @Query("ll") String location);


  class InstanceHolder {
        private  static  final CampOutService INSTANCE;

    static {

      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL)
          .client(client) // TODO Leave this out for production.
          .build();
      INSTANCE = retrofit.create(CampOutService.class);

    }
  }

}


