package com.example.fordlabs.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView contentText = findViewById(R.id.contentText);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Log.d("msg***********************","ENTERRRRRRR");


        final Call<MultipleResource> restCall = apiInterface.getMultipleResource();
        restCall.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                MultipleResource multipleResource = response.body();
                String msg = " ";

                Integer text = multipleResource.page;
                Integer total = multipleResource.total;
                Integer totalPages = multipleResource.totalPages;
                msg = text+"****"+total+"****"+totalPages;
                contentText.setText(msg);
                Log.d("msg***********************",msg);

            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
            Log.d("msg","FAILURE**************");
            }
        });

    }

}