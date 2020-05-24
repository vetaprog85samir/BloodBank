
package com.charity.bloodbank.data.model.general.generalResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneralResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private List<com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData> data = null;



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

    public List<com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData> getData() {
        return data;
    }

    public void setData(List<com.charity.bloodbank.data.model.general.generalResponse.GeneralResponseData> data) {
        this.data = data;
    }

}
