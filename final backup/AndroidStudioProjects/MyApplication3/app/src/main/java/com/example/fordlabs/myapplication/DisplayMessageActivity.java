package com.example.fordlabs.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);

        //get the message from intent
        Intent receivedIntent = getIntent();
        String receivedMessage = receivedIntent.getStringExtra("MESSAGE");

        //set the received value in screen 2
        TextView textMsgView = findViewById(R.id.textView);
        textMsgView.setText(receivedMessage);


    }


}
