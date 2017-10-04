package com.epamhotel.domain.logic;

import com.epamhotel.domain.entities.RootsEntity;
import com.epamhotel.domain.exceptions.TechnicalException;
import com.epamhotel.model.dao.connection.DBConnectionPool;
import com.epamhotel.model.dao.factorydao.AbstractDaoFactory;
import com.epamhotel.model.dao.factorydao.DaoFactory;
import com.epamhotel.model.dao.impldao.RootsDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Login {

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
