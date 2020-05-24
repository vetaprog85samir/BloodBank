package com.charity.bloodbank.view.fragment;

import com.charity.bloodbank.view.activity.BaseActivity;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public BaseActivity baseActivity;

    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();

        baseActivity.baseFragment = this;
    }

    public void onBack() {
        baseActivity.superBackPressed();
    }

}
