package com.hotel.model.dao.impldao;

import com.hotel.model.entities.OrderEntity;
import com.hotel.model.entities.RequestEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDao extends AbstractDao<OrderEntity> {
    @Override
    public String getSelectQuery() {
        return "SELECT o.id, o.roomNumber, o.requestId, r.dateOfArriving, r.dateOfLeaving, r.firstName, " +
                "r.secondName, r.roomClass, r.passport, r.email " +
                "FROM `order` o " +
                "INNER JOIN request r " +
                "ON o.requestId = r.id";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE order SET roomNumber = ?, dateOfArriving = ?, dateOfLeaving = ?, " +
                "firstName = ? secondName = ?, passport = ?, email = ? WHERE id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM order WHERE id = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO `order`(roomNumber, requestId) VALUES(?, ?)";
    }

    @Override
    public List<OrderEntity> parseResultSet(ResultSet rs) {
        List<OrderEntity> orderList = new LinkedList<>();
        try {
            while (rs.next()) {
                int orderId = rs.getInt(1);
                int roomNumber = rs.getInt(2);
                int requestId = rs.getInt(3);
                Date arrivingDate = rs.getDate(4);
                Date leavingDate = rs.getDate(5);
                String firstName = rs.getString(6);
                String secondName = rs.getString(7);
                String roomClass = rs.getString(8);
                String passport = rs.getString(9);
                String email = rs.getString(10);

                RequestEntity request = new RequestEntity(requestId, arrivingDate, leavingDate,
                        firstName, secondName, roomClass, passport, email);

                orderList.add(new OrderEntity(orderId, roomNumber, request));
            }
        } catch (SQLException sqlE) {

        }
        return orderList;
    }

    public List<OrderEntity> getByRoomNumber(int roomNumber) {
        List<OrderEntity> list = null;
        String query = getSelectQuery();
        query += "  WHERE roomNumber = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomNumber);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException sqlE) {

        }
        return list;
    }

    public List<Integer> getRoomsByClass(String roomClass) {
        List<Integer> roomsList = new ArrayList<>();
        String query = "SELECT o.roomNumber FROM `order` o " +
                "INNER JOIN request r " +
                "ON r.id = o.requestId " +
                "WHERE r.roomClass = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, roomClass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int roomNumber = rs.getInt(1);
                roomsList.add(roomNumber);
            }
        } catch (SQLException sqlE) {
        }
        return roomsList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, OrderEntity entity) {

    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, OrderEntity entity) {
        try {
            statement.setInt(1, entity.getOrderId());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, OrderEntity entity) {
        try {
            statement.setInt(1, entity.getRoomNumber());
            statement.setInt(2, entity.getRequestEntity().getRequestId());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    public OrderEntity getByKey(int itemKey) {
        return null;
    }

    public OrderDao(Connection connection) {
        super(connection);
    }
}
