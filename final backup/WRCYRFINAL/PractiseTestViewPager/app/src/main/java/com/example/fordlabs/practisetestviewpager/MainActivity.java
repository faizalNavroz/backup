package com.example.fordlabs.practisetestviewpager;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fordlabs.practisetestviewpager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //setContentView(R.layout.activity_main);

        WeatherViewModel viewModel = new WeatherViewModel();
        CustomAdapter adapter = new CustomAdapter(viewModel);

        activityMainBinding.viewPager.setAdapter(adapter);
        activityMainBinding.setViewModel(viewModel);

        this.getLifecycle().addObserver(viewModel);




    }
}
