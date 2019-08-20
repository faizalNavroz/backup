package com.example.fordlabs.weatherlist;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fordlabs.weatherlist.databinding.ActivityMainBinding;
import com.example.fordlabs.weatherlist.databinding.ItemRowBinding;
import com.example.fordlabs.weatherlist.model.WeatherResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String>strList = new ArrayList<String>();
        strList.add("a");
        strList.add("b");

       WeatherViewModel weatherViewModel = new WeatherViewModel();
        this.getLifecycle().addObserver(weatherViewModel);

       RecyclerView recyclerView = findViewById(R.id.recyclerView);

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
       // recyclerView.setLayoutManager(layoutManager);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,strList);*/
        /*adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                Log.d("CHANGED***********","www");
            }
        });*/

        ItemRowBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.item_row);
        activityMainBinding.setViewModel(weatherViewModel);

        /*ArrayList<WeatherResponse>finalList = new  ArrayList<WeatherResponse>();
        CustomAdapter adapter = new CustomAdapter(MainActivity.this,weatherViewModel.get);
        recyclerView.setAdapter(adapter);*/





    }
}
