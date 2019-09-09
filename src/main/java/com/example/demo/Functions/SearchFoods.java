package com.example.demo.Functions;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.Utils.MenuJson;

import java.util.ArrayList;
import java.util.List;

public class SearchFoods {

    private int index=-1;
    private FoodInfo food=new FoodInfo();

    public FoodInfo getFood() {
        return food;
    }

    public int getIndex() {
        return index;
    }

    public MenuJson search(FoodSearchJson foodSearchJson,MenuJson menuJson){
        if(foodSearchJson.getPrice().equals("undefined")||foodSearchJson.getPrice().equals(""))foodSearchJson.setPrice("0");
        if(foodSearchJson.getName().equals("undefined"))foodSearchJson.setName("");
        List<FoodInfo> foods= menuJson.getMenu();
        List<FoodInfo> result = new ArrayList<>();
            for(int i=0;i<foods.size();i++){
                if (((Long.parseLong(foods.get(i).getPrice())<=Long.parseLong(foodSearchJson.getPrice())&&Long.parseLong(foodSearchJson.getPrice())!=0)||Long.parseLong(foodSearchJson.getPrice())==0)&&((foods.get(i).getName().toLowerCase().contains(foodSearchJson.getName().toLowerCase())&&foodSearchJson.getName().length()!=0)||(foodSearchJson.getName().length()==0))){
                    result.add(foods.get(i));
                    food = foods.get(i);
                    index = i;

                }
            }
        if (result.size()!=0){
            MenuJson menuJson1=new MenuJson();
            menuJson1.setMenu(result);
            return menuJson1;
        }
        return null;
    }

}
