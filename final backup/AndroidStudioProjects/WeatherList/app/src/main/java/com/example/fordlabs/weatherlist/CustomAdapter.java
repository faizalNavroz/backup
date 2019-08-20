package com.example.fordlabs.weatherlist;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fordlabs.weatherlist.model.WeatherResponse;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    public CustomAdapter() {
    }

    Context context;
    ArrayList<String>strList;
    ArrayList<WeatherResponse>finalresponse = new ArrayList<WeatherResponse>();

    public CustomAdapter(Context context,ArrayList<WeatherResponse>weatherResponses) {
        this.context=context;
        this.finalresponse=weatherResponses;
    }

    public CustomAdapter(ArrayList<WeatherResponse> wRes) {
        this.finalresponse = wRes;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(finalresponse.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return finalresponse.size();
    }


    public class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {


        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rowName);
        }
    }
}
