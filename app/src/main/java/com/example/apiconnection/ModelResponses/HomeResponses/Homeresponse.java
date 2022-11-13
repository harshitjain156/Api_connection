package com.example.apiconnection.ModelResponses.HomeResponses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Homeresponse {
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Homeresponse(List<Datum> data) {
        this.data = data;
    }

    public Homeresponse withData(List<Datum> data) {
        this.data = data;
        return this;
    }
}

