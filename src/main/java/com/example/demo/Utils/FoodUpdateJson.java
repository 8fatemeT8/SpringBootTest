package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodUpdateJson {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("type")
    private int type;
    @JsonProperty("dateObject")
    private String dateObject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FoodUpdateJson() {

    }

    public FoodUpdateJson(int id, int getBy) {
        id = id;
    }
}