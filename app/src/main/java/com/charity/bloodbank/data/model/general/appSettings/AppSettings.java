
package com.charity.bloodbank.data.model.general.appSettings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppSettings {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("appSettingsData")
    @Expose
    private AppSettingsData appSettingsData;

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

    public AppSettingsData getAppSettingsData() {
        return appSettingsData;
    }

    public void setAppSettingsData(AppSettingsData appSettingsData) {
        this.appSettingsData = appSettingsData;
    }

}
