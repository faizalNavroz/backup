package com.example.fordlabs.weatherrecylerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fordlabs.weatherrecylerview.viewmodel.WeathViewModel;
import com.example.fordlabs.weatherrecylerview.viewmodel.WeatherResponseViewModel;
import com.example.fordlabs.weatherrecylerview.databinding.ViewItemBinding;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    WeathViewModel weathViewModel;

    ArrayList<WeatherResponseViewModel>weatherResponses = new ArrayList<WeatherResponseViewModel>();

    public CustomAdapter() {
    }

    public void setWeatherResponses(ArrayList<WeatherResponseViewModel> weatherResponses) {
        this.weatherResponses = weatherResponses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewItemBinding viewItemBinding = ViewItemBinding.inflate(inflater,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(viewItemBinding);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if(!weatherResponses.isEmpty()){
            WeatherResponseViewModel viewModel = weatherResponses.get(i);
            myViewHolder.setViewData(viewModel);
        }

    }

    @Override
    public int getItemCount() {
        return weatherResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ViewItemBinding itemBinding;

        public MyViewHolder(ViewItemBinding itemBinding){
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void setViewData(WeatherResponseViewModel wViewModel){
            itemBinding.setVm(wViewModel);
            itemBinding.executePendingBindings();

        }
    }
}
