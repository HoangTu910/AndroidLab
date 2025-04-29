package com.example.listview51and52;

public class AndroidVersion {
    private String name;
    private String number;
    private int imageResId;

    public AndroidVersion(String name, String number, int imageResId) {
        this.name = name;
        this.number = number;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImageResId() {
        return imageResId;
    }
}