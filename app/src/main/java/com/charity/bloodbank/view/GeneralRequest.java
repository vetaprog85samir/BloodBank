package com.charity.bloodbank.view;


import android.app.Activity;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.charity.bloodbank.adapter.BloodSpinnerAdapter;
import com.charity.bloodbank.adapter.CitySpinnerAdapter;
import com.charity.bloodbank.adapter.GovSpinnerAdapter;
import com.charity.bloodbank.data.model.general.bloodTypes.BloodTypes;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralRequest   {

    public static void getSpinnerData(Call<GeneralResponse> call, Spinner spinner, GovSpinnerAdapter adapter, Integer selectedId, String hint, AdapterView.OnItemSelectedListener listener) {


        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

                try {

                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.generalResponseDataList.size(); i++) {

                        if (adapter.generalResponseDataList.get(i).getId() == selectedId) {

                            spinner.setSelection(i);
                            break;

                        }

                    }

                    spinner.setOnItemSelectedListener(listener);


                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });



    }

//___________________________________________________________________________________________________________________________________________________

    public static void getSpinnerData(Call<GeneralResponse> call, Spinner spinner, GovSpinnerAdapter adapter,
                                Integer selectedId, String hint) {

        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

                try {

                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.generalResponseDataList.size(); i++) {

                        if (adapter.generalResponseDataList.get(i).getId() == selectedId) {

                            spinner.setSelection(i);
                            break;

                        }



                    }


                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });

    }
//___________________________________________________

    public static void getSpinnerData(Call<GeneralResponse> call, Spinner spinner, CitySpinnerAdapter adapter,
                                      Integer selectedId, String hint) {

        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

                try {

                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.generalResponseDataList.size(); i++) {

                        if (adapter.generalResponseDataList.get(i).getId() == selectedId) {

                            spinner.setSelection(i);
                            break;

                        }



                    }


                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });

    }
//____________________________________________________

    public static void getSpinnerData(Call<BloodTypes> call, Spinner spinner, BloodSpinnerAdapter adapter,
                                      Integer selectedId, String hint) {

        call.enqueue(new Callback<BloodTypes>() {
            @Override
            public void onResponse(Call<BloodTypes> call, Response<BloodTypes> response) {

                try {

                    adapter.setData(response.body().getData(), hint);
                    spinner.setAdapter(adapter);

                    for (int i = 0; i < adapter.bloodTypesDataList.size(); i++) {

                        if (adapter.bloodTypesDataList.get(i).getId() == selectedId) {

                            spinner.setSelection(i);
                            break;

                        }



                    }


                } catch (Exception e) {
                }

            }

            @Override
            public void onFailure(Call<BloodTypes> call, Throwable t) {

            }
        });

    }


//----------------------------------------------
    public static void getSpinnerData(Activity activity, Spinner spinner, GovSpinnerAdapter adapter, String hint, Call<GeneralResponse> method){


        method.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

                try {

                    if(response.body().getStatus()==1){

                        adapter.setData(response.body().getData(),hint);
                        spinner.setAdapter(adapter);
                    }

                } catch (Exception e) {
                }
            }
            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });

    }

//--------------------------------------------

    public static void getSpinnerData(Activity activity, Spinner spinner, BloodSpinnerAdapter adapter, String hint, Call<BloodTypes> method){


        method.enqueue(new Callback<BloodTypes>() {
            @Override
                public void onResponse(Call<BloodTypes> call, Response<BloodTypes> response) {

                try {

                    if(response.body().getStatus()==1){

                        adapter.setData(response.body().getData(),hint);
                        spinner.setAdapter(adapter);
                    }

                } catch (Exception e) {
                }
            }
            @Override
            public void onFailure(Call<BloodTypes> call, Throwable t) {

            }
        });

    }


}
