package com.epamhotel.domain.entities;

import java.io.Serializable;

public class RoomClassEntity implements Serializable {
    private int idRoomClass;
    private String roomClass;
    private int priceForDay;

    public RoomClassEntity() {
    }

    public RoomClassEntity(int idRoomClass, String roomClass, int priceForDay) {
        this.idRoomClass = idRoomClass;
        this.roomClass = roomClass;
        this.priceForDay = priceForDay;
    }

    public RoomClassEntity(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public int getIdRoomClass() {
        return idRoomClass;
    }

    public void setIdRoomClass(int idRoomClass) {
        this.idRoomClass = idRoomClass;
    }

    public int getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(int priceForDay) {
        this.priceForDay = priceForDay;
    }

    @Override
    public String toString() {
        return idRoomClass + ": " + roomClass + ", cost: " + priceForDay + "$ per day";
    }
}
