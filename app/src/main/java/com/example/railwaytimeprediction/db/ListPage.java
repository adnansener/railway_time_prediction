package com.example.railwaytimeprediction.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.railwaytimeprediction.R;

import java.util.ArrayList;

public class ListPage extends AppCompatActivity {
    private ArrayList<String> platform_name, when_created, departure_station, arrival_station, departure_time, arrival_time, station_counter, station_range_time;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        databaseHelper = new DatabaseHelper(this);
        platform_name = new ArrayList<>();
        when_created = new ArrayList<>();
        departure_station = new ArrayList<>();
        arrival_station = new ArrayList<>();
        departure_time = new ArrayList<>();
        arrival_time = new ArrayList<>();
        station_counter = new ArrayList<>();
        station_range_time = new ArrayList<>();
    }
}