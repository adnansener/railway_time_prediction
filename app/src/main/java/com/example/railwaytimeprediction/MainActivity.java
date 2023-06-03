package com.example.railwaytimeprediction;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.railwaytimeprediction.db.FragmentHome;
import com.example.railwaytimeprediction.platforms.FragmentF1;
import com.example.railwaytimeprediction.platforms.FragmentF2;
import com.example.railwaytimeprediction.platforms.FragmentF3;
import com.example.railwaytimeprediction.platforms.FragmentF4;
import com.example.railwaytimeprediction.platforms.FragmentF5;
import com.example.railwaytimeprediction.platforms.FragmentM10;
import com.example.railwaytimeprediction.platforms.FragmentM11;
import com.example.railwaytimeprediction.platforms.FragmentM12;
import com.example.railwaytimeprediction.platforms.FragmentM13;
import com.example.railwaytimeprediction.platforms.FragmentM14;
import com.example.railwaytimeprediction.platforms.FragmentM1A;
import com.example.railwaytimeprediction.platforms.FragmentM1B;
import com.example.railwaytimeprediction.platforms.FragmentM2;
import com.example.railwaytimeprediction.platforms.FragmentM3;
import com.example.railwaytimeprediction.platforms.FragmentM4;
import com.example.railwaytimeprediction.platforms.FragmentM5;
import com.example.railwaytimeprediction.platforms.FragmentM6;
import com.example.railwaytimeprediction.platforms.FragmentM7;
import com.example.railwaytimeprediction.platforms.FragmentM8;
import com.example.railwaytimeprediction.platforms.FragmentM9;
import com.example.railwaytimeprediction.platforms.FragmentMarmaray;
import com.example.railwaytimeprediction.platforms.FragmentT1;
import com.example.railwaytimeprediction.platforms.FragmentT2;
import com.example.railwaytimeprediction.platforms.FragmentT3;
import com.example.railwaytimeprediction.platforms.FragmentT4;
import com.example.railwaytimeprediction.platforms.FragmentT5;
import com.example.railwaytimeprediction.platforms.FragmentT6;
import com.example.railwaytimeprediction.platforms.FragmentTF1;
import com.example.railwaytimeprediction.platforms.FragmentTF2;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        switch(item.getItemId()){
            case R.id.marmaray:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentMarmaray()).commit();
                break;

            case R.id.m1a:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM1A()).commit();
                break;

            case R.id.m1b:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM1B()).commit();
                break;

            case R.id.m2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM2()).commit();
                break;

            case R.id.m3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM3()).commit();
                break;

            case R.id.m4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM4()).commit();
                break;

            case R.id.m5:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM5()).commit();
                break;

            case R.id.m6:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM6()).commit();
                break;

            case R.id.m7:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM7()).commit();
                break;

            case R.id.m8:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM8()).commit();
                break;

            case R.id.m9:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM9()).commit();
                break;

            case R.id.m10:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM10()).commit();
                break;

            case R.id.m11:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM11()).commit();
                break;

            case R.id.m12:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM12()).commit();
                break;

            case R.id.m13:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM13()).commit();
                break;

            case R.id.m14:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentM14()).commit();
                break;

            case R.id.t1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT1()).commit();
                break;

            case R.id.t2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT2()).commit();
                break;

            case R.id.t3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT3()).commit();
                break;

            case R.id.t4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT4()).commit();
                break;

            case R.id.t5:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT5()).commit();
                break;

            case R.id.t6:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentT6()).commit();
                break;

            case R.id.f1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentF1()).commit();
                break;

            case R.id.f2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentF2()).commit();
                break;

            case R.id.f3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentF3()).commit();
                break;

            case R.id.f4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentF4()).commit();
                break;

            case R.id.f5:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentF5()).commit();
                break;

            case R.id.tf1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentTF1()).commit();
                break;

            case R.id.tf2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentTF2()).commit();
                break;
        }

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