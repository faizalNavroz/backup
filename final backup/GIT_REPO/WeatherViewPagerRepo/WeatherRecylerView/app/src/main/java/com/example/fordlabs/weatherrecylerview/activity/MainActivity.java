package com.example.fordlabs.weatherrecylerview.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.fordlabs.weatherrecylerview.R;
import com.example.fordlabs.weatherrecylerview.viewmodel.WeathViewModel;
import com.example.fordlabs.weatherrecylerview.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mainActivityBinding.recyler.setLayoutManager(layoutManager);

        WeathViewModel viewModel = new WeathViewModel();
        mainActivityBinding.setViewModel(viewModel);
        this.getLifecycle().addObserver(viewModel);


    }
}
