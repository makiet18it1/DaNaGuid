package com.sict.maianhkiet.dng2.Model;

public class AllviewM {
    public String imagev;
    public String titlev;
    public float ratev;
    public String descriptionv;
    private String keyv;

    public AllviewM(){
    }

    public AllviewM(String keyv,String imagev, String titlev, float ratev, String descriptionv) {
        this.keyv = keyv;
        this.imagev = imagev;
        this.titlev = titlev;
        this.ratev = ratev;
        this.descriptionv = descriptionv;
    }

    public String getKeyv() {
        return keyv;
    }

    public void setKeyv(String keyv) {
        this.keyv = keyv;
    }

    public String getImagev() {
        return imagev;
    }

    public void setImagev(String imagev) {
        this.imagev = imagev;
    }

    public String getTitlev() {
        return titlev;
    }

    public void setTitlev(String titlev) {
        this.titlev = titlev;
    }

    public Float getRatev() {
        return ratev;
    }

    public void setRatev(Float ratev) {
        this.ratev = ratev;
    }

    public String getDescriptionv() {
        return descriptionv;
    }

    public void setDescriptionv(String descriptionv) {
        this.descriptionv = descriptionv;
    }


}
