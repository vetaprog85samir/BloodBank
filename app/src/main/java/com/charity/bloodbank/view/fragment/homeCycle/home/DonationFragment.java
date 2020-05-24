package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.BloodSpinnerAdapter;
import com.charity.bloodbank.adapter.DonationAdapter;
import com.charity.bloodbank.adapter.GovSpinnerAdapter;
import com.charity.bloodbank.data.model.donation.allRequests.AllRequestData;
import com.charity.bloodbank.data.model.donation.allRequests.AllRequests;
import com.charity.bloodbank.utils.OnEndLess;
import com.charity.bloodbank.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;
import static com.charity.bloodbank.view.GeneralRequest.getSpinnerData;


public class DonationFragment extends BaseFragment {


    @BindView(R.id.fragment_donation_sp_blood_types)
    Spinner fragmentDonationSpBloodTypes;
    @BindView(R.id.fragment_donation_sp_governorates)
    Spinner fragmentDonationSpGovernorates;
    @BindView(R.id.fragment_donation_rv)
    RecyclerView fragmentDonationRv;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private List<AllRequestData> donationDataList = new ArrayList<>();
    private DonationAdapter donationAdapter;
    private Integer maxPage = 0;
    private OnEndLess onEndLess;
    private BloodSpinnerAdapter bloodTypesAdapter;
    private GovSpinnerAdapter governorateAdapter;
    private boolean Filter = false;

    public DonationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_donation, container, false);

        unbinder = ButterKnife.bind(this, v);

        bloodTypesAdapter = new BloodSpinnerAdapter(getActivity());
        getSpinnerData(getActivity(), fragmentDonationSpBloodTypes, bloodTypesAdapter, "Select Blood Types", getClient().getBloodType());


        governorateAdapter = new GovSpinnerAdapter(getActivity());
        getSpinnerData(getActivity(), fragmentDonationSpGovernorates, governorateAdapter, "Select Governorates", getClient().getGovernorate());

        init();

        setUpActivity();
        return v;
    }

    private void init() {

        linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentDonationRv.setLayoutManager(linearLayoutManager);

        donationAdapter = new DonationAdapter(getActivity(),getActivity(), donationDataList);
        fragmentDonationRv.setAdapter(donationAdapter);

        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= maxPage) {
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        if (Filter) {

                            onFilter(current_page);

                        }else {

                            getDonations(current_page);
                        }


                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        fragmentDonationRv.addOnScrollListener(onEndLess);

        getDonations(1);
    }

    private void getDonations(int page) {

        Call<AllRequests> call = getClient().donationRequests("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl", page);


        startCall(call, page);

    }



    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick(R.id.fragment_donation_filter_btn)
    public void onViewClicked() {

        onFilter(1);
    }

    private void onFilter(int page) {

        Filter =true;

        onEndLess.previousTotal=0;
        onEndLess.current_page = 1;
        onEndLess.previous_page=1;
        donationDataList = new ArrayList<>();
        donationAdapter = new DonationAdapter(getActivity(),getActivity(),donationDataList);
        fragmentDonationRv.setAdapter(donationAdapter);

        Call<AllRequests> call = getClient().donationRequests("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl",page,
                bloodTypesAdapter.selectedId,governorateAdapter.selectedId);

        startCall(call, page);

    }

    private void startCall(Call<AllRequests> call, int page) {

        call.enqueue(new Callback<AllRequests>() {
            @Override
            public void onResponse(Call<AllRequests> call, Response<AllRequests> response) {

                maxPage = response.body().getData().getLastPage();

                if (response.body().getStatus() == 1) {
                    donationDataList.addAll(response.body().getData().getData());
                    donationAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<AllRequests> call, Throwable t) {

            }
        });


    }
}
