package com.example.apiconnection;



import com.example.apiconnection.ModelResponses.LoginResponse;
import com.example.apiconnection.ModelResponses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("otp_login")
    Call<RegisterResponse> register(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("verify")
    Call<LoginResponse> login(@Field("phone") String phone,@Field("otp") int otp);

}
