package com.example.railwaytimeprediction.platformsPackage;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.railwaytimeprediction.R;
import com.example.railwaytimeprediction.allDatabasePackage.administrationPackage.AdministrationDatabase;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static DrawerLayout drawerLayout;
    public static String string;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        FragmentAllPlatforms.currentMail = sharedPreferences.getString("currentMail", "");

        AdministrationDatabase administrationDatabase = new AdministrationDatabase(this);
        FragmentAllPlatforms.currentID = administrationDatabase.getID(FragmentAllPlatforms.currentMail);

        drawerLayout = findViewById(R.id._drawerLayout);
        navigationView = findViewById(R.id._navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.setScrimColor(getResources().getColor(R.color.lavender));
        actionBarDrawerToggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentHome()).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        string = String.valueOf(item);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentAllPlatforms()).commit();
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentHome()).commit();
        }
    }
}