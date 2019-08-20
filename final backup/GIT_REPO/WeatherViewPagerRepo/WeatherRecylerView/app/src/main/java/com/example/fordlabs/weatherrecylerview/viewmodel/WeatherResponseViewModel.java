package com.example.fordlabs.weatherrecylerview.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class WeatherResponseViewModel extends BaseObservable {

    private String cityName;

    private String weather;

    private String pressure;

    private String temperature;

    @Bindable
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Bindable
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Bindable
    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
    @Bindable
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
