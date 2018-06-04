package com.thiovan.crudmahasiswa.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Thio Van on 18/02/2018.
 */

public class APIClient {
    public static final String BASE_URL = "http://192.168.137.1:8080/web/LaraSort/public/";
    private static Retrofit mRetrofit;

    public static Retrofit getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
