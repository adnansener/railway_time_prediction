package com.example.railwaytimeprediction.db;
import static com.example.railwaytimeprediction.MainActivity.drawerLayout;

import android.database.Cursor;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.railwaytimeprediction.R;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class FragmentHome extends Fragment {
    private Button menuButton;
    public static DatabaseHelper databaseHelper;
    private AdapterClass adapterClass;
    private RecyclerView recyclerView;
    public static ArrayList<String> platform_name, when_created, departure_station, arrival_station, departure_time, arrival_time, station_counter, station_range_time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        databaseHelper = new DatabaseHelper(getActivity());

        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);

        database();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        menuButton = (Button) v.findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        return v;
    }

    protected void database() {
        platform_name = new ArrayList<>();
        when_created = new ArrayList<>();
        departure_station = new ArrayList<>();
        arrival_station = new ArrayList<>();
        departure_time = new ArrayList<>();
        arrival_time = new ArrayList<>();
        station_counter = new ArrayList<>();
        station_range_time = new ArrayList<>();

        adapterClass = new AdapterClass(getActivity(), platform_name, when_created, departure_station, arrival_station, departure_time, arrival_time, station_counter, station_range_time);
        recyclerView.setAdapter(adapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        displaydata();
    }

    public void displaydata() {
        Cursor cursor = databaseHelper.getAllData();

        if(cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                platform_name.add(cursor.getString(1));
                when_created.add(cursor.getString(2));
                departure_station.add(cursor.getString(3));
                arrival_station.add(cursor.getString(4));
                departure_time.add(cursor.getString(5));
                arrival_time.add(cursor.getString(6));
                station_counter.add(cursor.getString(7));
                station_range_time.add(cursor.getString(8));
            }
        }
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getLayoutPosition();

            databaseHelper.onDelete(position);

            database();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addActionIcon(R.drawable.delete_icon)
                        .create()
                            .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
}