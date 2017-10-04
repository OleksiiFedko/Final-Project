package com.epamhotel.model.dao.impldao;

import com.epamhotel.domain.entities.RoomClassEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoomClassDao extends AbstractDao<RoomClassEntity> {

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM roomclass";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE roomclass SET roomClass = ?, priceForDay = ? " +
                "WHERE idRoomClass = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM roomclass WHERE idRoomClass = ?";
    }

    @Override
    public String getInsertQuery() {
        return null;
    }

    @Override
    public void preparedStatementForUpdate(PreparedStatement statement, RoomClassEntity entity) {
        try {
            statement.setString(1, entity.getRoomClass());
            statement.setInt(2, entity.getPriceForDay());
            statement.setInt(3, entity.getIdRoomClass());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, RoomClassEntity entity) {
        try {
            statement.setInt(1, entity.getIdRoomClass());
        } catch (SQLException sqlE) {

        }
    }

    @Override
    public void preparedStatementForCreate(PreparedStatement statement, RoomClassEntity entity) {

    }

    @Override
    public List<RoomClassEntity> parseResultSet(ResultSet rs) {
        List<RoomClassEntity> roomClassList = new LinkedList<>();
        try{
            while(rs.next()) {
                int idRoomClass = rs.getInt(1);
                String roomClass = rs.getString(2);
                int priceForDay = rs.getInt(3);

                roomClassList.add(new RoomClassEntity(idRoomClass, roomClass, priceForDay));
            }
        } catch (SQLException sqlE) {

        }
        return roomClassList;
    }


    @Override
    public RoomClassEntity getByKey(int itemKey) {
        return null;
    }

    public RoomClassDao(Connection connection) {
        super(connection);
    }
}
