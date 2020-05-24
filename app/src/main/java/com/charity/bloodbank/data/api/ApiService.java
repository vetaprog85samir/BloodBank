package com.charity.bloodbank.data.api;


import com.charity.bloodbank.data.model.donation.allRequests.AllRequests;
import com.charity.bloodbank.data.model.donation.createRequest.CreateRequest;
import com.charity.bloodbank.data.model.general.appSettings.AppSettings;
import com.charity.bloodbank.data.model.general.bloodTypes.BloodTypes;
import com.charity.bloodbank.data.model.general.contact.Contact;
import com.charity.bloodbank.data.model.general.generalResponse.GeneralResponse;
import com.charity.bloodbank.data.model.notification.getNotificationSettings.GetNotificationSettings;
import com.charity.bloodbank.data.model.notification.notification.Notification;
import com.charity.bloodbank.data.model.notification.notificationSetting.NotificationSetting;
import com.charity.bloodbank.data.model.posts.allPosts.AllPosts;
import com.charity.bloodbank.data.model.posts.postsFavourite.PostsFavourite;
import com.charity.bloodbank.data.model.user.profile.Profile;
import com.charity.bloodbank.data.model.user.resetPassword.ResetPassword;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @POST("profile")
    @FormUrlEncoded
    Call<Profile> getProfile(@Field("api_token") String apiToken);


    @GET("governorates")
    Call<GeneralResponse> getGovernorate();

    @GET("cities")
    Call<GeneralResponse> getCities(@Query("governorate_id") int governorate_id);

    @GET("blood-types")
    Call<BloodTypes> getBloodType();

    @GET("donation-requests")
    Call<AllRequests> donationRequests(@Query("api_token") String apiToken,
                                       @Query("page") int page);

    @GET("donation-requests")
    Call<AllRequests> donationRequests(@Query("api_token") String apiToken,
                                       @Query("page") int page,
                                       @Query("blood_type_id") int bloodTypeId,
                                       @Query("city_id") int cityId);


    @POST("notifications-settings")
    @FormUrlEncoded
    Call<GetNotificationSettings> getNotificationSettings(@Field("api_token") String apiToken);

    @POST("notifications-settings")
    @FormUrlEncoded
    Call<GetNotificationSettings> setNotificationSettings(@Field("api_token") String apiToken,
                                                          @Field("governorates []") List<Integer> governorates,
                                                          @Field("blood_types []") List<Integer> bloodTypes);

    @POST("notifications-settings")
    @FormUrlEncoded
    Call<NotificationSetting> getNotificationSetting(@Field("api_token") String apiToken);

    @POST("notifications-settings")
    @FormUrlEncoded
    Call<NotificationSetting> setNotificationSetting(@Field("api_token") String apiToken,
                                                     @Field("governorates []") List<Integer> governorates,
                                                     @Field("blood_types []") List<Integer> bloodTypes);

    @GET("notifications")
    Call<Notification> getNotificationList(@Query("api_token") String apiToken,
                                           @Query("page") int page);

    @GET("posts")
    Call<AllPosts> getAllPosts(@Query("api_token") String apiToken,
                               @Query("page") int page);


    @GET("settings")
    Call<AppSettings> appSetting(@Query("api_token") String api_token);


    @GET("my-favourites")
    Call<PostsFavourite> getFavorite(@Query("api_token") String apiToken);


    @POST("contact")
    @FormUrlEncoded
    Call<Contact> sendMessage(@Field("api_token") String api_token,
                              @Field("title") String title,
                              @Field("message") String message);

    @POST("donation-request/create")
    @FormUrlEncoded
    Call<CreateRequest> createDonationRequest(@Field("api_token") String apiToken,
                                              @Field("patient_name") String patientName,
                                              @Field("patient_age") String patientAge,
                                              @Field("blood_type_id") String blood_type_id,
                                              @Field("bags_num") String bags_num,
                                              @Field("hospital_name") String hospital_name,
                                              @Field("hospital_address") String hospital_address,
                                              @Field("city_id") String city_id,
                                              @Field("phone") String phone,
                                              @Field("notes") String notes,
                                              @Field("latitude") String latitude,
                                              @Field("longitude") String longitude);

    @POST("reset-password")
    @FormUrlEncoded
    Call<ResetPassword> resetPassword(@Field("phone") String phone);

    @POST("new-password")
    @FormUrlEncoded
    Call<ResetPassword> newPassword(@Field("phone") String phone,
                                   @Field("pin_code") String pin_code,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation);
}
