package com.example.demo.Controller;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.MenuJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("it's working");
    }

    @RequestMapping(value = "/Menu",method = RequestMethod.GET)
    public ResponseEntity<MenuJson> menu(){
        MenuJson menuJson=new MenuJson();
        List<FoodInfo> Foods=new ArrayList<FoodInfo>();
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
        return ResponseEntity.ok(menuJson);
    }

}
