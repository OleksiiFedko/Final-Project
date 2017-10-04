package com.epamhotel.domain.logic;

import com.epamhotel.domain.entities.OrderEntity;
import com.epamhotel.domain.entities.RequestEntity;
import com.epamhotel.model.dao.connection.DBConnectionPool;
import com.epamhotel.model.dao.factorydao.AbstractDaoFactory;
import com.epamhotel.model.dao.factorydao.DaoFactory;
import com.epamhotel.model.dao.impldao.RequestDao;
import com.epamhotel.model.dao.impldao.RequestInfoDao;

import java.sql.Connection;
import java.sql.SQLException;

public class SendRequest {

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
