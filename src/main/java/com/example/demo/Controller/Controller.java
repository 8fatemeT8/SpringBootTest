package com.example.demo.Controller;

//import com.example.demo.Functions.SearchFoods;
import com.example.demo.Functions.BaseSource;
import com.example.demo.Model.MenufoodModel;
import com.example.demo.Model.OrderfoodModel;
import com.example.demo.Repository.MenufoodModelRepository;
import com.example.demo.Repository.OrderfoodModelRepository;
import com.example.demo.Utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

        import java.io.*;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller extends BaseSource {

    @Autowired
    MenufoodModelRepository menufoodModelRepository;
    @Autowired
    OrderfoodModelRepository orderfoodModelRepository;

    /* food menu */
    MenuJson menuJson;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("it's working");
    }


    /**
     * ok
     */
    /*@RequestMapping(value = "/Menu", method = RequestMethod.GET)
    public ResponseEntity<String> Menu() throws JsonProcessingException {
        List<FoodInfo> foodInfoList = getFood(menufoodModelRepository.findAllFood());
        menuJson = new MenuJson(foodInfoList);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(menuJson);
        return ResponseEntity.ok(json);
    }

*/
    /**
     * ok
     */
  /*  @RequestMapping(value = "/Search", method = RequestMethod.POST)
   /* public ResponseEntity<MenuJson> Search(@RequestBody FoodSearchJson foodSearchJson) {
        List<FoodInfo> foodInfoList = getFood(menufoodModelRepository.searchFood(foodSearchJson.getPrice(), foodSearchJson.getName()));
        if (foodInfoList.size() != 0) {
            return ResponseEntity.ok(new MenuJson(foodInfoList));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
*/

    /**
     * ok
     */
  /*  @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public ResponseEntity<String> Delete(@RequestParam("id") int id) throws JSONException {
        OrderfoodModel ofm = orderfoodModelRepository.findById(id);
        JSONObject jsonObject = new JSONObject();
        if (ofm == null) {
            List<MenufoodModel> menufoodModelList = new ArrayList<>();
            menufoodModelList.add(menufoodModelRepository.findById(id));
            MenuJson mj = new MenuJson(getFood(menufoodModelList));
            if (mj.getMenu().size() == 1) {
                menufoodModelRepository.deleteById(id);
                List<FoodInfo> foodInfoList = getFood(menufoodModelRepository.findAllFood());
                menuJson = new MenuJson(foodInfoList);
                jsonObject.put("Report", "Deleted");
                return ResponseEntity.ok(jsonObject.toString());
            }
            jsonObject.put("Report", "There is no food to delete");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
        }else {
            jsonObject.put("Report", "cant delete this food because order this food");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
        }
    }
*/
    /**
     * ok
     */
  /*  @RequestMapping(value = "/Create", method = RequestMethod.POST)
  /*  public ResponseEntity<String> Create(@RequestBody FoodInfo foodInfo) throws JSONException {
        MenuJson menuJson2 = new MenuJson(getFood(menufoodModelRepository.searchFoodByName(foodInfo.getName())));
        if (menuJson2.getMenu().size() == 0) {
            if (!foodInfo.getTime().equals(""))
                menuJson = addFood(foodInfo);
            else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Report", "time not to be null");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Report", "Created");
            return ResponseEntity.ok(jsonObject.toString());
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Report", "this food exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
        }
    }
*/

    /**
     * ok
     */
  /*  @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public ResponseEntity<String> Update(@RequestBody FoodUpdateJson foodUpdateJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        MenufoodModel menufoodModel = menufoodModelRepository.findById(foodUpdateJson.getId());
        if (menufoodModel != null) {
            menufoodModel.setName(foodUpdateJson.getName());
            menufoodModel.setPrice(foodUpdateJson.getPrice());
            menufoodModel.setType(String.valueOf(foodUpdateJson.getType()));
            menufoodModelRepository.save(menufoodModel);
            jsonObject.put("Report", "Updated");
            return ResponseEntity.ok(jsonObject.toString());
        }
        jsonObject.put("Report", "Bad Request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }
*/
/*
    @RequestMapping(value = "/Order", method = RequestMethod.POST)
    public ResponseEntity<String> Order(@RequestBody FoodOrderJson foodOrderJson) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        List<OrderJson> orders = foodOrderJson.getOrders();
        OrderfoodModel ofm=null;
        for (OrderJson order : orders) {
            MenufoodModel menufoodModel = menufoodModelRepository.findById(order.getFood().getId());
            if (menufoodModel != null) {
               ofm= orderfoodModelRepository.findById(menufoodModel.getId());
                if (ofm == null) {
                    OrderfoodModel orderfoodModel = new OrderfoodModel();
                    orderfoodModel.setNumber(order.getNumber());
                    orderfoodModel.setMenufoodModel(menufoodModel);
                    orderfoodModelRepository.save(orderfoodModel);
                    jsonObject.put(menufoodModel.getName(), "Ordered");
                }else {
                    ofm.setNumber(ofm.getNumber()+order.getNumber());
                    orderfoodModelRepository.save(ofm);
                    jsonObject.put(menufoodModel.getName(), "Ordered");
                }
            } else {
                jsonObject.put("Not Exist", "Not Ordered");
            }
        }
        return ResponseEntity.ok(jsonObject.toString());
    }

*/
    /**
     * ok
     */
  /*  @RequestMapping(value = "/GetDetail", method = RequestMethod.GET)
    public ResponseEntity<String> GetDetail(@RequestParam("id") int Id) throws JSONException {
        if (String.valueOf(Id).matches("^[0-9][0-9 -]*$")) {
            MenufoodModel menufoodModel = menufoodModelRepository.findById(Id);
            if (menufoodModel != null) {
                FoodInfo foodInfo = new FoodInfo();
                foodInfo.setName(menufoodModel.getName());
                foodInfo.setPrice(menufoodModel.getPrice());
                foodInfo.setType(Integer.valueOf(menufoodModel.getType()));
                foodInfo.setTime(String.valueOf(menufoodModel.getTimeSet()));
                foodInfo.setId(menufoodModel.getId());

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", foodInfo.getName());
                jsonObject.put("price", foodInfo.getPrice());
                jsonObject.put("type", foodInfo.getType());
                jsonObject.put("id", foodInfo.getId());
                jsonObject.put("dateObject", foodInfo.getTime());
                return ResponseEntity.ok(jsonObject.toString());
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Report", "Not Found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Report", "Id must be number");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }
*/


    /**
     * ok
     */
    /*
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> Upload( @RequestParam("name") String name, @RequestParam("dataObject") String time,
                                                                                        @RequestParam("price") String price, @RequestParam("type") String type) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject();
        if (type.matches("^[0-9][0-9 -]*$")) {
            menuJson = addFood(name, price, time, Integer.valueOf(type));
            jsonObject.put("Report", "Created");
            return ResponseEntity.ok("Ok");
        }
        jsonObject.put("Report", "type must be number");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
    }
*/

  /*  @GetMapping("/foods")
    public ResponseEntity<String> foods(@RequestBody FoodSearchJson food) throws JsonProcessingException, JSONException {
        int end;
        MenuJson menuJson1 = null;
        MenuJson resultMenu = null;
        if (food.getName().equals("") && food.getPrice().equals("")) {
            if (!food.getPage().equals("")) {
                menuJson1 = new MenuJson(getFood(menufoodModelRepository.findTopByOrderByIdDesc(Integer.valueOf(food.getPage())*3+3)));
            } else {
                menuJson1 = new MenuJson(getFood(menufoodModelRepository.findAllFood()));
            }
            menuJson1.setCount(menuJson1.getMenu().size());
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(menuJson1);
            return ResponseEntity.ok(json);
        } else if (!food.getName().equals("") && !food.getPrice().equals("")) {
            resultMenu = new MenuJson(getFood(menufoodModelRepository.searchFood(food.getPrice(), food.getName())));
            resultMenu.setCount(resultMenu.getMenu().size());
        } else if (!food.getName().equals("") && food.getPrice().equals("")) {
            resultMenu = new MenuJson(getFood(menufoodModelRepository.searchFoodByName(food.getName())));
            resultMenu.setCount(resultMenu.getMenu().size());
        } else {
            resultMenu = new MenuJson(getFood(menufoodModelRepository.searchFoodByPrice(food.getPrice())));
            resultMenu.setCount(resultMenu.getMenu().size());
        }
        if (resultMenu.getMenu().size() != 0) {
            if (!food.getPage().equals("")) {
                end = Integer.parseInt(food.getPage()) * 3 + 3;
                if (Integer.parseInt(food.getPage()) * 3 + 3 > resultMenu.getCount()) {
                    end = resultMenu.getCount();
                }
            } else {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(resultMenu);
                return ResponseEntity.ok(json);
            }
            if (resultMenu.getMenu().size() != 0) {
                menuJson1.setMenu(resultMenu.getMenu().subList(Integer.parseInt(food.getPage()), end));
                menuJson1.setCount(resultMenu.getCount());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(menuJson1);
            return ResponseEntity.ok(json);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("err", "Not Found");
        return ResponseEntity.ok(jsonObject.toString());
    }*/
}