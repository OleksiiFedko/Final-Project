package com.epamhotel.domain.entities;

import java.io.Serializable;
import java.sql.Date;

public class RequestEntity implements Serializable {
    private int requestId;
    private Date dateOfArriving;
    private Date dateOfLeaving;
    private String firstName;
    private String secondName;
    private String roomClass;
    private String passport;
    private String email;
    private boolean isOpen = true;

    public RequestEntity() {
    }

    public RequestEntity(int requestId, Date dateOfArriving, Date dateOfLeaving, String firstName,
                         String secondName, String roomClass, String passport, String email, boolean isOpen) {
        this.requestId = requestId;
        this.dateOfArriving = dateOfArriving;
        this.dateOfLeaving = dateOfLeaving;
        this.firstName = firstName;
        this.secondName = secondName;
        this.roomClass = roomClass;
        this.passport = passport;
        this.email = email;
        this.isOpen = isOpen;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Date getDateOfArriving() {
        return dateOfArriving;
    }

    public void setDateOfArriving(Date dateOfArriving) {
        this.dateOfArriving = dateOfArriving;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public Date getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(Date dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "requestId=" + requestId +
                ", dateOfArriving=" + dateOfArriving +
                ", dateOfLeaving=" + dateOfLeaving +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", roomClass='" + roomClass + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }
}
