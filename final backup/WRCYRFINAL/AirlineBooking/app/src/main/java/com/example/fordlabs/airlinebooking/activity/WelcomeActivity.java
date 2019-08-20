package com.example.fordlabs.airlinebooking.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.fordlabs.airlinebooking.databinding.ActivityWelcomeBinding;

import com.example.fordlabs.airlinebooking.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


    }



    public void mainView(View v)
    {

        Intent i = new Intent(getApplicationContext(),MainActivity.class);

        EditText origintext = findViewById(R.id.origin);
        EditText destText = findViewById(R.id.destination);
        EditText dateText = findViewById(R.id.date);


        i.putExtra("origin",origintext.getText().toString());
        i.putExtra("destination",destText.getText().toString());
        i.putExtra("date",dateText.getText().toString());

        startActivity(i);

    }
}
