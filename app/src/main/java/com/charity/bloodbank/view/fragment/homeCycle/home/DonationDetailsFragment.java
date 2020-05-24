package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.donation.displayDetails.DisplayDetailsData;
import com.charity.bloodbank.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DonationDetailsFragment extends BaseFragment {


    @BindView(R.id.donation_details_fragment_tv_name)
    TextView donationDetailsFragmentTvName;
    @BindView(R.id.donation_details_fragment_tv_age)
    TextView donationDetailsFragmentTvAge;
    @BindView(R.id.donation_details_fragment_tv_blood_type)
    TextView donationDetailsFragmentTvBloodType;
    @BindView(R.id.donation_details_fragment_tv_blood_bag_number)
    TextView donationDetailsFragmentTvBloodBagNumber;
    @BindView(R.id.donation_details_fragment_tv_hospital_name)
    TextView donationDetailsFragmentTvHospitalName;
    @BindView(R.id.donation_details_fragment_tv_hospital_address)
    TextView donationDetailsFragmentTvHospitalAddress;
    @BindView(R.id.donation_details_fragment_tv_phone)
    TextView donationDetailsFragmentTvPhone;
    @BindView(R.id.donation_details_fragment_tv_details)
    TextView donationDetailsFragmentTvDetails;
    private Unbinder unbinder;

    private DisplayDetailsData donationData;


    public DonationDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details_donation, container, false);
        unbinder = ButterKnife.bind(this, v);
        getDonationDetails();
        setUpActivity();
        return v;
    }

    private void getDonationDetails() {
        donationDetailsFragmentTvName.setText(donationData.getPatientName());
        donationDetailsFragmentTvAge.setText(donationData.getPatientAge());
        donationDetailsFragmentTvBloodType.setText(donationData.getBloodType().getName());
        donationDetailsFragmentTvBloodBagNumber.setText(donationData.getBagsNum());
        donationDetailsFragmentTvHospitalName.setText(donationData.getHospitalName());
        donationDetailsFragmentTvHospitalAddress.setText(donationData.getHospitalAddress());
        donationDetailsFragmentTvPhone.setText(donationData.getPhone());
        donationDetailsFragmentTvDetails.setText(donationData.getNotes());
    }

    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick(R.id.donation_details_fragment_bt_call)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+donationData.getPhone()));
        startActivity(intent);
    }
}
