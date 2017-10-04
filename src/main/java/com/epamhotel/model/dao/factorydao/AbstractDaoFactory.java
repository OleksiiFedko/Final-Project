package com.epamhotel.model.dao.factorydao;

import com.epamhotel.model.dao.impldao.*;

import java.sql.Connection;

public interface AbstractDaoFactory {
//    Connection getConnection() throws SQLException;

    CheckDao getCheckDao(Connection con);

    RequestInfoDao getRequestInfoDao(Connection con);

    RoomClassDao getRoomClassDao(Connection con);

    RoomsDao getRoomsDao(Connection con);

    RootsDao getRootsDao(Connection con);

    RequestDao getRequestDao(Connection con);
}
