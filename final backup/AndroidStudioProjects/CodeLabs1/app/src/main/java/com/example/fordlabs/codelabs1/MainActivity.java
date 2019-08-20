package com.example.fordlabs.codelabs1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity {

    public Integer num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            Integer number = savedInstanceState.getInt("count");
            TextView editText = findViewById(R.id.textView);

            editText.setText(number.toString());

        }


    }

    public void getToastMessage(View view) {
        Toast.makeText(this, R.string.toast_msg, Toast.LENGTH_SHORT).show();
    }

    public void getIncrement(View view) {
        TextView editText = findViewById(R.id.textView);
        num = Integer.valueOf(editText.getText().toString());
        num++;
        editText.setText(num.toString());


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("message", "This is my message to be reloaded");
        outState.putInt("count", num);
        super.onSaveInstanceState(outState);
    }

    public void sendMail(View view) {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.putExtra(Intent.EXTRA_EMAIL,"sfaizalfarhaan@gmail.com");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,"ANDROID");
        mailIntent.putExtra(Intent.EXTRA_TEXT,"SAMPLE EMAIL");
        mailIntent.setType("text/plain");
        startActivity(mailIntent);

        //Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        //sendIntent.putExtra("sms_body", "default content");
       // sendIntent.setType("vnd.android-dir/mms-sms");
        //startActivity(sendIntent);


    }

    public void getNext(View view){
        Intent secondIntent = new Intent(this,SecondActivity.class);
        startActivity(secondIntent);

    }


}