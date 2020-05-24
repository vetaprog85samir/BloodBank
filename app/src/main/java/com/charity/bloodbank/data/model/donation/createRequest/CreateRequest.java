
package com.charity.bloodbank.data.model.donation.createRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateRequest {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("createRequestData")
    @Expose
    private CreateRequestData createRequestData;

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

    public CreateRequestData getCreateRequestData() {
        return createRequestData;
    }

    public void setCreateRequestData(CreateRequestData createRequestData) {
        this.createRequestData = createRequestData;
    }

}
