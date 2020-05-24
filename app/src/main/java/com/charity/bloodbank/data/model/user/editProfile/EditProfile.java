
package com.charity.bloodbank.data.model.user.editProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditProfile {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("editProfileData")
    @Expose
    private EditProfileData editProfileData;

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

    public EditProfileData getEditProfileData() {
        return editProfileData;
    }

    public void setEditProfileData(EditProfileData editProfileData) {
        this.editProfileData = editProfileData;
    }

}
