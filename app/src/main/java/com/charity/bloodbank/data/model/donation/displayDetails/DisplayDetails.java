
package com.charity.bloodbank.data.model.donation.displayDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisplayDetails {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("displayDetailsData")
    @Expose
    private DisplayDetailsData displayDetailsData;

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

    public DisplayDetailsData getDisplayDetailsData() {
        return displayDetailsData;
    }

    public void setDisplayDetailsData(DisplayDetailsData displayDetailsData) {
        this.displayDetailsData = displayDetailsData;
    }

}
