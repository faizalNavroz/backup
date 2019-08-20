package com.example.fordlabs.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fMgr = getSupportFragmentManager();
        FragmentTransaction fTxn = fMgr.beginTransaction();
        fTxn.replace(R.id.listFrame,new ListFragment());
        fTxn.commit();
    }

    public void switchContent(int textFrame, Fragment fragment2) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(textFrame,fragment2);
        ft.addToBackStack(null);
        ft.commit();
    }
}
