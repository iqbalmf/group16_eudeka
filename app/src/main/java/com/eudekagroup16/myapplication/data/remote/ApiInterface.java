package com.eudekagroup16.myapplication.data.remote;

import com.eudekagroup16.myapplication.model.Domains;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/search")
    Call<Domains> getAllDomains(@Query("query") String search);
}
