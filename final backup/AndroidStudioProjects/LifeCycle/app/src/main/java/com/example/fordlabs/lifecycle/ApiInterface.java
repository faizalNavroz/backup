package com.example.fordlabs.lifecycle;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


        @GET("/api/unknown")
        Call<MultipleResource> doGetListResources();
}
