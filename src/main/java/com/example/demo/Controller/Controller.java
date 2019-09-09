package com.example.demo.Controller;
import com.example.demo.Functions.GetFood;
import com.example.demo.Functions.SearchFoods;
import com.example.demo.Functions.SetMenu;
import com.example.demo.Utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller {

    MenuJson menuJson = SetMenu.setMenuJson();
    List<OrderJson> submitOrders=new ArrayList<>();
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("it's working");
    }
    @RequestMapping(value = "/Menu",method = RequestMethod.GET)
    public ResponseEntity<String> Menu() throws JsonProcessingException {
      ObjectMapper objectMapper=new ObjectMapper();
      String json = objectMapper.writeValueAsString(menuJson);
        return ResponseEntity.ok(json);
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
    @RequestMapping(value = "/Delete",method = RequestMethod.GET)
    public ResponseEntity<String> Delete(@RequestParam int id) throws JSONException {
        System.out.println(id+"  hello bebe");
        JSONObject jsonObject = new JSONObject();
        GetFood getFood=new GetFood();
        if (getFood.getFood(id,menuJson)){
            List<FoodInfo> foods=menuJson.getMenu();
            foods.remove(getFood.getIndex());
            menuJson = new MenuJson(foods);
            menuJson.setCount(menuJson.getCount()-1);
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
        foodInfo.setId(random.nextInt(99));
        List<FoodInfo> foods = menuJson.getMenu();
        foods.add(foodInfo);
        menuJson = new MenuJson(foods);
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
            food.setName(foodUpdateJson.getName());
            food.setPrice(foodUpdateJson.getPrice());
            food.setType(foodUpdateJson.getType());
            foods.set(getFood.getIndex(),food);
            menuJson = new MenuJson(foods);
            jsonObject.put("Report","Updated");
            return ResponseEntity.ok(jsonObject.toString());
        }
        jsonObject.put("Report","Bad Request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }
    @RequestMapping(value = "/Order",method = RequestMethod.POST)
    public ResponseEntity<String> Order(@RequestBody FoodOrderJson foodOrderJson) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        List<OrderJson> orders = foodOrderJson.getOrders();
        GetFood getFood=new GetFood();
        for (OrderJson order : orders) {
            FoodUpdateJson foodUpdateJson = new FoodUpdateJson(order.getFood().getId(), 1);
            if (getFood.getFood(foodUpdateJson, menuJson)) {
                submitOrders.add(order);
                jsonObject.put(getFood.getFoodInfo().getName(), "Ordered");
            } else {
                jsonObject.put("Not Exist", "Not Ordered");
            }
        }
        return ResponseEntity.ok(jsonObject.toString());
    }
    @RequestMapping(value = "/GetDetail",method = RequestMethod.GET)
    public ResponseEntity<String> GetDetail(@RequestParam int Id) throws  JSONException{
        FoodUpdateJson foodUpdateJson=new FoodUpdateJson();
        foodUpdateJson.setId(Id);
        if (foodUpdateJson!=null){
            GetFood getFood=new GetFood();
            getFood.getFood(foodUpdateJson,menuJson);
            FoodInfo foodInfo = getFood.getFoodInfo();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name",foodInfo.getName());
            jsonObject.put("price",foodInfo.getPrice());
            jsonObject.put("type",foodInfo.getType());
            jsonObject.put("id",foodInfo.getId());
            jsonObject.put("dateObject",foodInfo.getTime());
            return ResponseEntity.ok(jsonObject.toString());
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Report","Not Found");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }
    @RequestMapping(value = "/GetImage",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> GetImage(@RequestParam int Id) throws IOException {

            if(Id!=333)
            {
                FoodUpdateJson foodUpdateJson=new FoodUpdateJson();
                foodUpdateJson.setId(Id);
                GetFood getFood=new GetFood();
                getFood.getFood(foodUpdateJson,menuJson);
                FoodInfo foodInfo = getFood.getFoodInfo();
                var imgFile = new ClassPathResource(foodInfo.getImageUrl());
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(new InputStreamResource(imgFile.getInputStream()));
            }
            else{
                var imgFile = new ClassPathResource("22.jpg");
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(new InputStreamResource(imgFile.getInputStream()));
            }

    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseEntity<String> Upload(@RequestParam("image") MultipartFile file,@RequestParam("name") String name,@RequestParam("dataObject") String time,@RequestParam("price") String price,@RequestParam("type") String type) throws IOException, JSONException {
        InputStream image = file.getInputStream();
        byte[] buffer = new byte[image.available()];
        image.read(buffer);
        System.out.println(file.getOriginalFilename());
        File targetFile = new File(file.getOriginalFilename());
        targetFile.createNewFile();
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);

        JSONObject jsonObject=new JSONObject();
        Random random=new Random();
        FoodInfo foodInfo=new FoodInfo();
        foodInfo.setName(name);
        foodInfo.setPrice(price);
        foodInfo.setType(Integer.parseInt(type.substring(0,1)));
        foodInfo.setId(random.nextInt(99));
        foodInfo.setImageUrl("Images/"+file.getOriginalFilename());
        foodInfo.setTime(time);
        List<FoodInfo> foods = menuJson.getMenu();
        foods.add(foodInfo);
        menuJson = new MenuJson(foods);
        jsonObject.put("Report","Created");

        System.out.println(foodInfo.getName()+foodInfo.getTime()+"  "+foodInfo.getType());
        return ResponseEntity.ok("Ok");
    }

    @RequestMapping(value = "/foods",method = RequestMethod.GET)
    public ResponseEntity<String> foods(FoodSearchJson food) throws JsonProcessingException, JSONException {
        int end;
        MenuJson menuJson1 = new MenuJson();
        if(food.getName()==null&&food.getPrice()==null){


            if(food.getPage()!=null){
                end =Integer.parseInt(food.getPage())*3+3;
                if (Integer.parseInt(food.getPage())*3+3>menuJson.getCount()){
                    end =menuJson.getCount();
                }
                menuJson1.setMenu(menuJson.getMenu().subList(Integer.parseInt(food.getPage())*3,end));
            }
            else menuJson1=menuJson;
            menuJson1.setCount(menuJson.getCount());
            ObjectMapper objectMapper=new ObjectMapper();
            String json = objectMapper.writeValueAsString(menuJson1);
            return ResponseEntity.ok(json);
        }
        else {
            food.setName(food.getName() != null ? food.getName() : "");
            food.setPrice(food.getPrice() != null ? food.getPrice() : "0");
            SearchFoods searchFoods=new SearchFoods();
            MenuJson resultJson = searchFoods.search(food,menuJson);
            if (resultJson!=null){
                end =Integer.parseInt(food.getPage())*3+3;
                if (Integer.parseInt(food.getPage())*3+3>resultJson.getCount()){
                    end =resultJson.getCount();
                }
                menuJson1.setMenu(resultJson.getMenu().subList(Integer.parseInt(food.getPage())*3,end));
                menuJson1.setCount(resultJson.getCount());
                ObjectMapper objectMapper=new ObjectMapper();
                String json = objectMapper.writeValueAsString(menuJson1);
                return ResponseEntity.ok(json);
            }
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("err","Not Found");
            return ResponseEntity.ok(jsonObject.toString());
        }
    }


}
