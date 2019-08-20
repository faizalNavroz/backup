package com.example.fordlabs.recyclertest.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fordlabs.recyclertest.R;
import com.example.fordlabs.recyclertest.databinding.ViewNameBinding;
import com.example.fordlabs.recyclertest.viewmodel.NameItemViewModel;
import com.example.fordlabs.recyclertest.viewmodel.NameViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;

    NameViewModel nameViewModel;

    public CustomAdapter(NameViewModel nameViewModel) {
        this.nameViewModel = nameViewModel;
    }

    ArrayList<NameItemViewModel>namesList = new ArrayList<NameItemViewModel>();

    NameItemViewModel bindViewModelObject = new NameItemViewModel();


   @Inject
   public CustomAdapter() {

   }

    public ArrayList<NameItemViewModel> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<NameItemViewModel> namesList) {
        this.namesList = namesList;
    }





    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.view_name,viewGroup,false);*/
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewNameBinding viewNameBinding = DataBindingUtil.inflate(inflater,R.layout.view_name,viewGroup,false);
        return new MyViewHolder(viewNameBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, int i) {
        //myViewHolder.rowItem.setText(namesList.get(i));
       // if(!namesList.isEmpty()){
            NameItemViewModel viewModel = namesList.get(i);
            Log.i("*****", "onBindViewHolder: "+viewModel.getName());
            myViewHolder.viewItemBinding.setViewModel(viewModel);
            myViewHolder.viewItemBinding.executePendingBindings();



       // }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ViewNameBinding viewItemBinding;

        public MyViewHolder(ViewNameBinding viewItemBinding){
            super(viewItemBinding.getRoot());
           this.viewItemBinding = viewItemBinding;
        }

    }
}
