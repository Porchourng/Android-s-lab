package kh.edu.niptict.recyclerview.model;

public class Movie {
    private String title;
    private String des;
    private int year;

    public Movie(String title, String des, int year) {
        this.title = title;
        this.des = des;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
