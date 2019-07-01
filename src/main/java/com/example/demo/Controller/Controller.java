package com.example.demo.Controller;

import com.example.demo.Functions.SearchFoods;
import com.example.demo.Functions.SetMenu;
import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.Utils.MenuJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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




}
