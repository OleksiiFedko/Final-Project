package com.hotel.domain.beans;

import com.hotel.model.entities.RequestEntity;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RequestDao;

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
