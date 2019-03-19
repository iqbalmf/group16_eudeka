package com.eudekagroup16.myapplication.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.domainsdb.info")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}

