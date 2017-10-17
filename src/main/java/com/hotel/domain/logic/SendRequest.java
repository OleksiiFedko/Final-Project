package com.hotel.domain.logic;

import com.hotel.model.entities.RequestEntity;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RequestDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class SendRequest {

    /**
     * Add client request to DB
     * @param requestEntity
     * @return
     */
    public static boolean sendRequest(RequestEntity requestEntity) {
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()){
            RequestDao dao = daoFactory.getRequestDao(connection);
            dao.insertItem(requestEntity);
        } catch (SQLException sqlE) {
            return false;
        }
        return true;
    }

}
