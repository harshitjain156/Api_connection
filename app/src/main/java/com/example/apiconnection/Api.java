package com.example.apiconnection;



import com.example.apiconnection.ModelResponses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("auth/otp_login")
    Call<RegisterResponse> register(@Field("phone") String phone);


}
