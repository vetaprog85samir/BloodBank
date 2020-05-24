package com.charity.bloodbank.view.fragment.homeCycle.navBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.ViewPagerWithFragmentAdapter;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.fragment.BaseFragment;
import com.charity.bloodbank.view.fragment.homeCycle.home.DonationFragment;
import com.charity.bloodbank.view.fragment.homeCycle.home.PostsFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;


public class HomeFragment extends BaseFragment{

    private ViewPager viewPager;

    private ViewPagerWithFragmentAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);



        viewPager = v.findViewById(R.id.home_view_pager);
        //viewPager.addOnPageChangeListener(listener);

        adapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager());
        setUpViewPager(adapter);

        TabLayout homeTabs = v.findViewById(R.id.home_tabs);
        homeTabs.setupWithViewPager(viewPager);

        setUpActivity();
        return v;
    }

    private void setUpViewPager(ViewPagerWithFragmentAdapter adapter) {
        adapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager());
        adapter.addPager(new DonationFragment(),"Donation");
        adapter.addPager(new PostsFragment(),"Posts");
        viewPager.setAdapter(adapter);
    }





    @Override
    public void onBack() {
        super.onBack();
    }


    /*ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if(position ==0){
                HelperMethod.replaceFragment(getChildFragmentManager(),R.id.fragment_home_container,new DonationFragment());
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };*/

}
