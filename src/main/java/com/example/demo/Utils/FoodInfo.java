package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodInfo {
    @JsonProperty("Id")
    private int Id;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Price")
    private String Price;

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
