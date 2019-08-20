package com.example.fordlabs.datab;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fordlabs.datab.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemperatureData temperatureData = new TemperatureData(new ObservableField<String>("ZERO"),"Chennai");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setTemp(temperatureData);
        binding.executePendingBindings();

    }
}
