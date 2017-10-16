package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.domain.logic.MailSender;
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
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class CheckSendCommand extends AbstractCommand {
    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomNumber = Integer.parseInt(request.getParameter("roomNum"));
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        boolean isFreeRoom = Boolean.parseBoolean(request.getParameter("isSuccess"));
        RoomsEntity roomsEntity;
        RequestEntity requestEntity;
        OrderEntity orderEntity;
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            LOG.info("Check calculation");
            CheckDao checkDao = daoFactory.getCheckDao(connection);
            RoomsDao roomsDao = daoFactory.getRoomsDao(connection);
            RequestDao requestDao = daoFactory.getRequestDao(connection);
            OrderDao orderDao = daoFactory.getOrderDao(connection);
            roomsEntity = roomsDao.getByKey(roomNumber);
            requestEntity = requestDao.getByKey(requestId);
            orderEntity = new OrderEntity(roomNumber, requestEntity);
            orderDao.insertItem(orderEntity);
            requestDao.updateItem(requestEntity);
            Date arrivingDate = requestEntity.getDateOfArriving();
            Date leavingDate = requestEntity.getDateOfLeaving();
            long difference = leavingDate.getTime() - arrivingDate.getTime();
            int daysOfStaying = (int)TimeUnit.MILLISECONDS.toDays(difference);
            int totalPrice = daysOfStaying * roomsEntity.getRoomClass().getPriceForDay();
            checkDao.insertItem(new CheckEntity(totalPrice, requestId));
            MailSender mailSender = new MailSender();
            mailSender.sendSSL(requestEntity, isFreeRoom);
        } catch (SQLException sqlE) {
            LOG.error("Something goes wrong.");
        }
        return ViewManager.CHECK_SUCCESSFULLY_SENT;
    }
}
