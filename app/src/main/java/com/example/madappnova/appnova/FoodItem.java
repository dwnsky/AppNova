package com.example.appnova;

public class FoodItem {
    private final int imageResId;
    private final String name;
    private final String price;

    public FoodItem(int imageResId, String name, String price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() { return imageResId; }
    public String getName() { return name; }
    public String getPrice() { return price; }
}

