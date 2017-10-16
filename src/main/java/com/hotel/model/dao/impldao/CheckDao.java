package com.hotel.model.dao.impldao;

import com.hotel.model.entities.CheckEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CheckDao extends AbstractDao<CheckEntity> {

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM check";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE check SET price = ?, requestInfoId" +
                "WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM check WHERE id = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT  INTO `check` (price, requestId) VALUES (?, ?)";
    }

    @Override
    public List parseResultSet(ResultSet rs) {
        List<CheckEntity> checkList = new LinkedList<>();
        try {
            int idCheck = rs.getInt(1);
            int price = rs.getInt(2);
            int orderId = rs.getInt(3);

            checkList.add(new CheckEntity(idCheck, price, orderId));
        } catch (SQLException sqlE) {

        }
        return checkList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, CheckEntity entity) {
        try {
            statement.setInt(1, entity.getPrice());
            statement.setInt(2, entity.getRequestId());
            statement.setInt(3, entity.getCheckId());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, CheckEntity entity) {
        try {
            statement.setInt(1, entity.getCheckId());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, CheckEntity entity) {
        try {
            statement.setInt(1, entity.getPrice());
            statement.setInt(2, entity.getRequestId());
        } catch (SQLException sqlE) {

        }
    }

    public CheckDao(Connection connection) {
        this.connection = connection;
    }
}
