package com.example.fordlabs.practisetestviewpager;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;

public class WeatherViewPagerAdapter {

    @BindingAdapter("onPageChangeListener")
    public static void onPageChangeEvent(ViewPager viewPager ,final SelectedPageInterface selectedPageInterface){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                selectedPageInterface.selectPageChange(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }





        @FunctionalInterface
        public interface SelectedPageInterface{
            void selectPageChange(int position);
        }
}
