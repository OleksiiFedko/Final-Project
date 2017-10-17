package com.hotel.domain.logic;

import com.hotel.model.entities.RootsEntity;
import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RootsDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Login {

    /**
     * Get root from DB
     * @param login
     * @param password
     * @return
     */
    public static RootsEntity checkRoot(String login, String password) {
        AbstractDaoFactory daoFactory = new DaoFactory();
        RootsEntity root = null;
        try(Connection connection = DBConnectionPool.getConnection()){
            RootsDao rootsDao = daoFactory.getRootsDao(connection);
            root = rootsDao.findRootByLogPass(login, password);
        } catch (SQLException sqlE) {
        }
        return root;
    }
}
