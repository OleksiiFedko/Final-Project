package com.hotel.model.dao.impldao;

import com.hotel.model.dao.connection.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    protected Connection connection;

    protected AbstractDao() {
    }

    public abstract String getSelectQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract String getInsertQuery();

    public abstract List<T> parseResultSet(ResultSet rs);

    protected abstract void preparedStatementForUpdate(PreparedStatement statement, T entity);

    protected abstract void preparedStatementForDelete(PreparedStatement statement, T entity);

    protected abstract void preparedStatementForCreate(PreparedStatement statement, T entity);


    @Override
    public List<T> getAllItems() {
        List<T> list = null;
        String query = getSelectQuery();
        try(Connection connection = DBConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException sqlE) {

        }
        return list;
    }

    @Override
    public T getByKey(int key) {
        List<T> list = null;
        String query = getSelectQuery();
        query += " WHERE id = ?";
        try(Connection connection = DBConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException sqlE) {
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator().next();
    }

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteItem(T item) {
        String query = getDeleteQuery();
        try(Connection connection = DBConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            preparedStatementForDelete(statement, item);
            statement.executeUpdate();
        } catch (SQLException sqlE) {

        }
    }

    @Override
    public  void updateItem(T item) {
        String query = getUpdateQuery();
        try(Connection connection = DBConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            preparedStatementForUpdate(statement, item);
            statement.executeUpdate();
        } catch (SQLException sqlE) {

        }
    }

    @Override
    public void insertItem(T item) {
        String query = getInsertQuery();
        try(Connection connection = DBConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            preparedStatementForCreate(statement, item);
            statement.executeUpdate();
        } catch (SQLException sqlE) {

        }
    }
}
