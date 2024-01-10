package com.ra.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Computer {
    private String id;
    private String type;
    private double price;
    private Date start;
    private boolean status;

    public Computer() {
    }

    public Computer(String id, String type, double price, Date start, boolean status) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.start = start;
        this.status = status;
    }

    public Computer(String id, String type, double price, boolean status) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
