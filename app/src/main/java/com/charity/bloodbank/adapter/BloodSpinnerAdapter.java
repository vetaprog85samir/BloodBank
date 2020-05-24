package com.charity.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.general.bloodTypes.BloodTypesData;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData;

import java.util.ArrayList;
import java.util.List;

public class BloodSpinnerAdapter extends BaseAdapter {

    private Context context;
    public List<BloodTypesData> bloodTypesDataList = new ArrayList<>();
    private LayoutInflater inflter;
    public int selectedId = 0;

    public BloodSpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;

        inflter = (LayoutInflater.from(applicationContext));
    }
    public void setData(List<BloodTypesData> bloodTypesDataList, String hint) {
        this.bloodTypesDataList = new ArrayList<>();
        this.bloodTypesDataList.add(new BloodTypesData(0, hint));
        this.bloodTypesDataList.addAll(bloodTypesDataList);
    }

    @Override
    public int getCount() {
        return bloodTypesDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_item_row, null);


        TextView names = view.findViewById(R.id.txt_spinner);

        names.setText(bloodTypesDataList.get(i).getName());
        selectedId = bloodTypesDataList.get(i).getId();

        return view;
    }
}