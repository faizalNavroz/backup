package com.example.fordlabs.recyclertest;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fordlabs.recyclertest.databinding.ViewItemBinding;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;

    ArrayList<WItemViewModel>namesList = new ArrayList<WItemViewModel>();

    WItemViewModel bindViewModelObject = new WItemViewModel();

   /* @Inject
    public CustomAdapter(WViewModel viewModel) {

    }

*/
   @Inject
   public CustomAdapter() {

   }

    public ArrayList<WItemViewModel> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<WItemViewModel> namesList) {
        this.namesList = namesList;
    }

   /* public CustomAdapter(Context context, ArrayList<String> stringList) {
        this.context=context;

    }*/




    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.view_item,viewGroup,false);*/
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewItemBinding viewItemBinding = DataBindingUtil.inflate(inflater,R.layout.view_item,viewGroup,false);
        return new MyViewHolder(viewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, int i) {
        //myViewHolder.rowItem.setText(namesList.get(i));
        if(!namesList.isEmpty()){
            WItemViewModel viewModel = namesList.get(i);
            myViewHolder.viewItemBinding.setViewModel(viewModel);
            myViewHolder.viewItemBinding.executePendingBindings();
        }

    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //TextView rowItem;

        /*public MyViewHolder(View view){
            super(view);
            rowItem = view.findViewById(R.id.rowItem);
        }*/

        ViewItemBinding viewItemBinding;

        public MyViewHolder(ViewItemBinding viewItemBinding){
            super(viewItemBinding.getRoot());
           this.viewItemBinding = viewItemBinding;
        }

    }
}
