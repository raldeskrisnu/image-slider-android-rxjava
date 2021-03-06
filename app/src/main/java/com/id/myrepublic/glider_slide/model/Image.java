package com.id.myrepublic.glider_slide.model;

import java.io.Serializable;
import java.util.List;

public class Image {

    private String name;
    private String small, medium, large;
    private String timestamp;
    private ImageResult url;

    public Image() {
    }

    public Image(String name, String small, String medium, String large, String timestamp,ImageResult url) {
        this.name = name;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.timestamp = timestamp;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setUrl(ImageResult url){
        this.url = url;
    }

    public ImageResult getUrl() {
        return url;
    }
}
