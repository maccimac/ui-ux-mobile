package com.example.ux_mids_grocery_groovy.model;

public class GroceryItem {
    public String name;
    public String note;
    public Boolean bought=false;
    public int imageId;
    public int itemImageId;
    public int groceryImageId;

    public GroceryItem(){

    }

    public GroceryItem(String name, int imageId, int groceryImgId) {
        this.name = name;
        this.imageId = imageId;
        this.itemImageId = imageId;
        this.groceryImageId=groceryImgId;

    }


}
