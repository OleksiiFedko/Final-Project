package com.hotel.model.dao.factorydao;

import com.hotel.model.dao.impldao.*;

import java.sql.Connection;

public class DaoFactory implements AbstractDaoFactory {

    @Override
    public CheckDao getCheckDao(Connection connection) {
        return new CheckDao(connection);
    }

    @Override
    public OrderDao getOrderDao(Connection connection) {
        return new OrderDao(connection);
    }

    @Override
    public RoomClassDao getRoomClassDao(Connection connection) {
        return new RoomClassDao(connection);
    }

    @Override
    public RoomsDao getRoomsDao(Connection connection) {
        return new RoomsDao(connection);
    }

    @Override
    public RootsDao getRootsDao(Connection connection) {
        return new RootsDao(connection);
    }

    @Override
    public RequestDao getRequestDao(Connection connection) {
        return new RequestDao(connection);
    }
}
