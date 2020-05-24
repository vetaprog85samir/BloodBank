package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.charity.bloodbank.R;
import com.charity.bloodbank.data.model.posts.allPosts.AllPostsData;
import com.charity.bloodbank.data.model.posts.postsFavourite.PostsFavouriteData;
import com.charity.bloodbank.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.charity.bloodbank.utils.HelperMethod.onLoadImageFromUrl;


public class PostDetailsFragment extends BaseFragment {


    @BindView(R.id.post_details_fragment_iv_)
    ImageView postDetailsFragmentIv;
    @BindView(R.id.post_details_fragment_tv_title)
    TextView postDetailsFragmentTvTitle;
    @BindView(R.id.post_details_fragment_tv_desc)
    TextView postDetailsFragmentTvDesc;
    private Unbinder unbinder;

    public AllPostsData postData;
    public PostsFavouriteData favoriteData;

    public PostDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details_post, container, false);
        unbinder = ButterKnife.bind(this,v);
        getPostDetails();
        setUpActivity();
        return v;
    }

    private void getPostDetails() {

        onLoadImageFromUrl(postDetailsFragmentIv,postData.getThumbnailFullPath(),getActivity());
        postDetailsFragmentTvTitle.setText(postData.getTitle());
        postDetailsFragmentTvDesc.setText(postData.getContent());

    }

    @Override
    public void onBack() {
        super.onBack();
    }
}
