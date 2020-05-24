
package com.charity.bloodbank.data.model.notification.changeNotificationSettings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeNotificationSettings {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("changeNotificationSettingsData")
    @Expose
    private ChangeNotificationSettingsData changeNotificationSettingsData;

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

    public ChangeNotificationSettingsData getChangeNotificationSettingsData() {
        return changeNotificationSettingsData;
    }

    public void setChangeNotificationSettingsData(ChangeNotificationSettingsData changeNotificationSettingsData) {
        this.changeNotificationSettingsData = changeNotificationSettingsData;
    }

}
