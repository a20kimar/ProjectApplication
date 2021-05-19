package com.example.projectapplication;

public class Place {

    private String ID;
    private String name;
    private String location;
    private String category;
    private Auxdata aux;
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
    public String getText() { return aux.getText(); }
    public Auxdata getAux() { return aux; }
    public int getDrawableID() { return drawableID; }

    public Place(String n, String l, String c, int d, Auxdata a) {
        name = n;
        location = l;
        category = c;
        drawableID = d;
        aux = a;
    }
}
