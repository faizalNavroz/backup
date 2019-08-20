package com.example.fordlabs.airlinebooking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fordlabs.airlinebooking.databinding.ViewItemBinding;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineItemViewModel;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    AirlineViewModel viewModel;

    public CustomAdapter() {
    }

    ArrayList<AirlineItemViewModel>itemViewModels = new ArrayList<AirlineItemViewModel>();


    public ArrayList<AirlineItemViewModel> getItemViewModels() {
        return itemViewModels;
    }

    public void setItemViewModels(ArrayList<AirlineItemViewModel> itemViewModels) {
        this.itemViewModels = itemViewModels;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("**", "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewItemBinding viewItemBinding = ViewItemBinding.inflate(inflater,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(viewItemBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, int i) {

        if(!itemViewModels.isEmpty()){
            AirlineItemViewModel viewModel = itemViewModels.get(i);
            myViewHolder.itemBinding.setVm(viewModel);
            myViewHolder.itemBinding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }



    public CustomAdapter(AirlineViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ViewItemBinding itemBinding;

        public MyViewHolder(ViewItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
