package com.id.myrepublic.glider_slide.model;

import java.io.Serializable;

public class ImageResult implements Serializable {

    private String small,medium,large;

    public ImageResult(){

    }

    public ImageResult(String small, String medium, String large){

        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getSmall(){
        return small;
    }

    public void setSmall(String small){
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium){
        this.medium = medium;
    }

    public String getLarge(){
        return large;
    }

    public void setLarge(String large){
        this.large = large;
    }
}
