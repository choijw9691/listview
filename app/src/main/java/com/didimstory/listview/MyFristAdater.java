package com.didimstory.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFristAdater extends BaseAdapter {
    private List<com.didimstory.listview.Weather> mData;
    private Map<String, Integer> mWeatherImageMap;
private ViewHolder holder;
    public MyFristAdater(List<com.didimstory.listview.Weather> data) {
        this.mData = data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("비",R.drawable.ic_launcher_background);
        mWeatherImageMap.put("눈", R.drawable.ic_launcher_background);
        mWeatherImageMap.put("구름", R.drawable.ic_launcher_background);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
holder=new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);

            ImageView weatherImage = convertView.findViewById(R.id.weather_image);
            TextView cityText = convertView.findViewById(R.id.city_text);
            TextView tempText = convertView.findViewById(R.id.temp_text);

            holder.weatherImage=weatherImage;
            holder.cityText=cityText;
            holder.tempText=tempText;
convertView.setTag(holder);

        }
else{

    holder= (ViewHolder) convertView.getTag();

        }


        com.didimstory.listview.Weather weather = mData.get(position);
        holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));
       holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        return convertView;


    }
    static class ViewHolder{

ImageView weatherImage;
TextView cityText;
TextView tempText;

    }

}
