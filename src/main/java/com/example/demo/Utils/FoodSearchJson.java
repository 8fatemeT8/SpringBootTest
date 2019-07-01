package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodSearchJson {
    @JsonProperty("SubName")
    private String SubName;
    @JsonProperty("LessThanPrice")
    private String LessThanPrice;

    public void setLessThanPrice(String lessThanPrice) {
        LessThanPrice = lessThanPrice;
    }

    public String getLessThanPrice() {
        return LessThanPrice;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }
}
