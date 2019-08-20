package com.example.fordlabs.weatherapp.viewModel;

import android.arch.lifecycle.LifecycleObserver;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.fordlabs.weatherapp.BR;
import com.example.fordlabs.weatherapp.dto.WeatherResponseDto;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    private WeatherResponseDto weatherResponseDto;

    public WeatherViewModel() {
    }

    public WeatherViewModel(WeatherResponseDto weatherDto) {
        weatherResponseDto = new WeatherResponseDto(weatherDto.getCityName(), weatherDto.getWeather(),weatherDto.getHumidity(),weatherDto.getPressure(),weatherDto.getTemperature());

    }

    @Bindable
    public String getCityName() {
        return weatherResponseDto.getCityName();
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

    public void setCityName(String cityName) {
        weatherResponseDto.setWeather(cityName);
        notifyPropertyChanged(BR.cityName);
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

}
