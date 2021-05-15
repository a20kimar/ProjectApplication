package com.example.projectapplication;

public class Place {

    private String name;
    private String location;
    private int size;

    @Override
    public String toString() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getHeight() {
        return size;
    }
    public Place(String n, String l, int h) {
        name = n;
        location = l;
        size = h;
    }
}
