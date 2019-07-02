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
        List<FoodInfo> foods= menuJson.getMenu();
        List<FoodInfo> result = new ArrayList<>();
        if (foodSearchJson.getSearchOption()==0){
            for(int i=0;i<foods.size();i++){
                if (Long.parseLong(foods.get(i).getPrice())<=Long.parseLong(foodSearchJson.getLessThanPrice())){
                    result.add(foods.get(i));
                    food = foods.get(i);
                    index = i;
                }
            }
        }
        else if(foodSearchJson.getSearchOption()==1){
            for(int i=0;i<foods.size();i++){
                if (foods.get(i).getName().contains(foodSearchJson.getSubName())){
                    result.add(foods.get(i));
                }
                }
        }
        else {
            result = null;
        }
        if (result!=null){
            MenuJson menuJson1=new MenuJson();
            menuJson1.setMenu(result);
            return menuJson1;
        }
        return null;
    }

}
