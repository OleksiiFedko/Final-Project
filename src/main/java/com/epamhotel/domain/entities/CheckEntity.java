package com.epamhotel.domain.entities;

import java.io.Serializable;

public class CheckEntity implements Serializable{
    private int checkId;
    private int price;
    private OrderEntity requestInfo;
    private int requestInfoId ;

    public CheckEntity() {
    }

    public CheckEntity(int checkId, int price, OrderEntity requestInfo) {
        this.checkId = checkId;
        this.price = price;
        this.requestInfo = requestInfo;
    }

    public CheckEntity(int checkId, int price, int requestInfoId) {
        this.checkId = checkId;
        this.price = price;
        this.requestInfo = requestInfo;
    }

    public CheckEntity(int price, int requestInfoId) {
        this.price = price;
        this.requestInfoId = requestInfoId;
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

    public int getRequestInfoId() {
        return requestInfoId;
    }

    public void setRequestInfoId(int requestInfoId) {
        this.requestInfoId = requestInfoId;
    }

    @Override
    public String toString() {
        return "CheckEntity: " + checkId +
                ", total price: " + price +
                ", requestInfo: " + requestInfoId +
                '}';
    }
}
