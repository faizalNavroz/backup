package com.example.fordlabs.weatherlist;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;


import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.fordlabs.weatherlist.model.WeatherResponse;
import com.example.fordlabs.weatherlist.network.ApiClient;
import com.example.fordlabs.weatherlist.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeatherViewModel extends BaseObservable implements LifecycleObserver{


    String[] rank;
    ApiInterface apiInterface;
    LayoutInflater inflater;

    ObservableField<WeatherResponse>finalList = new ObservableField<WeatherResponse>();

    ObservableField<String>cityNameO=new ObservableField<String>();



   /* @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        Log.d("****","recycled,");
        View view = viewHolder.itemView.getRootView();
        TextView textView = view.findViewById(R.id.rowName);
       // textView.setText(getResponse());
    }*/



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getResponse(){

        rank = new String[]{"1", "2"}; //no of view pager instances needed.

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames ={"London,uk","Chennai"};
        String cityName = "Chennai";

            final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(cityName);

             weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("msg************", response.body().toString());


                if (response.isSuccessful()) {

                    Log.d("***********", response.body().toString());

                    // RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    cityNameO.set(response.body().getName());
                    notifyPropertyChanged(BR._all);

                }
            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("msg", "error");
            }
        });

    }





    private String cityName;

    private String weather;

    private String humidity;



    @Bindable
    public String getCityName() {
        return cityNameO.get();
    }

    @Bindable
    public String getWeather() {
        return weather;
    }

    @Bindable
    public String getHumidity() {
        return humidity;
    }



    public void setCityName(String cityName) {
       //this.setCityName(cityName);
        //notifyPropertyChanged(BR._all);
    }


    public void setWeather(String weather) {
        this.setWeather(weather);
       // notifyPropertyChanged(BR.weather);
    }


    public void setHumidity(String humidity) {
        this.setHumidity(humidity);
        //notifyPropertyChanged(BR.humidity);
    }



}
