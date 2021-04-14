package com.sict.maianhkiet.dng2.Model;

public class Category {
    public String title;
    public String image;
    public Category() {
    }
    public Category(String title, String image) {
        this.title = title;
        this.image = image;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
