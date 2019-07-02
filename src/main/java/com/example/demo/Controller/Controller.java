package com.example.demo.Controller;

import com.example.demo.Functions.GetFood;
import com.example.demo.Functions.SearchFoods;
import com.example.demo.Functions.SetMenu;
import com.example.demo.Utils.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class Controller {

    MenuJson menuJson = SetMenu.setMenuJson();
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("it's working");
    }

    @RequestMapping(value = "/Menu",method = RequestMethod.GET)
    public ResponseEntity<MenuJson> Menu(){
        return ResponseEntity.ok(menuJson);
    }

    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public ResponseEntity<MenuJson> Search(@RequestBody FoodSearchJson foodSearchJson) throws Exception {
        SearchFoods searchFoods=new SearchFoods();
        MenuJson resultJson = searchFoods.search(foodSearchJson,menuJson);
        if (resultJson!=null){
            return ResponseEntity.ok(resultJson);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @RequestMapping(value = "/Delete",method = RequestMethod.POST)
    public ResponseEntity<String> Delete(@RequestBody FoodUpdateJson foodUpdateJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        GetFood getFood=new GetFood();
        if (getFood.getFood(foodUpdateJson,menuJson)){
            List<FoodInfo> foods=menuJson.getMenu();
            foods.remove(getFood.getIndex());
            menuJson.setMenu(foods);
            jsonObject.put("Report","Deleted");
            return ResponseEntity.ok(jsonObject.toString());
        }
        jsonObject.put("Report","Bad Request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }

    @RequestMapping(value = "/Create",method = RequestMethod.POST)
    public ResponseEntity<String> Create(@RequestBody FoodInfo foodInfo) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        Random random=new Random();
        foodInfo.setId(random.nextInt(2000));
        List<FoodInfo> foods = menuJson.getMenu();
        foods.add(foodInfo);
        menuJson.setMenu(foods);
        jsonObject.put("Report","Created");
        return ResponseEntity.ok(jsonObject.toString());
    }

    @RequestMapping(value = "/Update",method = RequestMethod.POST)
    public ResponseEntity<String> Update(@RequestBody FoodUpdateJson foodUpdateJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        GetFood getFood=new GetFood();
        if (getFood.getFood(foodUpdateJson,menuJson)){
            List<FoodInfo> foods=menuJson.getMenu();
            FoodInfo food = foods.get(getFood.getIndex());
            food.setName(foodUpdateJson.getNewName());
            food.setPrice(foodUpdateJson.getNewPrice());
            foods.set(getFood.getIndex(),food);
            jsonObject.put("Report","Updated");
            return ResponseEntity.ok(jsonObject.toString());
        }
        jsonObject.put("Report","Bad Request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }





}
