
package com.charity.bloodbank.data.model.notification.getNotificationSettings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetNotificationSettings {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("getNotificationSettingsData")
    @Expose
    private GetNotificationSettingsData getNotificationSettingsData;

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

    public GetNotificationSettingsData getGetNotificationSettingsData() {
        return getNotificationSettingsData;
    }

    public void setGetNotificationSettingsData(GetNotificationSettingsData getNotificationSettingsData) {
        this.getNotificationSettingsData = getNotificationSettingsData;
    }

}
