package com.charity.bloodbank.view.fragment.homeCycle.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.BloodNotificationSettingAdapter;
import com.charity.bloodbank.adapter.GovNotificationSettingAdapter;
import com.charity.bloodbank.data.model.general.bloodTypes.BloodTypes;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponse;
import com.charity.bloodbank.data.model.notification.notificationSetting.NotificationSetting;
import com.charity.bloodbank.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;


public class NotificationSettingFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.notification_setting_fragment_bl_rv)
    RecyclerView notificationSettingFragmentBlRv;
    @BindView(R.id.notification_setting_fragment_gov_rv)
    RecyclerView notificationSettingFragmentGovRv;
    @BindView(R.id.notification_setting_fragment_rel_bl_gone)
    LinearLayout notificationSettingFragmentRelBlGone;
    @BindView(R.id.notification_setting_fragment_bl_rel_iv_tv)
    LinearLayout notificationSettingFragmentBlRelIvTv;
    @BindView(R.id.notification_setting_fragment_rel_gov_gone)
    LinearLayout notificationSettingFragmentRelGovGone;
    @BindView(R.id.notification_setting_fragment_gov_rel_iv_tv)
    LinearLayout notificationSettingFragmentGovRelIvTv;
    private List<String> governorates = new ArrayList<>();
    private List<String> bloodTypes = new ArrayList<>();
    private BloodNotificationSettingAdapter bloodTypeAdapter;
    private GovNotificationSettingAdapter governorateAdapter;

    public NotificationSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification_setting, container, false);

        unbinder = ButterKnife.bind(this, v);

        init();

        getNotificationSetting();

        setUpActivity();
        return v;
    }

    private void init() {
        notificationSettingFragmentBlRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        notificationSettingFragmentGovRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    private void getNotificationSetting() {
        getClient().getNotificationSetting("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl")
                .enqueue(new Callback<NotificationSetting>() {
            @Override
            public void onResponse(Call<NotificationSetting> call, Response<NotificationSetting> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        bloodTypes = response.body().getNotificationSettingData().getBloodTypes();
                        governorates = response.body().getNotificationSettingData().getGovernorates();
                        getBloodTypes();
                        getGovernorates();
                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<NotificationSetting> call, Throwable t) {
                try {

                } catch (Exception e) {

                }
            }
        });

    }

    private void getBloodTypes() {
        getClient().getBloodType().enqueue(new Callback<BloodTypes>() {
            @Override
            public void onResponse(Call<BloodTypes> call, Response<BloodTypes> response) {

                try {

                    bloodTypeAdapter = new BloodNotificationSettingAdapter(getActivity(),
                            getActivity(), response.body().getData(), bloodTypes);
                    notificationSettingFragmentBlRv.setAdapter(bloodTypeAdapter);

                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<BloodTypes> call, Throwable t) {

            }
        });
    }

    private void getGovernorates() {
        getClient().getGovernorate().enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

                try {

                    governorateAdapter = new GovNotificationSettingAdapter(getActivity(),
                            getActivity(), response.body().getData(), governorates);
                    notificationSettingFragmentGovRv.setAdapter(governorateAdapter);

                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public void onBack() {
        super.onBack();
    }




    private void onCall(final boolean state) {
        getClient().setNotificationSetting("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl",
                governorateAdapter.newIds, bloodTypeAdapter.newIds).enqueue(new Callback<NotificationSetting>() {
            @Override
            public void onResponse(Call<NotificationSetting> call, Response<NotificationSetting> response) {
                try {
                    if (response.body().getStatus() == 1) {

                    }Toast.makeText(baseActivity, response.body().getMsg(), Toast.LENGTH_SHORT).show();


                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<NotificationSetting> call, Throwable t) {
                try {

                } catch (Exception e) {

                }
            }
        });
    }



    @OnClick({R.id.notification_setting_fragment_bl_iv_gone, R.id.notification_setting_fragment_bl_iv,
            R.id.notification_setting_fragment_gov_iv_gone, R.id.notification_setting_fragment_gov_iv, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.notification_setting_fragment_bl_iv_gone:
                notificationSettingFragmentRelBlGone.setVisibility(View.GONE);
                notificationSettingFragmentBlRelIvTv.setVisibility(View.VISIBLE);
                break;
            case R.id.notification_setting_fragment_bl_iv:
                notificationSettingFragmentRelBlGone.setVisibility(View.VISIBLE);
                notificationSettingFragmentBlRelIvTv.setVisibility(View.GONE);
                break;
            case R.id.notification_setting_fragment_gov_iv_gone:
                notificationSettingFragmentRelGovGone.setVisibility(View.GONE);
                notificationSettingFragmentGovRelIvTv.setVisibility(View.VISIBLE);
                break;
            case R.id.notification_setting_fragment_gov_iv:
                notificationSettingFragmentRelGovGone.setVisibility(View.VISIBLE);
                notificationSettingFragmentGovRelIvTv.setVisibility(View.GONE);
                break;
            case R.id.button:
                onCall(false);
                break;
        }
    }
}
