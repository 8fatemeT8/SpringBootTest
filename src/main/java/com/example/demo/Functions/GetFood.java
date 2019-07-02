package com.example.demo.Functions;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.FoodUpdateJson;
import com.example.demo.Utils.MenuJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetFood {
    private int index;
    private FoodInfo foodInfo;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public FoodInfo getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(FoodInfo foodInfo) {
        this.foodInfo = foodInfo;
    }

    public boolean getFood(FoodUpdateJson foodUpdateJson, MenuJson menuJson){
        if (foodUpdateJson.getGetBy()==0){
            List<FoodInfo> foods = menuJson.getMenu();
            for (int i=0;i<foods.size();i++){
                if(foodUpdateJson.getName().equals(foods.get(i).getName())){
                    index = i;
                    foodInfo = foods.get(i);
                    return true;
                }
            }
        }
        else if (foodUpdateJson.getGetBy()==1){
            List<FoodInfo> foods = menuJson.getMenu();
            for (int i=0;i<foods.size();i++){
                if(foodUpdateJson.getId()==foods.get(i).getId()){
                    index = i;
                    foodInfo = foods.get(i);
                    return true;
                }
                if(i==foods.size()-1){
                    return false;
                }
            }
        }
        return false;
    }
}
