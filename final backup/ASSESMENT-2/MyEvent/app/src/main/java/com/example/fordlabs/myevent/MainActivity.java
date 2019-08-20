package com.example.fordlabs.myevent;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {


  public String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        TextView textView = findViewById(R.id.textArea);
        if(getMessage() != null){
            textView.setText(message);
        }
    }


    public void onButtonClick(View view ){
        startActivity(new Intent(this,SecondActivity.class));
    }


    @Subscribe
    public void onMessageEvent(TeamEvent event){

        Toast.makeText(this,event.getTeamName(),Toast.LENGTH_SHORT).show();
        message = String.valueOf(event.getTeamId())+" - "+event.getTeamName()+" - "+String.valueOf(event.getTeamPosition());

        //textView.setText(String.valueOf(event.getTeamId())+" - "+event.getTeamName()+" - "+String.valueOf(event.getTeamPosition()));

    }

/*
    @Subscribe
    public void onMessageEvent(MessageEvent event){
        Toast.makeText(this,event.getMessage(),Toast.LENGTH_SHORT).show();
    }*/



    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  EventBus.getDefault().unregister(this);
    }
}
