package com.example.projectapplication;

public class Auxdata {
    private String text;
    private String citation;
    private String link;


    public String getText() {
        return text;
    }

    public String getCitation() {
        return citation;
    }

    public String getLink() {
        return link;
    }

    public Auxdata(String t) {
        text = t;
    }
}
