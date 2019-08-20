package com.example.fordlabs.spinnerexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fordlabs.spinnerexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        final List<String> namesList = new  ArrayList<String>();
        namesList.add("FAIZAL");
        namesList.add("BALAJI");

        ArrayAdapter<String>nameAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item ,namesList);

        nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner);
        
        mainBinding.spinner.setAdapter(nameAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = findViewById(R.id.textView);
                textView.setText(namesList.get(position));
                Toast.makeText(getApplicationContext(),namesList.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    } 
}
