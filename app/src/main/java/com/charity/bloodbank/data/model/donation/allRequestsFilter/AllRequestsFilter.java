
package com.charity.bloodbank.data.model.donation.allRequestsFilter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllRequestsFilter {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("allRequestsFilterPagination")
    @Expose
    private AllRequestsFilterPagination allRequestsFilterPagination;

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

    public AllRequestsFilterPagination getAllRequestsFilterPagination() {
        return allRequestsFilterPagination;
    }

    public void setAllRequestsFilterPagination(AllRequestsFilterPagination allRequestsFilterPagination) {
        this.allRequestsFilterPagination = allRequestsFilterPagination;
    }

}
