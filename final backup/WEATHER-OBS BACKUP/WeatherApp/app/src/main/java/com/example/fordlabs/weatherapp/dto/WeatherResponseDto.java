package com.example.fordlabs.weatherapp.dto;

public class WeatherResponseDto {


    private String cityName;

    private String weather;

    private String humidity;

    private String pressure;

    private String temperature;



    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    public WeatherResponseDto() {
    }

    public String getCityName() {
        return cityName;

    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public WeatherResponseDto(String cityName, String weather, String humidity, String pressure, String temperature) {
        this.cityName=cityName;

        this.weather = weather;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
    }
}
