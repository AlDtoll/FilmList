package com.example.filmlist.network;

import com.example.filmlist.BuildConfig;
import com.example.filmlist.common.ConstantEnum;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Класс, предоставляющий апи для взаимодействия с сервером
 */
public class MyRetrofit {

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

    private static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ConstantEnum.BASE_URL.getCode())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public static FilmsApi filmsApi = retrofit.create(FilmsApi.class);

    private MyRetrofit() {
    }
}