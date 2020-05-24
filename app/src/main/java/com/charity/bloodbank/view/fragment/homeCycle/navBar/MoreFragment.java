package com.charity.bloodbank.view.fragment.homeCycle.navBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charity.bloodbank.R;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.fragment.BaseFragment;
import com.charity.bloodbank.view.fragment.homeCycle.more.AboutAppFragment;
import com.charity.bloodbank.view.fragment.homeCycle.more.ContactFragment;
import com.charity.bloodbank.view.fragment.homeCycle.more.FavoritePostsFragment;
import com.charity.bloodbank.view.fragment.homeCycle.more.NotificationSettingFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.charity.bloodbank.utils.HelperMethod.replaceFragment;


public class MoreFragment extends BaseFragment {


    private Unbinder unbinder;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_more, container, false);
        unbinder = ButterKnife.bind(this, v);
        setUpActivity();
        return v;
    }

    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick({R.id.fragment_more_et_favorite, R.id.fragment_more_et_contact_us, R.id.fragment_more_et_about_app, R.id.fragment_more_et_rating, R.id.fragment_more_et_settings, R.id.fragment_more_et_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_more_et_favorite:
                FavoritePostsFragment favoritePostsFragment = new FavoritePostsFragment();
                replaceFragment(getChildFragmentManager(),R.id.fragment_more,favoritePostsFragment);
                break;
            case R.id.fragment_more_et_contact_us:
                ContactFragment contactFragment = new ContactFragment();
                replaceFragment(getChildFragmentManager(),R.id.fragment_more,contactFragment);
                break;
            case R.id.fragment_more_et_about_app:
                AboutAppFragment aboutAppFragment = new AboutAppFragment();
                replaceFragment(getChildFragmentManager(),R.id.fragment_more,aboutAppFragment);
                break;
            case R.id.fragment_more_et_rating:
                break;
            case R.id.fragment_more_et_settings:
                NotificationSettingFragment notificationSettingFragment = new NotificationSettingFragment();
                replaceFragment(getChildFragmentManager(),R.id.fragment_more,notificationSettingFragment);
                break;
            case R.id.fragment_more_et_logout:
                break;
        }
    }
}
