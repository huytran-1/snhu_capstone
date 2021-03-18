package com.app.myfirebaseapplication;

public class ItemModel {
    private String ID;
    private int image;
    private String name;
    private int stock;

    public ItemModel(){}

    public void setID(String ID){
        this.ID = ID;
    }

    public String getID(){
        return this.ID;
    }

    public void setImage(int image){
        this.image = image;
    }

    public int getImage(){
        return this.image;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }
}
