package com.epamhotel.domain.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderEntity implements Serializable {
    private int requestInfoId;
    private RoomsEntity roomsEntity;
    private RequestEntity requestEntity;


    public OrderEntity() {
    }

    public int getRequestInfoId() {
        return requestInfoId;
    }

    public void setRequestInfoId(int requestInfoId) {
        this.requestInfoId = requestInfoId;
    }

    public RoomsEntity getRoomsEntity() {
        return roomsEntity;
    }

    public void setRoomsEntity(RoomsEntity roomsEntity) {
        this.roomsEntity = roomsEntity;
    }

    public RequestEntity getRequestEntity() {
        return requestEntity;
    }

    public void setRequestEntity(RequestEntity requestEntity) {
        this.requestEntity = requestEntity;
    }
}
