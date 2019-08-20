package com.example.fordlabs.bundleexample;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selectFrag(View view){
        Fragment fr =new Fragment();
        if(view.getId() == (R.id.button1)){
            fr = new Fragment1();
        }else if(view == findViewById(R.id.button2)){
            fr = new Fragment2();
        }else{

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_frag_container,fr);
        //fragmentTransaction.replace(R.id.fragment_place,fr);
        fragmentTransaction.commit();
    }
}
