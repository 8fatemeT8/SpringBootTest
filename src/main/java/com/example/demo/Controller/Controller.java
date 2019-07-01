package com.example.demo.Controller;

import com.example.demo.Functions.SearchFoods;
import com.example.demo.Functions.SetMenu;
import com.example.demo.Utils.FoodDeleteJson;
import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.Utils.MenuJson;
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
    public ResponseEntity<MenuJson> Search(@RequestBody FoodSearchJson foodSearchJson) throws Exception{
        SearchFoods searchFoods=new SearchFoods();
        MenuJson resultJson = searchFoods.search(foodSearchJson,menuJson);
        if (resultJson!=null){
            return ResponseEntity.ok(resultJson);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @RequestMapping(value = "/Delete",method = RequestMethod.POST)
    public ResponseEntity<String> Delete(@RequestBody FoodDeleteJson foodDeleteJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        System.out.println(foodDeleteJson.getDeleteOption());
        if (foodDeleteJson.getDeleteOption()==0){
            List<FoodInfo> foods = menuJson.getMenu();
            for (int i=0;i<foods.size();i++){
                if(foodDeleteJson.getName().equals(foods.get(i).getName())){
                    foods.remove(i);
                    menuJson.setMenu(foods);
                    jsonObject.put("Report","Deleted");
                    return ResponseEntity.ok(jsonObject.toString());
                }
            }
        }
        else if (foodDeleteJson.getDeleteOption()==1){
                List<FoodInfo> foods = menuJson.getMenu();
                for (int i=0;i<foods.size();i++){
                    if(foodDeleteJson.getId()==foods.get(i).getId()){
                        foods.remove(i);
                        menuJson.setMenu(foods);
                        jsonObject.put("Report","Deleted");
                        return ResponseEntity.ok(jsonObject.toString());
                    }
                    if(i==foods.size()-1){
                        jsonObject.put("Report","Not Exist");
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
                    }
                }
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




}
