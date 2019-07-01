package com.example.demo.Functions;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.MenuJson;

import java.util.ArrayList;
import java.util.List;

public class SetMenu {
    public static MenuJson setMenuJson(){
        MenuJson menuJson=new MenuJson();
        List<FoodInfo> Foods=new ArrayList<>();
        FoodInfo food=new FoodInfo();
        food.setId(0);
        food.setName("CheeseBerger");
        food.setPrice("18000");
        Foods.add(food);
        food=new FoodInfo();
        food.setId(1);
        food.setName("Margarita");
        food.setPrice("32000");
        Foods.add(food);
        menuJson.setMenu(Foods);
        return menuJson;
    }
}
