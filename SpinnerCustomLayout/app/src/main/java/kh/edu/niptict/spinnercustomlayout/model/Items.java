package kh.edu.niptict.spinnercustomlayout.model;


/*
It is very important to create a Java class for storing
information of each item in your project.
It used for list item or store item in database.

 */
public class Items {
    private int image;
    private String name;

    public Items(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
