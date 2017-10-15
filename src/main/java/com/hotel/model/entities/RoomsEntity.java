package com.hotel.model.entities;

import java.io.Serializable;

public class RoomsEntity implements Serializable {
    private int roomNumber;
    private RoomClassEntity roomClass;

    public RoomsEntity() {
    }

    public RoomsEntity(int roomNumber, RoomClassEntity roomClass) {
        this.roomNumber = roomNumber;
        this.roomClass = roomClass;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomClassEntity getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClassEntity roomClass) {
        this.roomClass = roomClass;
    }

    @Override
    public String toString() {
        return "RoomsEntity:" + "roomNumber - " + roomNumber +
                ", roomClass: " + roomClass;
    }
}

