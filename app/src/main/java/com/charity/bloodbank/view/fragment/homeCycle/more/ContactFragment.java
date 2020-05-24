package com.charity.bloodbank.view.fragment.homeCycle.more;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.local.SharedPreferencesManger;
import com.charity.bloodbank.data.model.general.appSettings.AppSettings;
import com.charity.bloodbank.data.model.general.contact.Contact;
import com.charity.bloodbank.view.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;
import static com.charity.bloodbank.data.local.SharedPreferencesManger.LoadData;


public class ContactFragment extends BaseFragment {


    @BindView(R.id.contact_us_fragment_tv_phone)
    TextView contactUsFragmentTvPhone;
    @BindView(R.id.contact_us_fragment_tv_email)
    TextView contactUsFragmentTvEmail;
    @BindView(R.id.contact_us_fragment_bt_facebook)
    Button contactUsFragmentBtFacebook;
    @BindView(R.id.contact_us_fragment_bt_twitter)
    Button contactUsFragmentBtTwitter;
    @BindView(R.id.contact_us_fragment_bt_youtube)
    Button contactUsFragmentBtYoutube;
    @BindView(R.id.contact_us_fragment_bt_instgram)
    Button contactUsFragmentBtInstgram;
    @BindView(R.id.contact_us_fragment_bt_whatsApp)
    Button contactUsFragmentBtWhatsApp;
    @BindView(R.id.contact_us_fragment_et_name)
    EditText contactUsFragmentEtName;
    @BindView(R.id.contact_us_fragment_et_ph)
    EditText contactUsFragmentEtPh;
    @BindView(R.id.contact_us_fragment_et_message)
    EditText contactUsFragmentEtMessage;
    @BindView(R.id.contact_us_fragment_bt_send)
    Button contactUsFragmentBtSend;
    private Unbinder unbinder;
    private List<ResolveInfo> activities;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);
        unbinder = ButterKnife.bind(this, v);
        getContact();
        setUpActivity();
        return v;
    }

    private void getContact() {
        getClient().appSetting(LoadData(getActivity(),"api_token")).enqueue(new Callback<AppSettings>() {
            @Override
            public void onResponse(Call<AppSettings> call, Response<AppSettings> response) {
                try {
                    if (response.body().getStatus()==1) {
                        contactUsFragmentTvPhone.setText(response.body().getAppSettingsData().getPhone());
                        contactUsFragmentTvEmail.setText(response.body().getAppSettingsData().getEmail());
                        contactUsFragmentBtFacebook.setText(response.body().getAppSettingsData().getFacebookUrl());
                        contactUsFragmentBtYoutube.setText(response.body().getAppSettingsData().getYoutubeUrl());
                        contactUsFragmentBtTwitter.setText(response.body().getAppSettingsData().getTwitterUrl());
                        contactUsFragmentBtInstgram.setText(response.body().getAppSettingsData().getInstagramUrl());
                        contactUsFragmentBtWhatsApp.setText(response.body().getAppSettingsData().getWhatsapp());
                        Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<AppSettings> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick({R.id.contact_us_fragment_tv_phone, R.id.contact_us_fragment_tv_email, R.id.contact_us_fragment_bt_facebook, R.id.contact_us_fragment_bt_twitter, R.id.contact_us_fragment_bt_youtube, R.id.contact_us_fragment_bt_instgram, R.id.contact_us_fragment_bt_whatsApp, R.id.contact_us_fragment_bt_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.contact_us_fragment_tv_phone:
                Intent intentPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactUsFragmentTvPhone.getText().toString()));
                startActivity(intentPhone);
                break;
            case R.id.contact_us_fragment_tv_email:
                break;
            case R.id.contact_us_fragment_bt_facebook:
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW);
                PackageManager facebookPackageManager = getActivity().getPackageManager();
                activities = facebookPackageManager.queryIntentActivities(intentFacebook,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentFacebookSafe = activities.size() > 0;
                if (isIntentFacebookSafe) {
                    startActivity(intentFacebook);
                }
                break;
            case R.id.contact_us_fragment_bt_twitter:
                Intent intentTwitter = new Intent(Intent.ACTION_VIEW);
                PackageManager twitterPackageManager = getActivity().getPackageManager();
                activities = twitterPackageManager.queryIntentActivities(intentTwitter,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentTwitterSafe = activities.size() > 0;
                if (isIntentTwitterSafe) {
                    startActivity(intentTwitter);
                }
                break;
            case R.id.contact_us_fragment_bt_youtube:
                Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
                PackageManager youtubePackageManager = getActivity().getPackageManager();
                activities = youtubePackageManager.queryIntentActivities(intentYoutube,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentYoutubeSafe = activities.size() > 0;
                if (isIntentYoutubeSafe) {
                    startActivity(intentYoutube);
                }
                break;
            case R.id.contact_us_fragment_bt_instgram:
                Intent intentInstgram = new Intent(Intent.ACTION_VIEW);
                PackageManager instgramPackageManager = getActivity().getPackageManager();
                activities = instgramPackageManager.queryIntentActivities(intentInstgram,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentInstgramSafe = activities.size() > 0;
                if (isIntentInstgramSafe) {
                    startActivity(intentInstgram);
                }
                break;
            case R.id.contact_us_fragment_bt_whatsApp:
                Intent intentWhatsApp = new Intent(Intent.ACTION_VIEW);
                PackageManager whatsAppPackageManager = getActivity().getPackageManager();
                activities = whatsAppPackageManager.queryIntentActivities(intentWhatsApp,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentWhatsAppSafe = activities.size() > 0;
                if (isIntentWhatsAppSafe) {
                    startActivity(intentWhatsApp);
                }
                break;
            case R.id.contact_us_fragment_bt_send:
                String name = contactUsFragmentEtName.getText().toString();
                String phone = contactUsFragmentEtPh.getText().toString();
                String message = contactUsFragmentEtMessage.getText().toString();
                sendMessage(name, phone, message);
                break;
        }
    }

    private void sendMessage(String name, String phone, String message) {
        getClient().sendMessage(LoadData(getActivity(),"api_token"),"title","contact").enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                try {
                    if (response.body().getStatus()==1) {
                        response.body().getContactData().getTitle();
                        response.body().getContactData().getMessage();
                        Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){}

            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });
    }
}
