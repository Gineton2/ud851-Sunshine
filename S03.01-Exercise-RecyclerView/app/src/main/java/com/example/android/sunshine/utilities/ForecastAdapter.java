package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * Created by Gineton on 2018-03-01.
 */

// COMPLETE (15) Add a class file called ForecastAdapter
// COMPLETE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// COMPLETE (23) Create a private string array called mWeatherData

// COMPLETE (47) Create the default constructor (we will pass in parameters in a later lesson)

// COMPLETE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// COMPLETE (17) Extend RecyclerView.ViewHolder

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{
    private String[] mWeatherData;

    public ForecastAdapter() {
    }

    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    // COMPLETE (18) Create a public final TextView variable called mWeatherTextView

    // COMPLETE (19) Create a constructor for this class that accepts a View as a parameter
    // COMPLETE (20) Call super(view) within the constructor for ForecastAdapterViewHolder
    // COMPLETE (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

    // COMPLETE (24) Override onCreateViewHolder
    // COMPLETE (25) Within onCreateViewHolder, inflate the list item xml into a view
    // COMPLETE (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

    // COMPLETE (27) Override onBindViewHolder
    // COMPLETE (28) Set the text of the TextView to the weather for this list item's position

    // COMPLETE (29) Override getItemCount
    // COMPLETE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    // COMPLETE (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // COMPLETE (32) After you save mWeatherData, call notifyDataSetChanged

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.forecast_list_item, viewGroup, false);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String weatherForDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForDay);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null) return 0;
        return mWeatherData.length;
    }

    public void setmWeatherData(String[] weatherData){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

}
