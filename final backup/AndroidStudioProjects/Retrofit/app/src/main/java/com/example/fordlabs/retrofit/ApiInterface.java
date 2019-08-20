package com.example.fordlabs.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/unknown")
    Call<MultipleResource> getMultipleResource();

}
