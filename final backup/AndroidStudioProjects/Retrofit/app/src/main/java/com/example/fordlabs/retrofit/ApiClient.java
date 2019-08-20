package com.example.fordlabs.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://reqres.in")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }

        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        ApiClient.retrofit = retrofit;
    }
}
