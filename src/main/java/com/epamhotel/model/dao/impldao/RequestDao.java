package com.epamhotel.model.dao.impldao;

import com.epamhotel.domain.entities.RequestEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RequestDao extends AbstractDao<RequestEntity> {
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM request";
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
        return "INSERT INTO request(dateOfArriving, dateOfLeaving, firstName, secondName, roomClass, passport, email, isOpen) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public List<RequestEntity> parseResultSet(ResultSet rs) {
        List<RequestEntity> requestList = new LinkedList<>();
        try {
            while (rs.next()) {
                int requestId = rs.getInt(1);
                Date dateOfArriving = rs.getDate(2);
                Date dateOfLeaving = rs.getDate(3);
                String firstName = rs.getString(4);
                String secondName = rs.getString(5);
                String roomClass = rs.getString(6);
                String passport = rs.getString(7);
                String email = rs.getString(8);
                boolean isOpen = Boolean.parseBoolean(rs.getString(9));

                requestList.add(new RequestEntity(requestId, dateOfArriving, dateOfLeaving,
                                    firstName, secondName, roomClass , passport, email, isOpen));
            }
        } catch (SQLException sqlE) {

        }
        return requestList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, RequestEntity entity) {

    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, RequestEntity entity) {

    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, RequestEntity entity) {
        try{
            statement.setDate(1, entity.getDateOfArriving());
            statement.setDate(2, entity.getDateOfLeaving());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getSecondName());
            statement.setString(5, entity.getRoomClass());
            statement.setString(6, entity.getPassport());
            statement.setString(7, entity.getEmail());
            statement.setString(8, String.valueOf(entity.getIsOpen()));
        } catch (SQLException sqlE) {

        }
    }

    public List<RequestEntity> getOpenedRequests() {
        List<RequestEntity> openRequests = new ArrayList<>();
        String query = getSelectQuery();
        query += " WHERE isOpen = 'true'";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            openRequests = parseResultSet(rs);
        } catch (SQLException sqlE) {

        }
        return openRequests;
    }

    public RequestDao(Connection connection) {
        super(connection);
    }
}
