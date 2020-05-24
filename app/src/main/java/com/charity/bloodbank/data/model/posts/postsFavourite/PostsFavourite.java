
package com.charity.bloodbank.data.model.posts.postsFavourite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsFavourite {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("postsFavouritePagination")
    @Expose
    private PostsFavouritePagination postsFavouritePagination;

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

    public PostsFavouritePagination getPostsFavouritePagination() {
        return postsFavouritePagination;
    }

    public void setPostsFavouritePagination(PostsFavouritePagination postsFavouritePagination) {
        this.postsFavouritePagination = postsFavouritePagination;
    }

}
