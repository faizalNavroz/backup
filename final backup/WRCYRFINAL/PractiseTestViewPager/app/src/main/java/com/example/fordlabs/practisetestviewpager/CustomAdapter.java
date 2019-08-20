package com.example.fordlabs.practisetestviewpager;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fordlabs.practisetestviewpager.databinding.ViewpagerItemBinding;

public class CustomAdapter extends PagerAdapter {


    WeatherViewModel weatherViewModel;

    public CustomAdapter(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        /*View itemView  = inflater.inflate(R.layout.viewpager_item,container,false);
        itemView.*/
        ViewpagerItemBinding viewpagerItemBinding = ViewpagerItemBinding.inflate(inflater,container,true);
        viewpagerItemBinding.setViewModel(weatherViewModel);
        viewpagerItemBinding.executePendingBindings();
        return viewpagerItemBinding;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return ((ViewpagerItemBinding)o).getRoot() == view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.i("MSG*************", "destroyItem: ");
        ViewpagerItemBinding viewpagerItemBinding = (ViewpagerItemBinding) object;
        viewpagerItemBinding.setViewModel(null);
        container.removeView(viewpagerItemBinding.getRoot());
    }
}
