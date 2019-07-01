package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodDeleteJson {
    @JsonProperty("Id")
    private int Id;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("DeleteOption")
    private int DeleteOption;

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

    public int getDeleteOption() {
        return DeleteOption;
    }

    public void setDeleteOption(int deleteOption) {
        DeleteOption = deleteOption;
    }
}
