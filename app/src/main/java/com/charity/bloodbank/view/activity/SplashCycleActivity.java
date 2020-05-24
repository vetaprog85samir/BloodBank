package com.charity.bloodbank.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.charity.bloodbank.R;
import com.charity.bloodbank.view.fragment.splashCycle.SliderFragment;
import com.charity.bloodbank.view.fragment.splashCycle.SplashFragment;

import androidx.fragment.app.FragmentTransaction;


public class SplashCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.splash_cycle_activity_fl_frame_fragment, new SplashFragment()).commit();


        //Intent intent = new Intent(SplashCycleActivity.this,UserCycleActivity.class);




    }
}
