package com.kingstech_app.cakeapp;

public class PopularCake {

    String name;
    int image;
    int cakeNum;

    public PopularCake(String name, int image, int cakeNum) {
        this.name = name;
        this.image = image;
        this.cakeNum = cakeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCakeNum() {
        return cakeNum;
    }

    public void setCakeNum(int cakeNum) {
        this.cakeNum = cakeNum;
    }
}
