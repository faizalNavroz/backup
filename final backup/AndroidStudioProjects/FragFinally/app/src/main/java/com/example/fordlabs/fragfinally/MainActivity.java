package com.example.fordlabs.fragfinally;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get fragmnet 1 by default
        FragmentManager fmgr = getSupportFragmentManager();
        FragmentTransaction ftxn = fmgr.beginTransaction();
        ftxn.replace(R.id.frameLayout,new Fragment1());
        ftxn.commit();

    }

    
}
