package com.example.bookingmedicalexaminatation.model;

import java.io.Serializable;

public class WorkSchedule implements Serializable {
    private String id;
    private String userName;
    private String date;
    private String place;
    private String from;
    private String to;
    private String price;

    public WorkSchedule() {
    }

    public WorkSchedule(String id, String userName, String date, String place, String from, String to, String price) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.place = place;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
