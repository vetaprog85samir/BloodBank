package com.charity.bloodbank.view.fragment.homeCycle.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.local.SharedPreferencesManger;
import com.charity.bloodbank.data.model.general.appSettings.AppSettings;
import com.charity.bloodbank.view.fragment.BaseFragment;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;

public class AboutAppFragment extends BaseFragment {

    @BindView(R.id.about_app_fragment_tv)
    TextView aboutAppFragmentTv;
    private Unbinder unbinder;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_app, container, false);
        unbinder = ButterKnife.bind(this, view);


        aboutApp();

        setUpActivity();
        return view;
    }

    private void aboutApp() {
        getClient().appSetting(SharedPreferencesManger.LoadData(getActivity(), "api_token")).enqueue(new Callback<AppSettings>() {
            @Override
            public void onResponse(Call<AppSettings> call, Response<AppSettings> response) {
                try {
                    if (response.body().getStatus() == 1) {
                        aboutAppFragmentTv.setText(response.body().getAppSettingsData().getAboutApp());
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Call<AppSettings> call, Throwable t) {

            }
        });
    }
}
