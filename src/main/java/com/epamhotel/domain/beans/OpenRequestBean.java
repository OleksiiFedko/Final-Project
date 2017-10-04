package com.epamhotel.domain.beans;

import com.epamhotel.domain.entities.RequestEntity;
import com.epamhotel.model.dao.connection.DBConnectionPool;
import com.epamhotel.model.dao.factorydao.AbstractDaoFactory;
import com.epamhotel.model.dao.factorydao.DaoFactory;
import com.epamhotel.model.dao.impldao.RequestDao;
import com.epamhotel.model.dao.impldao.RoomClassDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenRequestBean {
    public List<RequestEntity> openedRequests = new ArrayList<>();

    public List<RequestEntity> getOpenedRequests() {
        return openedRequests;
    }

    public void setOpenedRequests(List<RequestEntity> openedRequests) {
        this.openedRequests = openedRequests;
    }

    public OpenRequestBean() {
        fillRoomClassList();
    }

    public void fillRoomClassList() {
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            RequestDao dao = daoFactory.getRequestDao(connection);
            openedRequests = dao.getOpenedRequests();
        } catch (SQLException sqlE) {
        }
    }
}
