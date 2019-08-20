package com.example.fordlabs.weatherapp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fordlabs.weatherapp.R;
import com.example.fordlabs.weatherapp.adapter.MyPagerAdapter;
import com.example.fordlabs.weatherapp.model.WeatherResponse;
import com.example.fordlabs.weatherapp.network.ApiClient;
import com.example.fordlabs.weatherapp.network.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

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
        setContentView(R.layout.viewpager_main);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
       final SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();

        rank = new String[]{"1", "2"}; //no of view pager instances needed.

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames ={"London,uk","Chennai"};
        ArrayList<WeatherResponse> cachedWeatherResponseList = new ArrayList<WeatherResponse>();

       // sharedPrefEditor.put("responseList",weatherResponseObjList);
        if(1== 0 &&  !sharedPref.getString("weatherResponse","").isEmpty()) {
            Gson gson = new Gson();
            String json = sharedPref.getString("weatherResponse", "");
            Log.d("********************************",json);

            Type listType = new TypeToken<List<WeatherResponse>>() {}.getType();
            cachedWeatherResponseList = gson.fromJson(json, listType);

            //inflate the view pager from the data coming from cache
            viewPager = (ViewPager)findViewById(R.id.pager);
            // Pass results to ViewPagerAdapter Class
            adapter = new MyPagerAdapter(SecondActivity.this, rank, cachedWeatherResponseList);
            // Binds the Adapter to the ViewPager
            viewPager.setAdapter(adapter);
        }else {

                for(String city : cityNames){

                    final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(city);

                    weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                        @Override
                        public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                            Log.d("msg************", response.body().toString());
                            if (response.isSuccessful()) {
                                setResouceForViewPager(response,sharedPrefEditor);

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




       public  void setResouceForViewPager(Response<WeatherResponse> response,SharedPreferences.Editor sharedPrefEditor) {
           if(null != response){
               weatherResponseObjList.add(response.body());
           }

           //pushing the list of weather response to cache first time
           Gson gson = new Gson();
           String json = gson.toJson(weatherResponseObjList);
           sharedPrefEditor.putString("weatherResponse", json);
           sharedPrefEditor.commit();


           if(weatherResponseObjList.size() == 2){
               viewPager = (ViewPager)findViewById(R.id.pager);
               // Pass results to ViewPagerAdapter Class
               adapter = new MyPagerAdapter(SecondActivity.this, rank, weatherResponseObjList);
               // Binds the Adapter to the ViewPager
               viewPager.setAdapter(adapter);
           }

        }

    }


