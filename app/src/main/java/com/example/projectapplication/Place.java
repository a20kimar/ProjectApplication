package com.example.projectapplication;

public class Place {

    private String ID;
    private String name;
    private String location;
    private String category;
    private String link;
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
    public String getLink() { return link; }
    public String getName() { return name; }
    public String getText() { return auxdata.getText(); }
    public Auxdata getAux() { return auxdata; }
    public int getDrawableID() { return drawableID; }

    public Place(String n, String l, String c, int d, Auxdata a, String li) {
        name = n;
        location = l;
        category = c;
        drawableID = d;
        auxdata = a;
        link = li;
    }

    public void setDrawableID(int id) {
        drawableID = id;
    }
}
