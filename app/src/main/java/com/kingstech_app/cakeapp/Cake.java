package com.kingstech_app.cakeapp;

public class Cake {
    String name;
    String discription;
    int cost;
    int image;
    int cakeNum;
    int cakeTransImage;

    public Cake(String name, String discription, int cost, int image, int cakeNum, int cakeTransImage) {
        this.name = name;
        this.discription = discription;
        this.cost = cost;
        this.image = image;
        this.cakeNum = cakeNum;
        this.cakeTransImage = cakeTransImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public int getCakeTransImage() {
        return cakeTransImage;
    }

    public void setCakeTransImage(int cakeTransImage) {
        this.cakeTransImage = cakeTransImage;
    }
}
