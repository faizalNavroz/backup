package com.example.fordlabs.mvvmexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fordlabs.mvvmexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataBinding.setViewModel(new LoginViewModel());
        dataBinding.executePendingBindings();

    }
}
