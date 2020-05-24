package com.charity.bloodbank.view.fragment.userCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.user.resetPassword.ResetPassword;
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


public class ForgetPasswordStepOneFragment extends BaseFragment {


    @BindView(R.id.fragment_forget_password_step_one_ti_phone)
    TextInputLayout fragmentForgetPasswordStepOneTiPhone;
    private Unbinder unbinder;
    public String phone;

    public ForgetPasswordStepOneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forget_password_step_one, container, false);
        unbinder = ButterKnife.bind(this,v);
        setUpActivity();
        return v;
    }

    @Override
    public void onBack() {
        super.onBack();
    }

    @OnClick(R.id.btn_edit)
    public void onViewClicked() {
        phone = fragmentForgetPasswordStepOneTiPhone.getEditText().getText().toString();
        getResetPassword(phone);
    }

    private void getResetPassword(String phone) {
        getClient().resetPassword(phone).enqueue(new Callback<ResetPassword>() {
            @Override
            public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                try {
                    if (response.body().getStatus()==1) {
                        Toast.makeText(baseActivity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        ForgetPasswordStepTwoFragment forgetPasswordStepTwoFragment = new ForgetPasswordStepTwoFragment();
                        forgetPasswordStepTwoFragment.phone = phone;
                        HelperMethod.replaceFragment(getChildFragmentManager(),R.id.forget_password_step_one_layout,forgetPasswordStepTwoFragment);
                    }
                    Toast.makeText(baseActivity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<ResetPassword> call, Throwable t) {

            }
        });
    }
}
