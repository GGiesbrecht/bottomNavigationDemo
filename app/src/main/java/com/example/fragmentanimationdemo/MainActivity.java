package com.example.fragmentanimationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_log:
                        setFragmentLog();
                        break;
                    case R.id.nav_graph:
                        setFragmentGraph();
                        break;
                }
                return true;
            }
        });

        // Displays fragment 1 on app start up
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragmentContainer, new Fragment_1()).commit();
    }

    private void setFragmentLog() {
        getSupportFragmentManager()
            .beginTransaction()
            .setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_right_to_left)
            .replace(R.id.fragmentContainer, new Fragment_1())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit();
    }

    private void setFragmentGraph() {
        getSupportFragmentManager()
            .beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_left_to_right)
            .replace(R.id.fragmentContainer, new Fragment_2())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit();
    }
}
