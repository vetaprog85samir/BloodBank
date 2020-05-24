package com.charity.bloodbank.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.donation.allRequests.AllRequestData;
import com.charity.bloodbank.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class

DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {
    private Context context;
    private BaseActivity activity;
    private List<AllRequestData> donationDataList = new ArrayList<>();

    public DonationAdapter(Context context,Activity activity, List<AllRequestData> donationDataList) {

        this.activity = (BaseActivity) activity;
        this.donationDataList = donationDataList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_donation,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {

    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

            return donationDataList.size() ;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
