package com.charity.bloodbank.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.posts.postsFavourite.PostsFavouriteData;
import com.charity.bloodbank.view.activity.BaseActivity;
import com.charity.bloodbank.view.fragment.homeCycle.home.PostDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.charity.bloodbank.utils.HelperMethod.onLoadImageFromUrl;

public class

FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<PostsFavouriteData> postsFavouriteData = new ArrayList<>();

    public FavoriteAdapter(Activity activity, List<PostsFavouriteData> postsFavouriteData) {
        this.activity = activity;
        this.postsFavouriteData = postsFavouriteData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post_recycler_view,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.postTvFragment.setText(postsFavouriteData.get(position).getTitle());
        onLoadImageFromUrl(holder.postIvFragment, postsFavouriteData.get(position).getThumbnailFullPath(), activity);
    }

    private void setAction(ViewHolder holder, int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostDetailsFragment postDetailsFragment = new PostDetailsFragment();
                postDetailsFragment.favoriteData = postsFavouriteData.get(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        @BindView(R.id.post_favorite)
        ImageView postFavorite;
        @BindView(R.id.post_tv_fragment)
        TextView postTvFragment;
        @BindView(R.id.item_linear_id)
        LinearLayout itemLinearId;
        @BindView(R.id.post_iv_fragment)
        ImageView postIvFragment;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
