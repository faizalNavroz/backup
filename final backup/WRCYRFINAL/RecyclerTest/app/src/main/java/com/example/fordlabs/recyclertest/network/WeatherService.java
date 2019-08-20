package com.example.fordlabs.recyclertest.network;



import com.example.fordlabs.recyclertest.model.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

   @GET("/weather")
   public Observable<WeatherResponse> getWeatherResponse(@Query("q") String q);


}
