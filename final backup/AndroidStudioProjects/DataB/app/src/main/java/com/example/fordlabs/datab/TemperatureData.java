package com.example.fordlabs.datab;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;

public class TemperatureData extends BaseObservable {
    private ObservableField<String> celsius;

    private String location;

    @Bindable
    public String getLocation() {
        return location;
    }

    public TemperatureData(ObservableField<String>  celsius, String location) {
        this.celsius = celsius;
        this.location = location;
    }

    public void setLocation(String location) {
        Log.d("msg",location);
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public ObservableField<String>  getCelsius() {
        return celsius;
    }

    public void setCelsius(ObservableField<String>  celsius) {
        this.celsius = celsius;
    }
}
