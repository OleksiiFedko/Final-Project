package com.hotel.model.entities;

import java.io.Serializable;

public class CheckEntity implements Serializable{
    private int checkId;
    private int price;
    private int requestId;

    public CheckEntity() {
    }

    public CheckEntity(int price, int requestId) {
        this.price = price;
        this.requestId = requestId;
    }

    public CheckEntity(int checkId, int price, int requestId) {
        this.checkId = checkId;
        this.price = price;
        this.requestId = requestId;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "CheckEntity: " + checkId +
                ", total price: " + price +
                ", requestId: " + requestId +
                '}';
    }
}
