package com.kingstech_app.cakeapp;

public class Cake {
    String name;
    String discription;
    double cost;
    int image;

    public Cake(String name, String discription, double cost, int image) {
        this.name = name;
        this.discription = discription;
        this.cost = cost;
        this.image = image;
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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
