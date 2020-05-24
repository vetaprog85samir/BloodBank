package com.charity.bloodbank.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.general.bloodTypes.BloodTypesData;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BloodNotificationSettingAdapter extends RecyclerView.Adapter<BloodNotificationSettingAdapter.ViewHolder> {


    private Context context;
    private Activity activity;
    private List<BloodTypesData> bloodTypesDataList;
    private List<String> oldIds;
    public List<Integer> newIds = new ArrayList<>();
    Unbinder unbind;


    public BloodNotificationSettingAdapter(Activity activity, Context context,
                                           List<BloodTypesData> bloodTypesDataList,
                                           List<String> oldIds) {

        this.context = context;
        this.activity = activity;
        this.bloodTypesDataList = bloodTypesDataList;
        this.oldIds = oldIds;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_check_box,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setDataBlood(holder,position,bloodTypesDataList);
    }

    private void setDataBlood(ViewHolder holder, int position, List<BloodTypesData> bloodTypesDataList) {

        holder.checkBoxItem.setText(bloodTypesDataList.get(position).getName());

        if (oldIds.contains(String.valueOf(bloodTypesDataList.get(position).getId()))) {
            holder.checkBoxItem.setChecked(true);
            newIds.add(bloodTypesDataList.get(position).getId());
        }else {
            holder.checkBoxItem.setChecked(false);
        }

    }




    @Override
    public int getItemCount() {
        return bloodTypesDataList.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.check_box_item)
        CheckBox checkBoxItem;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            unbind = ButterKnife.bind(this, view);
        }

        @OnClick(R.id.check_box_item)
        public void onViewClicked() {

            if (!checkBoxItem.isChecked()) {
                for (int i = 0; i < newIds.size() ; i++) {
                    if ((newIds.get(i).equals(bloodTypesDataList
                            .get(getAdapterPosition()).getId()))) {
                        newIds.remove(i);
                        break;
                    }
                }
            }else {
                newIds.add(bloodTypesDataList.get(getAdapterPosition()).getId());
            }

        }
    }
}
