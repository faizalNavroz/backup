package com.example.fordlabs.recyclertest.dependencyInjection;


import com.example.fordlabs.recyclertest.network.ApiClient;
import com.example.fordlabs.recyclertest.network.WeatherService;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static String url ="https://community-open-weather-map.p.rapidapi.com";

    @Provides
    @Singleton
    public static Retrofit getRetrofit(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("X-RapidAPI-Key", "f3bf0c39ddmshde043f2e5ee394bp1d90abjsnf31149a1768f")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });


        OkHttpClient client = httpClient.build();

        return  new Retrofit.Builder().baseUrl(url).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(client).build();

    }


    @Provides
    @Singleton
    WeatherService providesWeatherService(Retrofit retrofit){
        return retrofit.create(WeatherService.class);
    }
}
