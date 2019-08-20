package com.example.fordlabs.lifecycle;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.fordlabs.lifecycle.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginViewModel123 vml = new LoginViewModel123(0);
        getLifecycle().addObserver(vml);
        Log.d("MSG","END");

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(vml);
//        activityMainBinding.executePendingBindings();
    }



}
