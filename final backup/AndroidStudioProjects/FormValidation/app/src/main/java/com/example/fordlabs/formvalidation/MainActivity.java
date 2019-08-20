package com.example.fordlabs.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ValidationService validationService = new ValidationService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view){
        getUserName();
    }

    private void getUserName() {
        String userName = validationService.getUserName(1);
        TextView result = findViewById(R.id.textView3);
        result.setText(userName);

    }
}
