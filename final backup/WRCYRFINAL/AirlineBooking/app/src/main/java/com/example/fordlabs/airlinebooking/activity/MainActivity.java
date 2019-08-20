package com.example.fordlabs.airlinebooking.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.fordlabs.airlinebooking.R;
import com.example.fordlabs.airlinebooking.adapter.CustomAdapter;
import com.example.fordlabs.airlinebooking.databinding.ActivityMainBinding;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        AirlineViewModel viewModel = new AirlineViewModel();

        String origin = getIntent().getExtras().getString("origin");
        String destination = getIntent().getExtras().getString("destination");
        String date = getIntent().getExtras().getString("date");

       Log.i("Main", "onCreate: "+origin+destination+date);
        viewModel.setDate(date);
        viewModel.setDestination(destination);
        viewModel.setOrigin(origin);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyler.setLayoutManager(layoutManager);

        CustomAdapter adapter = new CustomAdapter();
        activityMainBinding.setViewModel(viewModel);
        activityMainBinding.recyler.setAdapter(adapter);
        this.getLifecycle().addObserver(viewModel);




    }
}
