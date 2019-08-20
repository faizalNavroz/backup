package com.example.fordlabs.weatherrecylerview.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.fordlabs.weatherrecylerview.BR;
import com.example.fordlabs.weatherrecylerview.adapter.CustomAdapter;
import com.example.fordlabs.weatherrecylerview.model.WeatherResponse;
import com.example.fordlabs.weatherrecylerview.network.ApiClient;
import com.example.fordlabs.weatherrecylerview.network.ApiInterface;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeathViewModel extends BaseObservable implements LifecycleObserver {


    public static final String TAG="MSG";
    ApiInterface apiInterface;

    ArrayList<WeatherResponseViewModel>weatherResponseArrayList = new ArrayList<WeatherResponseViewModel>();


    CustomAdapter weathAdapter = new CustomAdapter();

    @Bindable
    public String getName(){
        return weatherResponseArrayList != null ? weatherResponseArrayList.get(0).getCityName():new String(" ");
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public  void getWeatherResponse(){

       Log.i(TAG, "getWeatherResponse: ");

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames = {"Chennai,in","London,uk","Madurai,in","Delhi,in","Mumbai,in"};

        for(String city : cityNames){
            Call<WeatherResponse> weatherResponseCall= apiInterface.getWeatherResponse(city);
            weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                    if(null != response) {
                        WeatherResponseViewModel wRes = new WeatherResponseViewModel();
                        wRes.setCityName(response.body().getName());
                        wRes.setPressure("Pressure : "+String.valueOf(response.body().getMain().getPressure()));
                        wRes.setWeather("Weather : "+response.body().getWeather().get(0).getDescription());
                        DecimalFormat f = new DecimalFormat("##.00");
                        wRes.setTemperature(String.valueOf(f.format(response.body().getMain().getTemp() - 273.15))+"°C");
                        weatherResponseArrayList.add(wRes);
                        weathAdapter.setWeatherResponses(weatherResponseArrayList);
                        notifyPropertyChanged(BR._all);
                    }

                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {

                }
            });
        }



    }

    public CustomAdapter getWeathAdapter() {
        return weathAdapter;
    }
}
