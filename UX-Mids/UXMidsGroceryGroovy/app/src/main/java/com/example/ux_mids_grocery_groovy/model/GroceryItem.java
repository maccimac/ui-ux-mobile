package com.example.ux_mids_grocery_groovy.model;

public class GroceryItem {
    public String name;
    public Boolean bought=false;
    public int imageId;

    public GroceryItem(){

    }

    public GroceryItem(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }


}
