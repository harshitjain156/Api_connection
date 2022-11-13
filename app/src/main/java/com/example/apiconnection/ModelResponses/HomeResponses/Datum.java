package com.example.apiconnection.ModelResponses.HomeResponses;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Datum {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public class Item {

        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("class")
        @Expose
        private String _class;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("mrp")
        @Expose
        private Double mrp;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClass_() {
            return _class;
        }

        public void setClass_(String _class) {
            this._class = _class;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getMrp() {
            return mrp;
        }

        public void setMrp(Double mrp) {
            this.mrp = mrp;
        }

    }


}
