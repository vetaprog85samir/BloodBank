package com.charity.bloodbank.view.fragment.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.BloodSpinnerAdapter;
import com.charity.bloodbank.adapter.GovSpinnerAdapter;
import com.charity.bloodbank.data.model.user.profile.Client;
import com.charity.bloodbank.data.model.user.profile.Profile;
import com.charity.bloodbank.utils.DateTxt;
import com.charity.bloodbank.utils.HelperMethod;
import com.charity.bloodbank.view.fragment.BaseFragment;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;
import static com.charity.bloodbank.view.GeneralRequest.getSpinnerData;


public class ProfileFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.input_name)
    TextInputLayout inputName;
    @BindView(R.id.input_email)
    TextInputLayout inputEmail;
    @BindView(R.id.show_birth_date)
    TextView showBirthDate;
    @BindView(R.id.txt_blood_type)
    TextView txtBloodType;
    @BindView(R.id.show_donation_date)
    TextView showDonationDate;
    @BindView(R.id.txt_governorate)
    TextView txtGovernorate;
    @BindView(R.id.txt_city)
    TextView txtCity;
    @BindView(R.id.input_phone_number)
    TextInputLayout inputPhoneNumber;
    @BindView(R.id.input_password)
    TextInputLayout inputPassword;
    @BindView(R.id.input_confirm_password)
    TextInputLayout inputConfirmPassword;
    @BindView(R.id.spinner_blood_type)
    Spinner spinnerBloodType;
    @BindView(R.id.spinner_governorate)
    Spinner spinnerGovernorate;
    @BindView(R.id.spinner_city)
    Spinner spinnerCity;

    DateTxt birthDayDate;
    DateTxt donationDayDate;

    private BloodSpinnerAdapter SpinnerBloodTypesAdapter;
    private GovSpinnerAdapter SpinnerGovernorateAdapter;
    private GovSpinnerAdapter SpinnerCityAdapter;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_data, container, false);

        unbinder = ButterKnife.bind(this, v);

        getProfile();
        setUpActivity();
        return v;
    }
//____________________________________________________________________________________________________________________________________

    private void getProfile() {

        getClient().getProfile("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl").enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

                try {

                    if (response.body().getStatus() == 1) {

                        setData(response.body().getData().getClient());

                        SpinnerBloodTypesAdapter = new BloodSpinnerAdapter(getActivity());

                        SpinnerGovernorateAdapter = new GovSpinnerAdapter(getActivity());

                        SpinnerCityAdapter = new GovSpinnerAdapter(getActivity());

                        getSpinnerData(getClient().getBloodType(), spinnerBloodType, SpinnerBloodTypesAdapter,
                                response.body().getData().getClient().getBloodType().getId(),
                                getString(R.string.select_blood_type));

                        AdapterView.OnItemSelectedListener onGovSelectedListener = new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                if (i != 0) {
                                    getSpinnerData(getClient().getGovernorate(), spinnerCity, SpinnerCityAdapter,
                                            response.body().getData().getClient().getCity().getGovernorate().getId(),
                                            getString(R.string.select_city));
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        };

                        getSpinnerData(getClient().getGovernorate(), spinnerGovernorate, SpinnerGovernorateAdapter,
                                response.body().getData().getClient().getBloodType().getId(),
                                getString(R.string.select_governorate), onGovSelectedListener);
                    }

                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
            }
        });
    }
//____________________________________________________________________________________________________________________________________

    private void setData(Client client) {

        inputName.getEditText().setText(client.getName());
        inputEmail.getEditText().setText(client.getEmail());
        showBirthDate.setText(client.getBirthDate());
        showDonationDate.setText(client.getDonationLastDate());
        inputPhoneNumber.getEditText().setText(client.getPhone());
        inputPassword.getEditText().setText("");
        inputConfirmPassword.getEditText().setText("");
    }
//___________________________________________________________________________________________

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onBack() {
        super.onBack();
    }
//___________________________________________________________________________________________

    @OnClick({R.id.birth_date_layout, R.id.donation_date_layout, R.id.btn_register})
    public void onViewClicked(View view) {

        HelperMethod.disappearKeypad(getActivity(), view);

        switch (view.getId()) {
            case R.id.birth_date_layout:
                HelperMethod.showCalender(getActivity(),
                        getString(R.string.select_date), showBirthDate, birthDayDate);
                break;
            case R.id.donation_date_layout:

                HelperMethod.showCalender(getActivity(),
                        getString(R.string.select_date), showDonationDate, donationDayDate);
                break;
            case R.id.btn_register:
                break;
        }
    }
}
