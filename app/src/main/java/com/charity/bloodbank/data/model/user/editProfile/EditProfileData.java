
package com.charity.bloodbank.data.model.user.editProfile;

import com.charity.bloodbank.data.model.user.profile.Client;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditProfileData {

    @SerializedName("client")
    @Expose
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
