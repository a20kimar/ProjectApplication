package com.example.projectapplication;

public class Place {

    private String ID;
    private String name;
    private String location;
    private String category;

    @Override
    public String toString() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getCategory() {
        return category;
    }
    public Place(String n, String l, String c) {
        name = n;
        location = l;
        category = c;
    }
}
