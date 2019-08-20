package com.example.fordlabs.recyclertest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.fordlabs.recyclertest.databinding.ActivityMainBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {


    @Inject
    WViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        AndroidInjection.inject(this);

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("FAIZAL");
        stringList.add("BALAJI");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        activityMainBinding.recycler.setLayoutManager(layoutManager);

       // WViewModel viewModel = new WViewModel();
        /*CustomAdapter customAdapter = new CustomAdapter(viewModel);
        activityMainBinding.recycler.setAdapter(customAdapter);*/

        activityMainBinding.setViewModel(viewModel);
        this.getLifecycle().addObserver(viewModel);





    }
}
