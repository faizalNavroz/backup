package com.example.fordlabs.fmail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent rIntent = getIntent();
        if(rIntent.getAction().equalsIgnoreCase(Intent.ACTION_SEND) && rIntent.getType().equalsIgnoreCase("text/plain")){
            TextView ed1 = findViewById(R.id.rto);
            ed1.setText(rIntent.getStringExtra(Intent.EXTRA_EMAIL));
            TextView ed2 = findViewById(R.id.rsubject);
            ed2.setText(rIntent.getStringExtra(Intent.EXTRA_SUBJECT));
            TextView ed3 = findViewById(R.id.rmailBody);
            ed3.setText(rIntent.getStringExtra(Intent.EXTRA_TEXT));

        }
    }
}
