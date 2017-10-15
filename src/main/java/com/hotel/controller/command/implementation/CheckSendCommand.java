package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.CheckDao;
import com.hotel.model.dao.impldao.OrderDao;
import com.hotel.model.dao.impldao.RequestDao;
import com.hotel.model.dao.impldao.RoomsDao;
import com.hotel.model.entities.CheckEntity;
import com.hotel.model.entities.OrderEntity;
import com.hotel.model.entities.RequestEntity;
import com.hotel.model.entities.RoomsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CheckSendCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomNumber = Integer.parseInt(request.getParameter("roomNum"));
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        CheckEntity checkEntity;
        RoomsEntity roomsEntity;
        RequestEntity requestEntity;
        OrderEntity orderEntity;
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            CheckDao checkDao = daoFactory.getCheckDao(connection);
            RoomsDao roomsDao = daoFactory.getRoomsDao(connection);
            RequestDao requestDao = daoFactory.getRequestDao(connection);
            OrderDao orderDao = daoFactory.getOrderDao(connection);
            roomsEntity = roomsDao.getByKey(roomNumber);
            requestEntity = requestDao.getByKey(requestId);
            orderEntity = new OrderEntity(roomNumber, requestEntity);
            orderDao.insertItem(orderEntity);
            requestDao.updateItem(requestEntity);
        } catch (SQLException sqlE) {
        }
        return ViewManager.CHECK_SUCCESSFULLY_SENT;
    }
}
