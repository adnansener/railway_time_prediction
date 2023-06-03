package com.example.railwaytimeprediction.db;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.railwaytimeprediction.R;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    private Context context;
    protected static ArrayList platform_name;
    protected ArrayList when_created;
    protected ArrayList departure_station;
    protected ArrayList arrival_station;
    protected ArrayList departure_time;
    protected ArrayList arrival_time;
    protected ArrayList station_counter;
    protected ArrayList station_range_time;
    protected ImageView imageView;
    public AdapterClass(Context context, ArrayList platform_name, ArrayList when_created, ArrayList departure_station, ArrayList arrival_station, ArrayList departure_time, ArrayList arrival_time, ArrayList station_counter, ArrayList station_range_time) {
        this.context = context;
        this.platform_name = platform_name;
        this.when_created = when_created;
        this.departure_station = departure_station;
        this.arrival_station = arrival_station;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.station_counter = station_counter;
        this.station_range_time = station_range_time;
    }

    @NonNull
    @Override
    public AdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_view_objects,parent,false);

        imageView = (ImageView) v.findViewById(R.id.logo);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if ("marmaray".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.marmaray);
        } else if ("m1a".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m1a);
        } else if ("m1b".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m1b);
        } else if ("m2".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m2);
        } else if ("m3".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m3);
        } else if ("m4".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m4);
        } else if ("m5".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m5);
        } else if ("m6".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m6);
        } else if ("m7".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m7);
        } else if ("m8".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m8);
        } else if ("m9".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m9);
        } else if ("m10".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m10);
        } else if ("m11".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m11);
        } else if ("m12".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m12);
        } else if ("m13".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m13);
        } else if ("m14".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.m14);
        } else if ("t1".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t1);
        } else if ("t2".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t2);
        } else if ("t3".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t3);
        } else if ("t4".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t4);
        } else if ("t5".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t5);
        } else if ("t6".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.t6);
        } else if ("f1".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.f1);
        } else if ("f2".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.f2);
        } else if ("f3".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.f3);
        } else if ("f4".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.f4);
        } else if ("f5".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.f5);
        } else if ("tf1".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.tf1);
        } else if ("tf2".equals(platform_name.get(position))) {
            imageView.setImageResource(R.drawable.tf2);
        } else { }

        holder.when_created.setText(String.valueOf(when_created.get(position)));
        holder.departure_station.setText(String.valueOf(departure_station.get(position)));
        holder.arrival_station.setText(String.valueOf(arrival_station.get(position)));
        holder.departure_time.setText(String.valueOf(departure_time.get(position)) + "->" + String.valueOf(arrival_time.get(position)));
        holder.station_counter.setText(String.valueOf(station_counter.get(position)) + " Durak");
        holder.station_range_time.setText(String.valueOf(station_range_time.get(position)) + " Dakika");

    }

    @Override
    public int getItemCount() {
        return platform_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView when_created, departure_station, arrival_station, departure_time, station_counter, station_range_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            when_created = itemView.findViewById(R.id.when_created);
            departure_station = itemView.findViewById(R.id.departure_station_name);
            arrival_station = itemView.findViewById(R.id.arrival_station_name);
            departure_time = itemView.findViewById(R.id.departure_time);
            station_counter = itemView.findViewById(R.id.station_counter);
            station_range_time = itemView.findViewById(R.id.station_range_time);
            imageView = (ImageView) itemView.findViewById(R.id.logo);
        }
    }
}
