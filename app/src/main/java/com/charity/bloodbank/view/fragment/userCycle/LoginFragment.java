package com.charity.bloodbank.view.fragment.userCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.charity.bloodbank.R;
import com.charity.bloodbank.view.activity.HomeCycleActivity;
import com.charity.bloodbank.view.fragment.BaseFragment;


public class LoginFragment extends BaseFragment{


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        setUpActivity();

        Button btn_enter = v.findViewById(R.id.btn_edit);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), HomeCycleActivity.class);

                startActivity(intent);

                // HelperMethod.replaceFragment(getChildFragmentManager(),R.id.login_layout, new HomeFragment());
            }
        });

        return v;
    }

    @Override
    public void onBack() {
        super.onBack();
    }
}
