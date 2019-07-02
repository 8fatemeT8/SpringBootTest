package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderJson {
    @JsonProperty("Food")
    private FoodInfo Food;
    @JsonProperty("Number")
    private int Number;

    public FoodInfo getFood() {
        return Food;
    }

    public void setFood(FoodInfo food) {
        Food = food;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
