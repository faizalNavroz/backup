package com.example.fordlabs.airlinebooking.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.fordlabs.airlinebooking.BR;
import com.example.fordlabs.airlinebooking.adapter.CustomAdapter;
import com.example.fordlabs.airlinebooking.model.AirlineResponse;
import com.example.fordlabs.airlinebooking.model.Carriers;
import com.example.fordlabs.airlinebooking.network.ApiClient;
import com.example.fordlabs.airlinebooking.network.ApiInterface;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AirlineViewModel extends BaseObservable implements LifecycleObserver {

    private String origin;

    private String destination;

    private String date;

    ApiInterface apiInterface;

    private Integer itemSize = 0;

    public Integer getItemSize() {
        return itemSize;
    }

    ArrayList<AirlineItemViewModel>carriersList = new ArrayList<AirlineItemViewModel>();



    CustomAdapter adapter = new CustomAdapter();

    ObservableField<AirlineResponse>airlineResponse = new ObservableField<AirlineResponse>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getAirlineResponse(){

        this.origin = "SFO=sky";
        this.destination="ORD-sky";
        this.date="2019-09-01";

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        apiInterface.getAirlineResponse(this.getOrigin(),this.getDestination(),this.getDate()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AirlineResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AirlineResponse value) {



                Log.i("************", "onNext: "+value.getCarriers().get(0).toString());

                for(Carriers carriers : value.getCarriers()){
                    AirlineItemViewModel itemViewModel = new AirlineItemViewModel();
                    itemViewModel.setCarrierId(carriers.getCarrierId().toString());
                    itemViewModel.setName(carriers.getCarrierName());
                    carriersList.add(itemViewModel);
                    itemSize++;
                }

                adapter.setItemViewModels(carriersList);
                notifyPropertyChanged(BR._all);
                Log.i("************", "onNext: "+carriersList.get(0).getName());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



    }

    public CustomAdapter getAdapter() {
        return adapter;
    }



    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
