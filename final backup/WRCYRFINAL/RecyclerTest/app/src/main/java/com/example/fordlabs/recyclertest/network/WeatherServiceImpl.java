package com.example.fordlabs.recyclertest.network;

import com.example.fordlabs.recyclertest.model.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Observable;


public class WeatherServiceImpl {

    @Inject
    public WeatherServiceImpl() {
    }


    @Inject
    WeatherService weatherService;

    public Observable<WeatherResponse> getWeatherResponse(String cityName){
        return weatherService.getWeatherResponse(cityName);
    }
}
