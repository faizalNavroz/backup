package com.example.fordlabs.retwithrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<String>users;

    public CustomAdapter(Context context, ArrayList<String> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rowView = LayoutInflater.from(viewGroup.getContext())

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView row;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);
            row = itemView.findViewById(R.id.text);

        }

    }
}