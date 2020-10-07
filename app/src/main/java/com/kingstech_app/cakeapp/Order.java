package com.kingstech_app.cakeapp;

import java.sql.Time;

public class Order{
    String name;
    String phone;
    String email;
    String address;
    String cakeName;
    String cakeCost;
    String note;
    int image;
    String currentTime;
    int qty;

    public Order(String name, String phone, String email, String address, String cakeName, String cakeCost, String note, int image, String currentTime, int qty) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cakeName = cakeName;
        this.cakeCost = cakeCost;
        this.note = note;
        this.image = image;
        this.currentTime = currentTime;
        this.qty = qty;
    }

    public Order()
    {
        this.name = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.cakeName = "";
        this.cakeCost = "";
        this.note = "";
        this.image = 0;
        this.currentTime = "";
        this.qty = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeCost() {
        return cakeCost;
    }

    public void setCakeCost(String cakeCost) {
        this.cakeCost = cakeCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", cakeName='" + cakeName + '\'' +
                ", cakeCost='" + cakeCost + '\'' +
                ", note='" + note + '\'' +
                ", image=" + image +
                ", currentTime='" + currentTime + '\'' +
                '}';
    }
}
