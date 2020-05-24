package com.charity.bloodbank.view.fragment.userCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.user.resetPassword.ResetPassword;
import com.charity.bloodbank.view.activity.HomeCycleActivity;
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


public class ForgetPasswordStepTwoFragment extends BaseFragment {


    @BindView(R.id.fragment_forget_password_step_two_ti_code)
    TextInputLayout fragmentForgetPasswordStepTwoTiCode;
    @BindView(R.id.fragment_forget_password_step_two_ti_new_pass)
    TextInputLayout fragmentForgetPasswordStepTwoTiNewPass;
    @BindView(R.id.fragment_forget_password_step_two_ti_confirm_new_pass)
    TextInputLayout fragmentForgetPasswordStepTwoTiConfirmNewPass;

    private Unbinder unbinder;

    public String phone;

    public ForgetPasswordStepTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forget_password_step_two, container, false);
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
        String code = fragmentForgetPasswordStepTwoTiCode.getEditText().getText().toString();
        String newPassword = fragmentForgetPasswordStepTwoTiNewPass.getEditText().getText().toString();
        String confirmPassword = fragmentForgetPasswordStepTwoTiConfirmNewPass.getEditText().getText().toString();
        getNewPassword(phone,code,newPassword,confirmPassword);
    }

    private void getNewPassword(String phone, String code, String newPassword, String confirmPassword) {
        getClient().newPassword(phone,code,newPassword,confirmPassword).enqueue(new Callback<ResetPassword>() {
            @Override
            public void onResponse(Call<ResetPassword> call, Response<ResetPassword> response) {
                try {
                    if (response.body().getStatus()==1) {
                        Intent intent = new Intent(getActivity(), HomeCycleActivity.class);
                        startActivity(intent);
                        response.body().getResetPasswordData();
                        Toast.makeText(baseActivity, response.body().getMsg(), Toast.LENGTH_SHORT).show();
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
