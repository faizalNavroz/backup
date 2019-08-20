package com.example.fordlabs.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       /* EventBus.getDefault().register(this);*/
    }

    public void addMessage(View view){

        EditText editText1 = findViewById(R.id.teamNumber);
        EditText editText2 = findViewById(R.id.teamName);
        EditText editText3 = findViewById(R.id.teamPos);

        EventBus.getDefault().post(new TeamEvent(Integer.valueOf(editText1.getText().toString()),editText2.getText().toString(),Integer.valueOf(editText3.getText().toString())));

        startActivity(new Intent(this,MainActivity.class));
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onTeamEvent(TeamEvent event){
        TextView textView = findViewById(R.id.finalText);
        textView.setText(event.getTeamName());
    }*/

}
