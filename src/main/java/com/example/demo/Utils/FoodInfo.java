package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodInfo {
    @JsonProperty("id")
    private int Id;
    @JsonProperty("name")
    private String Name;
    @JsonProperty("price")
    private String Price;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("type")
    private int type;
    @JsonProperty("time")
    private String time;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
