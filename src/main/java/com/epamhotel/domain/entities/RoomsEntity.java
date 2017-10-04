package com.epamhotel.domain.entities;

import java.io.Serializable;

public class RoomsEntity implements Serializable {
    private int roomNumber;
    private boolean isFree;
    private RoomClassEntity roomClass;

    public RoomsEntity() {
    }

    public RoomsEntity(int roomNumber, boolean isFree, RoomClassEntity roomClass) {
        this.roomNumber = roomNumber;
        this.isFree = isFree;
        this.roomClass = roomClass;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public RoomClassEntity getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClassEntity roomClass) {
        this.roomClass = roomClass;
    }
}
//. Система Заказ гостиницы. Клиент заполняет Заявку, указывая
//        количество мест в номере, класс апартаментов и время пребывания.
//        Администратор просматривает поступившую Заявку, выделяет наиболее
//        подходящий из доступных Номеров, после чего система выставляет Счет Клиенту.
