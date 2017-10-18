package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.model.dao.impldao.RoomsDao;
import com.hotel.model.entities.RequestEntity;
import com.hotel.domain.logic.RoomExistence;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RequestDao;
import com.hotel.model.entities.RoomsEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomExistenceCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(RoomExistenceCommand.class);

    /**
     * Get all free rooms for current request.
     * Redirect to page with free rooms table
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        RequestEntity entity;
        List<Integer> roomsList = null;
        AbstractDaoFactory daoFactory = new DaoFactory();
        LOG.info("Checking for free rooms for current request. Request №" + requestId);
        try(Connection connection = DBConnectionPool.getConnection()) {
            RequestDao dao = daoFactory.getRequestDao(connection);
            entity = dao.getByKey(requestId);
            roomsList = RoomExistence.checkRoomExistence(entity);
        } catch (SQLException sqlE) {
        }
        if((roomsList != null) && (roomsList.size() > 0)) {
            List<RoomsEntity> freeRooms = new ArrayList<>();
            try(Connection connection = DBConnectionPool.getConnection()){
                RoomsDao roomsDao = daoFactory.getRoomsDao(connection);
                for(int number = 0; number < roomsList.size(); number++) {
                    freeRooms.add(roomsDao.getByKey(roomsList.get(number)));
                }
            } catch (SQLException sqlE) {
            }
            request.setAttribute("freeRooms", freeRooms);
            request.setAttribute("requestId", requestId);
            LOG.info("Found free rooms for request №" +requestId);
            return ViewManager.ROOM_AVAILABLE_PAGE_PASS;
        } else {
            LOG.info("No free rooms for request №" + requestId);
            return ViewManager.NO_ROOM_AVAILABLE_PAGE_PASS;
        }

    }
}
