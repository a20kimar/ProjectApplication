package com.example.projectapplication;

public class Place {

    private String ID;
    private String name;
    private String location;
    private String category;
    private Auxdata auxdata;
    private int drawableID;

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
    public String getName() { return name; }
    public String getText() { return auxdata.getText(); }
    public Auxdata getAux() { return auxdata; }
    public int getDrawableID() { return drawableID; }

    public Place(String n, String l, String c, int d, Auxdata a) {
        name = n;
        location = l;
        category = c;
        drawableID = d;
        auxdata = a;
    }
}
