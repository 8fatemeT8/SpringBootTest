package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodUpdateJson {
    @JsonProperty("Id")
    private int Id;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("NewPrice")
    private String NewPrice;
    @JsonProperty("NewName")
    private String NewName;
    @JsonProperty("GetBy")
    private int GetBy;

    public FoodUpdateJson() {

    }
    public FoodUpdateJson(int id, int getBy) {
        Id = id;
        GetBy = getBy;
    }

    public void setGetBy(int getBy) {
        GetBy = getBy;
    }

    public int getGetBy() {
        return GetBy;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNewPrice() {
        return NewPrice;
    }

    public void setNewPrice(String newPrice) {
        NewPrice = newPrice;
    }

    public String getNewName() {
        return NewName;
    }

    public void setNewName(String newName) {
        NewName = newName;
    }
}
