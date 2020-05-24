package com.charity.bloodbank.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.posts.allPosts.AllPostsData;
import com.charity.bloodbank.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {



    private Context context;
    private BaseActivity activity;
    private List<AllPostsData> allPostsDataList = new ArrayList<>();

    public PostsAdapter(Context context, Activity activity, List<AllPostsData> allPostsDataList) {
        this.context = context;
        this.activity = (BaseActivity) activity;
        this.allPostsDataList = allPostsDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_posts_row_item,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {

        holder.fragmentPostsRowItemTv.setText(allPostsDataList.get(position).getTitle());

    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allPostsDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fragment_posts_row_item_tv)
        TextView fragmentPostsRowItemTv;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
