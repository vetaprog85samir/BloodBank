package com.charity.bloodbank.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.charity.bloodbank.R;
import com.charity.bloodbank.view.fragment.ProfileDataFragment;
import com.charity.bloodbank.view.fragment.homeCycle.home.DonationFragment;

public class UserCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cycle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_user_cycle_frame_latout, new DonationFragment()).commit();
    }
}
