package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.BloodSpinnerAdapter;
import com.charity.bloodbank.adapter.CitySpinnerAdapter;
import com.charity.bloodbank.adapter.GovSpinnerAdapter;
import com.charity.bloodbank.data.local.SharedPreferencesManger;
import com.charity.bloodbank.data.model.donation.createRequest.CreateRequest;
import com.charity.bloodbank.view.GeneralRequest;
import com.charity.bloodbank.view.activity.MapsActivity;
import com.charity.bloodbank.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;
import static com.charity.bloodbank.data.local.SharedPreferencesManger.LoadData;
import static com.charity.bloodbank.data.local.SharedPreferencesManger.SaveData;
import static com.charity.bloodbank.view.GeneralRequest.getSpinnerData;


public class DonationRequestFragment extends BaseFragment {


    @BindView(R.id.donate_request_fragment_et_name)
    EditText donateRequestFragmentEtName;
    @BindView(R.id.donate_request_fragment_et_age)
    EditText donateRequestFragmentEtAge;
    @BindView(R.id.donate_request_fragment_sp_blood_type)
    Spinner donateRequestFragmentSpBloodType;
    @BindView(R.id.donate_request_fragment_et_bag_number)
    EditText donateRequestFragmentEtBagNumber;
    @BindView(R.id.donate_request_fragment_et_hospital_name)
    EditText donateRequestFragmentEtHospitalName;
    @BindView(R.id.donate_request_fragment_sp_government)
    Spinner donateRequestFragmentSpGovernment;
    @BindView(R.id.donate_request_fragment_sp_city)
    Spinner donateRequestFragmentSpCity;
    @BindView(R.id.donate_request_fragment_et_phone)
    EditText donateRequestFragmentEtPhone;
    @BindView(R.id.donate_request_fragment_et_notes)
    EditText donateRequestFragmentEtNotes;
    private Unbinder unbinder;

    private BloodSpinnerAdapter bloodSpinnerAdapter;
    private GovSpinnerAdapter govSpinnerAdapter;
    private CitySpinnerAdapter citySpinnerAdapter;
    private String hospital_address;

    public DonationRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_donation_request, container, false);
        unbinder = ButterKnife.bind(this, v);
        init();
        setUpActivity();
        return v;
    }

    private void init() {
        bloodSpinnerAdapter = new BloodSpinnerAdapter(getActivity());
        getSpinnerData(getClient().getBloodType(),donateRequestFragmentSpBloodType,bloodSpinnerAdapter,bloodSpinnerAdapter.selectedId,"select blood type");

        govSpinnerAdapter = new GovSpinnerAdapter(getActivity());
        citySpinnerAdapter = new CitySpinnerAdapter(getActivity());

        AdapterView.OnItemSelectedListener onGovSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    getSpinnerData(getClient().getGovernorate(), donateRequestFragmentSpCity, citySpinnerAdapter,
                            govSpinnerAdapter.selectedId,"select city");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        getSpinnerData(getClient().getCities(citySpinnerAdapter.selectedId), donateRequestFragmentSpGovernment, govSpinnerAdapter,
                citySpinnerAdapter.selectedId,"select gov", onGovSelectedListener);
    }


    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick({R.id.donate_request_fragment_ib_hospital_map_location, R.id.donate_request_fragment_bt_send_request})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.donate_request_fragment_ib_hospital_map_location:
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.donate_request_fragment_bt_send_request:
                String patientName = donateRequestFragmentEtName.getText().toString();
                String patientAge = donateRequestFragmentEtAge.getText().toString();
                String blood_type_id = String.valueOf(donateRequestFragmentSpBloodType.getSelectedItemPosition());
                String bags_num = donateRequestFragmentEtBagNumber.getText().toString();
                String hospital_name = donateRequestFragmentEtHospitalName.getText().toString();
                String city_id = String.valueOf(donateRequestFragmentSpCity.getSelectedItemPosition());
                String phone = donateRequestFragmentEtPhone.getText().toString();
                String notes = donateRequestFragmentEtNotes.getText().toString();
                String latitude = LoadData(getActivity(), "LATITUDE");
                String longitude = LoadData(getActivity(), "LONGITUDE");
                createDonationRequest(patientName, patientAge, blood_type_id, bags_num, hospital_name,
                        hospital_address, city_id, phone, notes, latitude, longitude);
                SaveData(getActivity(), "LOCATION", null);
                SaveData(getActivity(), "LATITUDE", null);
                SaveData(getActivity(), "LONGITUDE", null);
                break;
        }
    }

    private void createDonationRequest(String patientName, String patientAge, String blood_type_id, String bags_num,
                                       String hospital_name, String hospital_address, String city_id, String phone,
                                       String notes, String latitude, String longitude) {
        getClient().createDonationRequest(LoadData(getActivity(),"api_token"),patientName, patientAge,
                blood_type_id, bags_num, hospital_name, hospital_address, city_id, phone, notes, latitude, longitude).enqueue(new Callback<CreateRequest>() {
            @Override
            public void onResponse(Call<CreateRequest> call, Response<CreateRequest> response) {
                try {
                    if (response.body().getStatus()==1) {
                        Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<CreateRequest> call, Throwable t) {

            }
        });
    }
}
