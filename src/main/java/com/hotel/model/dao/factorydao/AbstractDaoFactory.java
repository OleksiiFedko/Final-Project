package com.hotel.model.dao.factorydao;

import com.hotel.model.dao.impldao.*;

import java.sql.Connection;

public interface AbstractDaoFactory {

    CheckDao getCheckDao(Connection con);

    OrderDao getOrderDao(Connection con);

    RoomClassDao getRoomClassDao(Connection con);

    RoomsDao getRoomsDao(Connection con);

    RootsDao getRootsDao(Connection con);

    RequestDao getRequestDao(Connection con);


}
