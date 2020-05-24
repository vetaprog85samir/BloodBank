package com.charity.bloodbank.view.fragment.splashCycle;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charity.bloodbank.R;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.fragment.BaseFragment;
import com.charity.bloodbank.view.fragment.homeCycle.home.NotificationFragment;
import com.charity.bloodbank.view.fragment.homeCycle.home.PostsFragment;


public class SplashFragment extends BaseFragment{


    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_splash_cycle);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_splash, container, false);

        setUpActivity();

        //HelperMethod.replaceFragment(getFragmentManager(),R.id.splash_cycle_activity_fl_frame_fragment,new SliderFragment());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                //getFragmentManager().beginTransaction().replace(R.id.splash_cycle_activity_fl_frame_fragment, new SliderFragment()).commit();
                HelperMethod.replaceFragment(getFragmentManager(),R.id.splash_cycle_activity_fl_frame_fragment,new PostsFragment());
            }}, 3000);
        /*Thread thread = home Thread(){
            @Override
            public void run() {
                try {sleep(3000);
                    HelperMethod.replaceFragment(getChildFragmentManager(),R.id.fragment_splash,home SliderFragment());
                } catch (InterruptedException e) {e.printStackTrace();}}};thread.start()*/
        //getActivity().finish();
        return v;
    }
    @Override
    public void onBack() {
        baseActivity.finish();
    }
}
