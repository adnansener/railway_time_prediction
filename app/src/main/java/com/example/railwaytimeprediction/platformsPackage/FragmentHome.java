package com.example.railwaytimeprediction.platformsPackage;
import static com.example.railwaytimeprediction.platformsPackage.MainActivity.drawerLayout;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.railwaytimeprediction.R;
import com.example.railwaytimeprediction.allDatabasePackage.queryHistoryPackage.QueryHistory;
import com.example.railwaytimeprediction.allDatabasePackage.queryHistoryPackage.QueryHistoryDatabase;
import com.example.railwaytimeprediction.allDatabasePackage.variablesPackage.VariablesDatabase;
import com.example.railwaytimeprediction.settingsPackage.SettingsActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class FragmentHome extends Fragment {
    public static QueryHistoryDatabase queryHistoryDatabase;
    private RecyclerView recyclerView;
    public static ArrayList<String> platform_name, when_created, departure_station, arrival_station, departure_time, arrival_time, station_counter, station_range_time, current_platform;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        queryHistoryDatabase = new QueryHistoryDatabase(getActivity());

        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);

        FragmentAllPlatforms.departureConfirm = false;
        FragmentAllPlatforms.arrivalConfirm = false;
        FragmentAllPlatforms.departureStationName = "";
        FragmentAllPlatforms.arrivalStationName = "";

        database();

        ItemTouchHelper itemTouchHelperLeft = new ItemTouchHelper(simpleCallbackRight);
        ItemTouchHelper itemTouchHelperRight = new ItemTouchHelper(simpleCallbackLeft);
        itemTouchHelperLeft.attachToRecyclerView(recyclerView);
        itemTouchHelperRight.attachToRecyclerView(recyclerView);

        Button settingsButton = v.findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        Button menuButton = v.findViewById(R.id.menu_button);
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
        current_platform = new ArrayList<>();

        QueryHistory queryHistory = new QueryHistory(getActivity(), platform_name, when_created, departure_station, arrival_station, departure_time, arrival_time, station_counter, station_range_time);
        recyclerView.setAdapter(queryHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        displaydata();
    }

    public void displaydata() {
        Cursor cursor = queryHistoryDatabase.getAllData();

        if(cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                if(cursor.getInt(9) == FragmentAllPlatforms.currentID)
                {
                    platform_name.add(cursor.getString(1));
                    when_created.add(cursor.getString(2));
                    departure_station.add(cursor.getString(3));
                    arrival_station.add(cursor.getString(4));
                    departure_time.add(cursor.getString(5));
                    arrival_time.add(cursor.getString(6));
                    station_counter.add(cursor.getString(7));
                    station_range_time.add(cursor.getString(8));
                    current_platform.add(cursor.getString(9));
                }
            }
        }
    }

    ItemTouchHelper.SimpleCallback simpleCallbackRight = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getLayoutPosition();

            Cursor cursor = queryHistoryDatabase.showListHelper(position, getActivity());
            String platform = cursor.getString(1);
            String departureStationName = cursor.getString(3);
            String arrivalStationName = cursor.getString(4);

            ArrayList<String> allStationList;
            Integer departureStationIndex;
            Integer arrivalStationIndex;
            try (VariablesDatabase variablesDatabase = new VariablesDatabase(getActivity())) {
                allStationList = new ArrayList<>();
                cursor = variablesDatabase.getAllData(platform);
                if (cursor.getCount() != 0)
                    while (cursor.moveToNext())
                        allStationList.add(cursor.getString(1));

                departureStationIndex = variablesDatabase.getStationId(departureStationName, platform);
                arrivalStationIndex = variablesDatabase.getStationId(arrivalStationName, platform);
            }

            ArrayList<String> tempList = new ArrayList<>();

            tempList = new ArrayList<>();
            if(arrivalStationIndex > departureStationIndex) {
                for(int i = departureStationIndex; i <= arrivalStationIndex; i++)
                    tempList.add(allStationList.get(i));
            }
            else{
                for(int i = arrivalStationIndex; i <= departureStationIndex; i++)
                    tempList.add(allStationList.get(i));

                Collections.reverse(tempList);
            }

            dialog = new Dialog(requireActivity());
            dialog.setContentView(R.layout.dialog_show_station_list);
            Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Button dialogEscapeButton = (Button) dialog.findViewById(R.id.escape_button);
            dialogEscapeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            ListView showListView = dialog.findViewById(R.id.list_view);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(requireActivity(), R.layout.list_item, R.id.text_view, tempList);
            showListView.setAdapter(arrayAdapter);

            dialog.show();

            database();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive).addActionIcon(R.drawable.list_icon).create().decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    ItemTouchHelper.SimpleCallback simpleCallbackLeft = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getLayoutPosition();

            queryHistoryDatabase.onDelete(position);

            database();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive).addActionIcon(R.drawable.delete_icon).create().decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };
}