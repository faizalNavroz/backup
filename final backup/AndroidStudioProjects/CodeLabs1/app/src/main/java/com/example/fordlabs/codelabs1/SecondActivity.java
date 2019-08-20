package com.example.fordlabs.codelabs1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void sendMail(View view){
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        EditText to = findViewById(R.id.to);
        EditText subject = findViewById(R.id.subject);
        EditText mailBody = findViewById(R.id.mailBody);


        mailIntent.putExtra(Intent.EXTRA_EMAIL,to.getText().toString());
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
        mailIntent.putExtra(Intent.EXTRA_TEXT,mailBody.getText().toString());
        mailIntent.setType("text/plain");
        startActivity(mailIntent);
    }

}
