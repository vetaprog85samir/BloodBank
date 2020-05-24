package com.charity.bloodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData;

import java.util.ArrayList;
import java.util.List;

public class CitySpinnerAdapter extends BaseAdapter {

    private Context context;
    public List<GeneralResponseData> generalResponseDataList = new ArrayList<>();
    private LayoutInflater inflter;
    public int selectedId = 0;

    public CitySpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;

        inflter = (LayoutInflater.from(applicationContext));
    }
    public void setData(List<GeneralResponseData> generalResponseDataList, String hint) {
        this.generalResponseDataList = new ArrayList<>();
        this.generalResponseDataList.add(new GeneralResponseData(0, hint));
        this.generalResponseDataList.addAll(generalResponseDataList);
    }



    @Override
    public int getCount() {
        return generalResponseDataList.size();
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

        names.setText(generalResponseDataList.get(i).getName());
        selectedId = generalResponseDataList.get(i).getId();

        return view;
    }
}