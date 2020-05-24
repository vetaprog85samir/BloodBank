package com.charity.bloodbank.view.fragment.homeCycle.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.PostsAdapter;
import com.charity.bloodbank.data.model.posts.allPosts.AllPosts;
import com.charity.bloodbank.data.model.posts.allPosts.AllPostsData;
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


public class PostsFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.fragment_posts_rv)
    RecyclerView fragmentPostsRv;
    private LinearLayoutManager linearLayoutManager;
    private List<AllPostsData> allPostsData = new ArrayList<>();
    private PostsAdapter postsAdapter;
    private OnEndLess onEndLess;
    private int maxPage = 0;


    public PostsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_posts, container, false);

        unbinder = ButterKnife.bind(this, v);

        init();

        setUpActivity();

        return v;
    }

    private void init() {

        linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentPostsRv.setLayoutManager(linearLayoutManager);

        onEndLess = new OnEndLess(linearLayoutManager,1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= maxPage) {
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;

                        getAllPosts(current_page);
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        fragmentPostsRv.addOnScrollListener(onEndLess);

        postsAdapter = new PostsAdapter(getActivity(),getActivity(),
                allPostsData);
        fragmentPostsRv.setAdapter(postsAdapter);

        getAllPosts(1);

    }

    private void getAllPosts(int page) {

        getClient().getAllPosts("Zz9HuAjCY4kw2Ma2XaA6x7T5O3UODws1UakXI9vgFVSoY3xUXYOarHX2VH27",page).enqueue(new Callback<AllPosts>() {
            @Override
            public void onResponse(Call<AllPosts> call, Response<AllPosts> response) {
                try {

                    if (response.body().getStatus()==1) {
                        allPostsData.addAll(response.body().getData().getData());
                        postsAdapter.notifyDataSetChanged();
                    }

                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<AllPosts> call, Throwable t) {

            }
        });

    }

    @Override
    public void onBack() {
        super.onBack();
    }
}
