package com.epamhotel.model.dao.impldao;

import com.epamhotel.domain.entities.OrderEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class RequestInfoDao extends AbstractDao<OrderEntity> {
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM requestinfo";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE requestinfo SET roomNumber = ?, dateOfArriving = ?, dateOfLeaving = ?, " +
                "firstName = ? secondName = ?, passport = ?, email = ? WHERE requestInfoId = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM requestinfo WHERE requestInfoId = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO requestinfo(roomNumber, dateOfArriving, dateOfLeaving, firstName, secondName, roomClass, passport, email, " +
                "isOpen) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public List<OrderEntity> parseResultSet(ResultSet rs) {
        List<OrderEntity> requestList = new LinkedList<>();
        try {
            while (rs.next()) {
                int requestInfoId = rs.getInt(1);
                int roomNumber = rs.getInt(2);


            }
        } catch (SQLException sqlE) {

        }
        return requestList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, OrderEntity entity) {

    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, OrderEntity entity) {
        try {
            statement.setInt(1, entity.getRequestInfoId());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, OrderEntity entity) {

    }

    @Override
    public OrderEntity getByKey(int itemKey) {
        return null;
    }

    public RequestInfoDao (Connection connection) {
        super(connection);
    }
}
