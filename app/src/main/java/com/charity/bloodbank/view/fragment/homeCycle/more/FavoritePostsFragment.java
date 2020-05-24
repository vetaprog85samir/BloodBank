package com.charity.bloodbank.view.fragment.homeCycle.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.charity.bloodbank.R;
import com.charity.bloodbank.adapter.FavoriteAdapter;
import com.charity.bloodbank.data.local.SharedPreferencesManger;
import com.charity.bloodbank.data.model.posts.postsFavourite.PostsFavourite;
import com.charity.bloodbank.data.model.posts.postsFavourite.PostsFavouriteData;
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
import static com.charity.bloodbank.data.local.SharedPreferencesManger.LoadData;


public class FavoritePostsFragment extends BaseFragment {


    @BindView(R.id.favourite_fragment_rv_data_list)
    RecyclerView favouriteFragmentRvDataList;
    private Unbinder unbinder;
    private OnEndLess onEndLess;
    private LinearLayoutManager linearLayoutManager;
    private List<PostsFavouriteData> postsFavouriteData = new ArrayList<>();
    private int maxPage = 0;
    private FavoriteAdapter favoriteAdapter;

    public FavoritePostsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);
        unbinder = ButterKnife.bind(this, v);
        init();
        setUpActivity();
        return v;
    }

    private void init() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        favouriteFragmentRvDataList.setLayoutManager(linearLayoutManager);
        onEndLess = new OnEndLess(linearLayoutManager,1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page<= maxPage) {
                  /*
                this condition if no data to view it set page at last page
                 */
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getFavoritePosts(current_page);
                    }else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }

                }
            }
        };
        favouriteFragmentRvDataList.addOnScrollListener(onEndLess);
        favoriteAdapter = new FavoriteAdapter(getActivity(),postsFavouriteData);
        favouriteFragmentRvDataList.setAdapter(favoriteAdapter);
        getFavoritePosts(1);

    }

    private void getFavoritePosts(int page) {
        getClient().getFavorite(LoadData(getActivity(),"api_token")).enqueue(new Callback<PostsFavourite>() {
            @Override
            public void onResponse(Call<PostsFavourite> call, Response<PostsFavourite> response) {
                try {
                    if (response.body().getStatus()==1) {
                        maxPage = response.body().getPostsFavouritePagination().getLastPage();
                        postsFavouriteData.addAll(response.body().getPostsFavouritePagination().getData());
                        favoriteAdapter.notifyDataSetChanged();
                    }
                    Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<PostsFavourite> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBack() {
        super.onBack();
    }
}
