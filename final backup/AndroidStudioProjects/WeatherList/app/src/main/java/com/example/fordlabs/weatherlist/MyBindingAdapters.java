package com.example.fordlabs.weatherlist;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBindingAdapters {


    @BindingAdapter("textViewChanger")
    public static void setTextViewChanger(TextView t ,String text){
        Log.i("", "setTextViewChanger: ");
    }
}
