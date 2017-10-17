package com.hotel.domain.logic;

import com.hotel.model.entities.OrderEntity;
import com.hotel.model.entities.RequestEntity;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.OrderDao;
import com.hotel.model.dao.impldao.RoomsDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomExistence {

    /**
     * Check rooms for marked request by its condition.
     * @param entity
     * @return
     */
    public static List<Integer> checkRoomExistence(RequestEntity entity) {
        List<OrderEntity> ordersList;
        List<Integer> existingRooms = new ArrayList<>();
        try (Connection connection = DBConnectionPool.getConnection()) {
            AbstractDaoFactory daoFactory = new DaoFactory();
            OrderDao orderDao = daoFactory.getOrderDao(connection);
            RoomsDao roomsDao = daoFactory.getRoomsDao(connection);
            ordersList = orderDao.getAllItems();

            List<Integer> roomsByClass = roomsDao.getRoomsByClass(entity.getRoomClass());
            List<Integer> orderRooms = orderDao.getRoomsByClass(entity.getRoomClass());
            for(int count = 0; count < orderRooms.size(); count++) {
                if(roomsByClass.contains(orderRooms.get(count))) {
                    roomsByClass.remove(orderRooms.get(count));
                }
            }
            existingRooms = roomsByClass;

            for(int count = 0; count < ordersList.size(); count++) {
                OrderEntity order = ordersList.get(count);
                Date arrivingDate = order.getRequestEntity().getDateOfArriving();
                Date leavingDate = order.getRequestEntity().getDateOfLeaving();
                if((entity.getDateOfLeaving().getTime() < arrivingDate.getTime()) ||
                        (entity.getDateOfArriving().getTime() > leavingDate.getTime())) {
                    existingRooms.add(order.getRoomNumber());
                }
            }
        } catch (SQLException sqlE) {
        }
        Collections.sort(existingRooms);
        return existingRooms;
    }
}
