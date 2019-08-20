package com.example.fordlabs.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.fordlabs.lifecycle.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel123 extends BaseObservable implements LifecycleObserver {

    ApiInterface apiInterface;

    MultipleResource multipleResource = new MultipleResource();

    private static final String TAG = "LoginViewModel123";

//    public String total="10";

    public LoginViewModel123() {
    }


    ObservableField<MultipleResource> myMultipleResource = new ObservableField<MultipleResource>();


    public LoginViewModel123(Integer multipleResource) {
        this.multipleResource.total = multipleResource;

        this.myMultipleResource.set(new MultipleResource());
    }


    @Bindable
    public String getTotal() {
        Log.i(TAG, "getTotal: ");
        return myMultipleResource.get().total.toString();
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onStart(){
        Log.d("*******","IN OBSERVER");

        apiInterface = APICLient.getClient().create(ApiInterface.class);


        Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {

                if(response.isSuccessful()){
                    Log.d("*********",response.body().toString());
                    Log.i("Lifecycle", "onResponse: ="+response.body().total.toString());
                    myMultipleResource.set(response.body());
                    notifyPropertyChanged(BR._all);
                }

            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });


    }


}