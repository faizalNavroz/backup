package com.example.fordlabs.weatherapp.viewModel;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.example.fordlabs.weatherapp.BR;
import com.example.fordlabs.weatherapp.R;
import com.example.fordlabs.weatherapp.activity.SecondActivity;
import com.example.fordlabs.weatherapp.adapter.MyPagerAdapter;
import com.example.fordlabs.weatherapp.dto.WeatherResponseDto;
import com.example.fordlabs.weatherapp.model.Main;
import com.example.fordlabs.weatherapp.model.Weather;
import com.example.fordlabs.weatherapp.model.WeatherResponse;
import com.example.fordlabs.weatherapp.network.ApiClient;
import com.example.fordlabs.weatherapp.network.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

     WeatherResponseDto weatherResponseDto = new WeatherResponseDto();

    public ArrayList<WeatherResponse> weatherResponseObjList = new ArrayList<WeatherResponse>();

    String[] rank;

    ApiInterface apiInterface;
    TextView base;
    TextView timezone;
    TextView name;

    ViewPager viewPager ;
    MyPagerAdapter adapter;
    WeatherResponse weatherResponse;

    ObservableField<String>myCityName = new ObservableField<String>();


    /*public WeatherViewModel(WeatherResponseDto weatherDto) {
        this.weatherResponseDto = new WeatherResponseDto();
      //  weatherResponseDto = new WeatherResponseDto(weatherDto.getCityName(), weatherDto.getWeather(),weatherDto.getHumidity(),weatherDto.getPressure(),weatherDto.getTemperature());

    }
*/
    public WeatherViewModel() {
        this.myCityName.set(new String("HAWAI"));

    }

    public void setCityName(String cityName) {
        //weatherResponseDto.setWeather(cityName);
        notifyPropertyChanged(BR.cityName);
    }


    @Bindable
    public String getCityName() {

        return myCityName.get();
    }



    @Bindable
    public String getWeather() {
        return weatherResponseDto.getWeather();
    }

    @Bindable
    public String getHumidity() {
        return weatherResponseDto.getHumidity();
    }

    @Bindable
    public String getPressure() {
        return weatherResponseDto.getPressure();
    }

    @Bindable
    public String getTemperature() {
        return weatherResponseDto.getTemperature();
    }




    public void setWeather(String weather) {
        weatherResponseDto.setWeather(weather);
       notifyPropertyChanged(BR.weather);
    }


    public void setHumidity(String humidity) {
        weatherResponseDto.setHumidity(humidity);
        notifyPropertyChanged(BR.humidity);
    }


    public void setPressure(String pressure) {
        weatherResponseDto.setPressure(pressure);
        notifyPropertyChanged(BR.pressure);
    }



    public void setTemperature(String temperature) {
        weatherResponseDto.setTemperature(temperature);
         notifyPropertyChanged(BR.temperature);
    }


    //@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void  getFinal(String cityName){


        rank = new String[]{"1", "2"}; //no of view pager instances needed.

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames ={"London,uk","Chennai"};


        // sharedPrefEditor.put("responseList",weatherResponseObjList);
        if(1== 0) {

        }else {

            for(String city : cityNames){

                final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(cityName);

                weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        Log.d("msg************", response.body().toString());


                        if (response.isSuccessful()) {

                            DecimalFormat df = new DecimalFormat("0.00");
                            List<Weather>weatherList = response.body().getWeather();
                            Main main = response.body().getMain();
                            Double celsius = main.getTemp()-273;
                            WeatherResponseDto dto = new WeatherResponseDto();

                            weatherResponseDto.setCityName(response.body().getName());
                            weatherResponseDto.setWeather(weatherList.get(0).getDescription());
                            weatherResponseDto.setHumidity(String.valueOf(main.getHumidity()));
                            weatherResponseDto.setPressure(String.valueOf(main.getPressure()));
                            weatherResponseDto.setTemperature(df.format(celsius)+" C");

                            myCityName.set(weatherResponseDto.getCityName());
                            notifyPropertyChanged(BR._all);

                            //setCityName(weatherDto.getCityName());



                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.d("msg", "error");
                    }
                });

            }

        }

    }

    //@OnLifecycleEvent(Lifecycle.Event.ON_START)


}
