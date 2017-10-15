package com.hotel.model.entities;

import java.io.Serializable;

public class OrderEntity implements Serializable {
    private int orderId;
    private int roomNumber;
    private RequestEntity requestEntity;


    public OrderEntity() {
    }

    public OrderEntity(int roomNumber, RequestEntity requestEntity) {
        this.roomNumber = roomNumber;
        this.requestEntity = requestEntity;
    }

    public OrderEntity(int orderId, int roomNumber, RequestEntity requestEntity) {
        this.orderId = orderId;
        this.roomNumber = roomNumber;
        this.requestEntity = requestEntity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RequestEntity getRequestEntity() {
        return requestEntity;
    }

    public void setRequestEntity(RequestEntity requestEntity) {
        this.requestEntity = requestEntity;
    }

    @Override
    public String toString() {
        return "OrderEntity:  " +
                "orderId = " + orderId +
                ",   roomNumber = " + roomNumber;
    }
}
