package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.NotificationListAdapter;
import com.charity.bloodbank.data.model.notification.notification.Notification;
import com.charity.bloodbank.data.model.notification.notification.NotificationData;
import com.charity.bloodbank.utils.OnEndLess;
import com.charity.bloodbank.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.charity.bloodbank.data.api.RetrofitClient.getClient;


public class NotificationFragment extends BaseFragment {

    Unbinder unbinder;


    @BindView(R.id.fragment_notification_list_rv)
    RecyclerView fragmentNotificationListRv;
    private List<NotificationData> notificationData =new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private NotificationListAdapter adapter;
    private int maxPage = 0;
    private OnEndLess onEndLess;


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification_list, container, false);

        unbinder = ButterKnife.bind(this,v);

        init();

        setUpActivity();
        return v;
    }

    private void init() {

        linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentNotificationListRv.setLayoutManager(linearLayoutManager);

        onEndLess = new OnEndLess(linearLayoutManager,1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= maxPage) {
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        getNotificationList(current_page);
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        fragmentNotificationListRv.addOnScrollListener(onEndLess);

        adapter = new NotificationListAdapter(getActivity(),
                getActivity(), notificationData);
        fragmentNotificationListRv.setAdapter(adapter);

        getNotificationList(1);

    }

    private void getNotificationList(int page) {

        getClient().getNotificationList("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl",page).enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {

                try {

                    if (response.body().getStatus()==1) {

                        notificationData.addAll(response.body().getData().getData());
                        adapter.notifyDataSetChanged();

                    }

                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {

            }
        });

    }


    @Override
    public void onBack() {
        super.onBack();
    }
}
