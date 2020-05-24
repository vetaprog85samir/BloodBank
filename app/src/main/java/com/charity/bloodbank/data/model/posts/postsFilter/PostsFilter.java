
package com.charity.bloodbank.data.model.posts.postsFilter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsFilter {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("postsFilterPagination")
    @Expose
    private PostsFilterPagination postsFilterPagination;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PostsFilterPagination getPostsFilterPagination() {
        return postsFilterPagination;
    }

    public void setPostsFilterPagination(PostsFilterPagination postsFilterPagination) {
        this.postsFilterPagination = postsFilterPagination;
    }

}
