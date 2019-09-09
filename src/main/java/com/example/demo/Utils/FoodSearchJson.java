package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodSearchJson {
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("page")
    private String page;




    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
