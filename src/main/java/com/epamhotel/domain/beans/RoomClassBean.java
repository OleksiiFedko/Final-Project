package com.epamhotel.domain.beans;

import com.epamhotel.model.dao.connection.DBConnectionPool;
import com.epamhotel.model.dao.factorydao.AbstractDaoFactory;
import com.epamhotel.model.dao.factorydao.DaoFactory;
import com.epamhotel.model.dao.impldao.RoomClassDao;
import com.epamhotel.domain.entities.RoomClassEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomClassBean implements Serializable {
    public List<RoomClassEntity> roomClassList = new ArrayList<>();

    public List<RoomClassEntity> getRoomClassList() {
        return roomClassList;
    }

    public void setRoomClassList(List<RoomClassEntity> roomClassList) {
        this.roomClassList = roomClassList;
    }

    public RoomClassBean() {
        fillRoomClassList();
    }

    public void fillRoomClassList() {
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            RoomClassDao dao = daoFactory.getRoomClassDao(connection);
            roomClassList = dao.getAllItems();
        } catch (SQLException sqlE) {
        }
    }
}
