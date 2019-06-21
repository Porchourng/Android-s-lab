package com.example.recyclerview.model;

public class Movie {
    private int img;
    private String title, des, date;
    private double rating;
    private int id;

    public Movie(int img, String title, String des) {
        this.img = img;
        this.title = title;
        this.des = des;

    }

    public int getImg() {
        return img;
    }
    public String getTitle() {
        return title;
    }
    public String getDes() {
        return des;
    }

}
