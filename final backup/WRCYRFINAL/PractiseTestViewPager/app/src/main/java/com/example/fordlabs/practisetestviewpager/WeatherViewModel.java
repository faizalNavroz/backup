package com.example.fordlabs.practisetestviewpager;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    ObservableField<String>name = new ObservableField<String>();

    private String cityName;

    @Bindable
    public String getCityName() {
        return name.get();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.i("*******", "onCreate: ");
        name.set("FAIZAL");
        notifyPropertyChanged(BR._all);
    }

    public void onSwipe(int pos){
        name.set("BALAJI");
        notifyPropertyChanged(BR._all);
    }
}
