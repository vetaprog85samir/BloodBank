package com.charity.bloodbank.view.fragment.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.SlideAdapter;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.activity.HomeCycleActivity;
import com.charity.bloodbank.view.activity.SplashCycleActivity;
import com.charity.bloodbank.view.activity.UserCycleActivity;
import com.charity.bloodbank.view.fragment.BaseFragment;
import com.charity.bloodbank.view.fragment.ProfileDataFragment;
import com.charity.bloodbank.view.fragment.userCycle.LoginFragment;
import com.charity.bloodbank.view.fragment.userCycle.ProfileFragment;

import androidx.viewpager.widget.ViewPager;


public class SliderFragment extends BaseFragment{

    private ViewPager viewPager;

    private ImageButton btnNext;

    private int[] layouts;

    private SlideAdapter slideAdapter;

    private int currentPage;

    ImageView dots;


    public SliderFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_slider, container, false);

        setUpActivity();

        viewPager = v.findViewById(R.id.viewPager);
        btnNext = v.findViewById(R.id.btn_next);

        layouts = new int[] {

                R.layout.slider1,
                R.layout.slider2,
                R.layout.slider3,
                //R.layout.fragment_login
        };

        slideAdapter = new SlideAdapter(getContext(),layouts);

        viewPager.setAdapter(slideAdapter);

        //Intent intent = new Intent(getActivity(),UserCycleActivity.class);

        btnNext.setOnClickListener(v1 -> {
            if (viewPager.getCurrentItem() + 1 < layouts.length){
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }

            else{

                Intent intent = new Intent();
                intent.setClass(getActivity(), HomeCycleActivity.class);
                getActivity().startActivity(intent);
            }


                //HelperMethod.replaceFragment(getChildFragmentManager(),R.id.fragment_slider,new ProfileDataFragment());

            //else getActivity().startActivity(intent);

        });

        viewPager.addOnPageChangeListener(listener);

        dots = v.findViewById(R.id.dots);



        return v;
    }

    @Override
    public void onBack() {
        baseActivity.finish();
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            currentPage = position;

            if (position==0){

                dots.setImageResource(R.drawable.ic_dots1);
                btnNext.setImageResource(R.drawable.ic_arrow_forward_white_24dp);

            }

            if (position == 2) {
                dots.setImageResource(R.drawable.ic_dots3);
                btnNext.setImageResource(R.drawable.ic_check_white_24dp);
            }

            if (position == 1) {
                dots.setImageResource(R.drawable.ic_dots2);
                btnNext.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
