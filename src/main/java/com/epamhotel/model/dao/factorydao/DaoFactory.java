package com.epamhotel.model.dao.factorydao;

import com.epamhotel.model.dao.impldao.*;

import java.sql.Connection;

public class DaoFactory implements AbstractDaoFactory {

    @Override
    public CheckDao getCheckDao(Connection connection) {
        return new CheckDao(connection);
    }

    @Override
    public RequestInfoDao getRequestInfoDao(Connection connection) {
        return new RequestInfoDao(connection);
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
