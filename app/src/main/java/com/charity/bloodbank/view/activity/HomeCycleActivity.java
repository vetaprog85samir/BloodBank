package com.charity.bloodbank.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.charity.bloodbank.R;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.fragment.homeCycle.more.NotificationSettingFragment;
import com.charity.bloodbank.view.fragment.homeCycle.navBar.HomeFragment;
import com.charity.bloodbank.view.fragment.homeCycle.navBar.IdentityFragment;
import com.charity.bloodbank.view.fragment.homeCycle.navBar.MoreFragment;
import com.charity.bloodbank.view.fragment.homeCycle.navBar.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);

        BottomNavigationView BottomNav = findViewById(R.id.nav_bar);
        BottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_frame_home_cycle_activity, new HomeFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner=

            item -> {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_identity:
                        selectedFragment = new IdentityFragment();
                        break;
                    case R.id.nav_notifications:
                        selectedFragment = new NotificationFragment();
                        break;
                    case R.id.nav_more:
                        selectedFragment = new MoreFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_home_cycle_activity, selectedFragment).commit();

                return true;
            };
}
