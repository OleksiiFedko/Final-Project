package com.hotel.domain.logic;

import com.hotel.model.entities.RequestEntity;

import java.sql.Date;

public class RequestValidation {
    /**
     * Check input date. Compare with current date.
     * @param arrivingDate
     * @return
     */
    public static boolean checkArrivingDate (Date arrivingDate) {
        Date todayDate = new Date(new java.util.Date().getTime());
        if(arrivingDate.getTime() < todayDate.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * Compare arriving date with leaving date.
     * @param arrivingDate
     * @param leavingDate
     * @return
     */
    public static boolean arrivingDateVsLeavingDate(Date arrivingDate, Date leavingDate) {
        if(arrivingDate.getTime() > leavingDate.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * Check if there are empty fields in request
     * @param entity
     * @return
     */
    public static boolean isEmptyField (RequestEntity entity) {
        if(entity.getFirstName().length() > 0) {
            return false;
        }if(entity.getSecondName().length() > 0) {
            return false;
        }if(entity.getPassport().length() > 0) {
            return false;
        }if(entity.getEmail().length() > 0) {
            return false;
        }
        return true;
    }

}
