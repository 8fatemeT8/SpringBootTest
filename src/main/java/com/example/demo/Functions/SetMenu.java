package com.example.demo.Functions;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.MenuJson;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

public class SetMenu {
    public static MenuJson setMenuJson(){
        Date date= new Date();
        long time = date.getTime();
        MenuJson menuJson=new MenuJson();
        List<FoodInfo> Foods=new ArrayList<>();
        FoodInfo food=new FoodInfo();
        food.setType(2);
        food.setId(7);
        food.setName("چیز برگر");
        food.setPrice("18000");
        food.setImageUrl("Images/CheeseBurgur.jpg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food);
        food=new FoodInfo();
        food.setType(3);
        food.setId(1);
        food.setName("مارگاریتا");
        food.setImageUrl("Images/Margarita.jpg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        food.setPrice("32000");
        Foods.add(food);
        food=new FoodInfo();
        food.setType(1);
        food.setId(2);
        food.setName("اسپاگتی");
        food.setPrice("16000");
        food.setImageUrl("Images/Spaghetti.jpg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food);
        food=new FoodInfo();
        food.setType(1);
        food.setId(3);
        food.setName("پیتزا پپرونی");
        food.setPrice("17000");
        food.setImageUrl("Images/Pizza.jpg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());
        Foods.add(food);

        food=new FoodInfo();
        food.setType(1);
        food.setId(4);
        food.setName("فلافل پنیری");
        food.setPrice("90000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food);
        food=new FoodInfo();
        food.setType(3);
        food.setId(9);
        food.setName("پیتزا سبزیجات");
        food.setPrice("6000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food); food=new FoodInfo();
        food.setType(3);
        food.setId(10);
        food.setName("قرمه سبزی");
        food.setPrice("12000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food); food=new FoodInfo();
        food.setType(2);
        food.setId(11);
        food.setName("قیمه سیب زمینی");
        food.setPrice("17000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food); food=new FoodInfo();
        food.setType(3);
        food.setId(12);
        food.setName("پیتزا بیکن");
        food.setPrice("23000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food); food=new FoodInfo();
        food.setType(1);
        food.setId(13);
        food.setName("پیتزا آمریکایی");
        food.setPrice("26000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food); food=new FoodInfo();
        food.setType(3);
        food.setId(14);
        food.setName("سالاد سزار");
        food.setPrice("14000");
        food.setImageUrl("Images/Sandwich.jpeg");
        time = date.getTime();
        food.setTime((new Timestamp(time)).toString());

        Foods.add(food);
        menuJson.setMenu(Foods);
        return menuJson;
    }
}
