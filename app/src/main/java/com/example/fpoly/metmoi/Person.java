package com.example.fpoly.metmoi;

public class Person {
    private String name;
    private int imageRes;

    public Person(String name, int imageRes) {
        this.name = name;
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public int getImageRes() {
        return imageRes;
    }
}
