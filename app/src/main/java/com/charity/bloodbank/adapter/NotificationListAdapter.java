package com.charity.bloodbank.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.notification.notification.NotificationData;
import com.charity.bloodbank.view.activity.BaseActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class

NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ViewHolder> {



    private Context context;
    private BaseActivity activity;
    private List<NotificationData> notificationData;

    public NotificationListAdapter(Context context, Activity activity, List<NotificationData> notificationsListData) {
        this.context = context;
        this.activity = (BaseActivity) activity;
        this.notificationData = notificationsListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list_row_item,
                parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {

        if (notificationData.get(position).getPivot().getIsRead().equals(0)) {

            holder.notificationListRowItemIv.setImageResource(R.drawable.ic_notifications_list);

        } else {

            holder.notificationListRowItemIv.setImageResource(R.drawable.ic_notifications_list_none);

        }
        holder.notificationListRowItemTvNotification.setText(notificationData.get(position).getTitle());

    }

    private void setAction(ViewHolder holder, int position) {

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.notification_list_row_item_iv)
        ImageView notificationListRowItemIv;
        @BindView(R.id.notification_list_row_item_tv_notification)
        TextView notificationListRowItemTvNotification;
        @BindView(R.id.notification_list_row_item_tv_timer)
        TextView notificationListRowItemTvTimer;



        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
