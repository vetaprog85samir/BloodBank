
package com.charity.bloodbank.data.model.general.governorate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Governorate {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private List<com.charity.bloodbank.data.model.general.governorate.GovernorateData> data = null;

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

    public List<com.charity.bloodbank.data.model.general.governorate.GovernorateData> getData() {
        return data;
    }

    public void setData(List<com.charity.bloodbank.data.model.general.governorate.GovernorateData> data) {
        this.data = data;
    }

}
