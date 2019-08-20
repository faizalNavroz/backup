package com.example.fordlabs.airlinebooking.network;


import android.databinding.ObservableField;

import com.example.fordlabs.airlinebooking.model.AirlineResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AirlineService {


    ObservableField<AirlineResponse> weatherResponseObservable = new ObservableField<AirlineResponse>();

    public Observable<AirlineResponse> getWeatherResponse(String originCity,String destination) {

        return null;
    }
}