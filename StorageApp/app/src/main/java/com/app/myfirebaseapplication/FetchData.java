package com.app.myfirebaseapplication;

public class FetchData {

    String ID;
    long image;
    String name;
    long stock;

    public FetchData(String ID, String name, long image, long stock){
        this.ID = ID;
        this.name = name;
        this.image = image;
        this.stock = stock;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public long getImage() {
        return image;
    }

    public void setImage(long image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
