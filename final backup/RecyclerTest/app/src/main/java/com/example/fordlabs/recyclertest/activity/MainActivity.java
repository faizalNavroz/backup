package com.example.fordlabs.recyclertest.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fordlabs.recyclertest.R;
import com.example.fordlabs.recyclertest.adapter.CustomAdapter;
import com.example.fordlabs.recyclertest.databinding.ActivityMainBinding;
import com.example.fordlabs.recyclertest.viewmodel.NameViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {


    @Inject
    NameViewModel viewModel;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        AndroidInjection.inject(this);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        activityMainBinding.recycler.setLayoutManager(layoutManager);

        NameViewModel viewModel = new NameViewModel();
        CustomAdapter customAdapter = new CustomAdapter(viewModel);
        activityMainBinding.setViewModel(viewModel);
        activityMainBinding.recycler.setAdapter(customAdapter);
        this.getLifecycle().addObserver(viewModel);



    }
}
