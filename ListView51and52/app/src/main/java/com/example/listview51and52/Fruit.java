package com.example.listview51and52;

public class Fruit {
    private String name;
    private int calories;
    private int imageResId;

    public Fruit(String name, int calories, int imageResId) {
        this.name = name;
        this.calories = calories;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getImageResId() {
        return imageResId;
    }
}