package com.example.apiconnection.ModelResponses.ContactUs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactResponse {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }
}
