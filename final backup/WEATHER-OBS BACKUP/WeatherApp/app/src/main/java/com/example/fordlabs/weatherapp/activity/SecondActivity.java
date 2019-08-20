package com.example.fordlabs.weatherapp.activity;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fordlabs.weatherapp.R;
import com.example.fordlabs.weatherapp.adapter.MyPagerAdapter;
import com.example.fordlabs.weatherapp.dto.WeatherResponseDto;
import com.example.fordlabs.weatherapp.model.WeatherResponse;
import com.example.fordlabs.weatherapp.network.ApiClient;
import com.example.fordlabs.weatherapp.network.ApiInterface;
import com.example.fordlabs.weatherapp.viewModel.WeatherViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity  {

    //ApiClient apiClient;
    ArrayList<WeatherResponse> weatherResponseObjList = new ArrayList<WeatherResponse>();

    String[] rank;

    ApiInterface apiInterface;
    TextView base;
    TextView timezone;
    TextView name;

    ViewPager viewPager ;
    MyPagerAdapter adapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.viewpager_main);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
       final SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();

        rank = new String[]{"1", "2"}; //no of view pager instances needed.

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames ={"London,uk","Chennai"};

        WeatherViewModel vm = new WeatherViewModel();
        getLifecycle().addObserver(vm);

       // sharedPrefEditor.put("responseList",weatherResponseObjList);
        viewPager = (ViewPager)findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new MyPagerAdapter(SecondActivity.this, rank, cityNames);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);*/

        setContentView(R.layout.viewpager_main);
        WeatherViewModel vm = new WeatherViewModel();
        getLifecycle().addObserver(vm);
        rank = new String[]{"1", "2"};
        String [] cityNames ={"London,uk","Chennai"};
        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new MyPagerAdapter(SecondActivity.this, rank, cityNames);
        viewPager.setAdapter(adapter);

    }






       public  void setResouceForViewPager(Response<WeatherResponse> response,SharedPreferences.Editor sharedPrefEditor) {
           if(null != response){
               weatherResponseObjList.add(response.body());
           }

           //pushing the list of weather response to cache first time
           /*Gson gson = new Gson();
           String json = gson.toJson(weatherResponseObjList);
           sharedPrefEditor.putString("weatherResponse", json);
           sharedPrefEditor.commit();*/


           if(weatherResponseObjList.size() == 2){
               viewPager = (ViewPager)findViewById(R.id.pager);
               // Pass results to ViewPagerAdapter Class
             //  adapter = new MyPagerAdapter(SecondActivity.this, rank, weatherResponseObjList);
               // Binds the Adapter to the ViewPager
               viewPager.setAdapter(adapter);
           }

        }

    }


