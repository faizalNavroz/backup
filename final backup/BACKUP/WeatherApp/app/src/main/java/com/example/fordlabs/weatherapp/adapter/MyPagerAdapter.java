package com.example.fordlabs.weatherapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fordlabs.weatherapp.R;
import com.example.fordlabs.weatherapp.model.Main;
import com.example.fordlabs.weatherapp.model.Weather;
import com.example.fordlabs.weatherapp.model.WeatherResponse;
import com.example.fordlabs.weatherapp.viewModel.WeatherViewModel;
import com.example.fordlabs.weatherapp.databinding.ViewpagerItemBinding2;
import com.example.fordlabs.weatherapp.dto.WeatherResponseDto;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;



public class MyPagerAdapter extends PagerAdapter {


    ArrayList<WeatherResponse> weatherResponseList;
    Context context;

    String[] rank;

    LayoutInflater inflater;



    @Override
    public int getCount() {
        return rank.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    public MyPagerAdapter(Context context, String []rank, ArrayList<WeatherResponse> weatherResponseList) {
        this.weatherResponseList = weatherResponseList;
        this.rank=rank;
        this.context = context;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView base;
        TextView timezone;
        TextView name;
        TextView humidity;
        TextView pressure;



        /* View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);*/


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewpagerItemBinding2 activityMainBinding2 = DataBindingUtil.
                inflate(inflater, R.layout.viewpager_item, container, false); //inflate dynamically with data binding.

        WeatherResponseDto weatherResponseDto = new WeatherResponseDto(" ", " ", " ", " ", " ");

        //set dto data
        List<Weather> weatherList = weatherResponseList.get(position).getWeather();

        DecimalFormat df = new DecimalFormat("0.00");
        Main main = weatherResponseList.get(position).getMain();
        Double celsius = main.getTemp()-273;

        WeatherResponseDto weatherDto = new WeatherResponseDto();
        weatherDto.setCityName(weatherResponseList.get(position).getName());
        weatherDto.setWeather(weatherList.get(0).getDescription());
        weatherDto.setHumidity(String.valueOf(main.getHumidity()));
        weatherDto.setPressure(String.valueOf(main.getPressure()));
        weatherDto.setTemperature(df.format(celsius)+" C");


        activityMainBinding2.setViewModel(new WeatherViewModel(weatherDto));
        activityMainBinding2.executePendingBindings();


        View itemView = activityMainBinding2.getRoot(); //databinding class returns the view matching the xml
        //itemView.setTag(position);
        // Add viewpager_item.xml to ViewPager
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
