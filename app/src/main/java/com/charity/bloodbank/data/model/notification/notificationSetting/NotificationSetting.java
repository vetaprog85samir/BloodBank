
package com.charity.bloodbank.data.model.notification.notificationSetting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationSetting {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("notificationSettingData")
    @Expose
    private NotificationSettingData notificationSettingData;

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

    public NotificationSettingData getNotificationSettingData() {
        return notificationSettingData;
    }

    public void setNotificationSettingData(NotificationSettingData notificationSettingData) {
        this.notificationSettingData = notificationSettingData;
    }

}
