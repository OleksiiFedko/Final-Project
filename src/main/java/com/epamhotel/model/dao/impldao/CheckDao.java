package com.epamhotel.model.dao.impldao;

import com.epamhotel.domain.entities.CheckEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CheckDao extends AbstractDao<CheckEntity> {
    private final Connection connection;

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM check";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE check SET price = ?, requestInfoId" +
                "WHERE idCheck = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM check WHERE idCheck = ?";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT  INTO check (price, requestInfoId) VALUES (?, ?)";
    }

    @Override
    public List parseResultSet(ResultSet rs) {
        List<CheckEntity> checkList = new LinkedList<>();
        try {
            int idCheck = rs.getInt(1);
            int price = rs.getInt(2);
            int requestInfoId = rs.getInt(3);

            checkList.add(new CheckEntity(idCheck, price, requestInfoId));
        } catch (SQLException sqlE) {

        }
        return checkList;
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, CheckEntity entity) {
        try {
            statement.setInt(1, entity.getPrice());
            statement.setInt(2, entity.getRequestInfoId());
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
            statement.setInt(2, entity.getRequestInfoId());
        } catch (SQLException sqlE) {

        }
    }

    public CheckDao(Connection connection) {
        this.connection = connection;
    }
}
