package com.example.fordlabs.weatherapp.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.fordlabs.weatherapp.model.WeatherResponse;
import com.example.fordlabs.weatherapp.viewModel.WeatherViewModel;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.viewpager_main);

        WeatherViewModel weatherViewModel = new WeatherViewModel();
        this.getLifecycle().addObserver(weatherViewModel);

        //setContentView(R.);







      /*  SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref",0);
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
*/
    }


}