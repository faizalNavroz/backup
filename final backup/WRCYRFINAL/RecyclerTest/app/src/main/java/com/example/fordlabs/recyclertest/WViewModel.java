package com.example.fordlabs.recyclertest;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.fordlabs.recyclertest.model.WeatherResponse;
import com.example.fordlabs.recyclertest.network.ApiClient;
import com.example.fordlabs.recyclertest.network.WeatherService;
import com.example.fordlabs.recyclertest.network.WeatherServiceImpl;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WViewModel extends BaseObservable implements LifecycleObserver {

    ArrayList<WItemViewModel> stringList = new ArrayList<WItemViewModel>();

   // CustomAdapter adapter = new CustomAdapter();



    @Inject
    public WViewModel() {
    }

    @Inject
    WeatherServiceImpl weatherService;

    @Inject
    CustomAdapter adapter;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

       String []cityNames = {"Chennai,in","London,uk","Pune","in","Auckland,nz"};
        WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();

        for(String city : cityNames){
            weatherService.getWeatherResponse(city).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<WeatherResponse>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(WeatherResponse weatherResponse) {
                    WItemViewModel itemViewModel = new WItemViewModel();
                    itemViewModel.setName(weatherResponse.getName());
                    stringList.add(itemViewModel);
                    notifyPropertyChanged(BR._all);
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        }

        adapter.setNamesList(stringList);
    }

    public CustomAdapter getAdapter() {
        return adapter;
    }
}
