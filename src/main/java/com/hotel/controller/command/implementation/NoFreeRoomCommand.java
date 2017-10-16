package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.domain.logic.MailSender;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RequestDao;
import com.hotel.model.entities.RequestEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class NoFreeRoomCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isFreeRoom = Boolean.parseBoolean(request.getParameter("isSuccess"));
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            RequestDao requestDao = daoFactory.getRequestDao(connection);
            RequestEntity requestEntity = requestDao.getByKey(requestId);
            MailSender mailSender = new MailSender();
            mailSender.sendSSL(requestEntity, false);
            LOG.info("Send message with negative response for client room request.");
        } catch (SQLException sqlE) {
            LOG.info("Something goes wrong during message sending.");
        }
        return ViewManager.ADMIN_MAIN_PAGE_PASS;
    }
}
