package com.sict.maianhkiet.dng2.Model;

public class Feature {
    private String key;
    public String imagef;
    public String titlef;
    public float ratef;
    public String descriptionf;

    public Feature(){
    }

    public Feature(String key, String imagef, String titlef, float ratef, String descriptionf) {
        this.key = key;
        this.imagef = imagef;
        this.titlef = titlef;
        this.ratef = ratef;
        this.descriptionf = descriptionf;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImagef() {
        return imagef;
    }

    public void setImagef(String imagef) {
        this.imagef = imagef;
    }

    public String getTitlef() {
        return titlef;
    }

    public void setTitlef(String titlef) {
        this.titlef = titlef;
    }

    public float getRatef() {
        return ratef;
    }

    public void setRatef(float ratef) {
        this.ratef = ratef;
    }

    public String getDescriptionf() {
        return descriptionf;
    }

    public void setDescriptionf(String descriptionf) {
        this.descriptionf = descriptionf;
    }

}
