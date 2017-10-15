package com.hotel.model.dao.impldao;

import com.hotel.model.entities.RootsEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RootsDao extends AbstractDao<RootsEntity> {

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM roots";
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return null;
    }

    @Override
    public List<RootsEntity> parseResultSet(ResultSet rs) {
        List<RootsEntity> rootsList = new ArrayList<>();
        try {
            while (rs.next()) {
                int idRoots = rs.getInt(1);
                String rootName = rs.getString(2);
                String login = rs.getString(3);
                String password = rs.getString(4);

                rootsList.add(new RootsEntity(idRoots, rootName, login, password));
            }
        } catch (SQLException sqlE) {

        }
        return rootsList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, RootsEntity entity) {
        throw  new UnsupportedOperationException();
    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, RootsEntity entity) {
        throw  new UnsupportedOperationException();
    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, RootsEntity entity) {
        throw  new UnsupportedOperationException();
    }

    public RootsEntity findRootByLogPass(String login, String password) {
        RootsEntity root = null;
        String query = "SELECT * FROM roots WHERE login=? AND password=?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            List<RootsEntity> list = parseResultSet(rs);
            if (list.size() == 1) {
                root = list.get(0);
            }
        } catch (SQLException xqlE) {
        }
        return root;
    }

    public RootsDao(Connection connection) {
        super(connection);
    }


}
