package com.example.fordlabs.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    public List<Employee> namesList;

    public Context context;


        public CustomAdapter(Context context, List<Employee> namesList) {
            this.context = context;
            this.namesList = namesList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View itemView = inflater.inflate(R.layout.frag_item, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

           final Employee clickedEmployee = namesList.get(i);
            myViewHolder.textView.setText(clickedEmployee.getName());
            myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment2 = new TextFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id",clickedEmployee.getCdSID());
                    bundle.putString("name",clickedEmployee.getName());
                    bundle.putString("age",clickedEmployee.getAge());
                    fragment2.setArguments(bundle);

                    if (context instanceof MainActivity) {
                        MainActivity mainActivity = (MainActivity) context;
                        mainActivity.switchContent(R.id.textFrame, fragment2);
                    }

                }

            });
        }


        @Override
        public int getItemCount() {
            return namesList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.rowItem);
            }

        }
    }
