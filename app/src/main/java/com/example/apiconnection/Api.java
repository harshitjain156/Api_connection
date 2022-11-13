package com.example.apiconnection;



import com.example.apiconnection.ModelResponses.ContactUs.ContactResponse;
import com.example.apiconnection.ModelResponses.HomeResponses.Homeresponse;
import com.example.apiconnection.ModelResponses.LoginResponse;
import com.example.apiconnection.ModelResponses.RegisterResponse;
import com.example.apiconnection.ModelResponses.ResendOtp;
import com.example.apiconnection.ModelResponses.Search.SearchResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @POST("auth/otp_login")
    Call<RegisterResponse> register(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("auth/verify")
    Call<LoginResponse> login(@Field("phone") String phone,@Field("otp") int otp);

    @FormUrlEncoded
    @POST("auth/resend_otp")
    Call<ResendOtp> resend(@Field("phone") String phone);

    @GET("home/")
    Call<Homeresponse> getData();


//    @Headers({"Authorization:"+"Bearer "+token})

    @GET("drug/")
    Call<SearchResponse> search(@Query("page") int no,@Query("search") String search_item,@Header("authorization") String token);

    @FormUrlEncoded
    @POST("contact/")
    Call<ContactResponse> contact(@Field("first_name") String first_name,@Field("last_name") String last_name,@Field("email") String email,@Field("phone") String phone,@Field("subject") String subject,@Field("message") String message);

}
