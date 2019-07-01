package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;


public class MenuJson {
    public List<FoodInfo> getMenu() {
        return Menu;
    }

    public void setMenu(List<FoodInfo> menu) {
        Menu = menu;
    }

    @JsonProperty("Menu")
    private List<FoodInfo> Menu=new ArrayList<FoodInfo>();
}
