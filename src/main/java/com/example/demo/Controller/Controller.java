package com.example.demo.Controller;

import com.example.demo.Functions.SetMenu;
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
    public ResponseEntity<MenuJson> Menu(){
        MenuJson menuJson = SetMenu.setMenuJson();
        return ResponseEntity.ok(menuJson);
    }

}
