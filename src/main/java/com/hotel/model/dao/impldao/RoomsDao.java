package com.hotel.model.dao.impldao;

import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.entities.RoomClassEntity;
import com.hotel.model.entities.RoomsEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDao extends AbstractDao<RoomsEntity>{

    @Override
    public String getSelectQuery() {
        return "SELECT r.roomNumber, r.roomClassId, rc.roomClass, rc.priceForDay FROM room r " +
                "INNER JOIN roomclass rc " +
                "ON rc.id = r.roomClassId";
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
    public List<RoomsEntity> parseResultSet(ResultSet rs) {
        List<RoomsEntity> roomsList = new ArrayList<>();
        try{
            while (rs.next()) {
                int roomNumber = rs.getInt(1);
                int roomClassId = rs.getInt(2);
                String roomClass = rs.getString(3);
                int priceForDay = rs.getInt(4);

                RoomClassEntity classEntity = new RoomClassEntity(roomClassId, roomClass, priceForDay);

                roomsList.add(new RoomsEntity(roomNumber, classEntity));
            }
        } catch (SQLException sqlE) {

        }
        return roomsList;
    }

    public List<Integer> getRoomsByClass(String roomClass) {
        List<Integer> list = new ArrayList<>();
        String query = "SELECT r.roomNumber FROM room r " +
                        "INNER JOIN roomclass rc " +
                        "ON rc.id = r.roomClassId " +
                        "WHERE rc.roomClass = ?";// + roomClass + "'";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, roomClass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int roomNumber = rs.getInt(1);
                list.add(roomNumber);
            }
        } catch (SQLException sqlE) {
        }
        return list;
    }

    @Override
    public RoomsEntity getByKey(int key) {
        List<RoomsEntity> list = null;
        String query = getSelectQuery();
        query += " WHERE r.roomNumber = ?";
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

    @Override
    protected void preparedStatementForUpdate(PreparedStatement statement, RoomsEntity entity) {

    }

    @Override
    protected void preparedStatementForDelete(PreparedStatement statement, RoomsEntity entity) {

    }

    @Override
    protected void preparedStatementForCreate(PreparedStatement statement, RoomsEntity entity) {

    }

    public RoomsDao(Connection connection) {
        super(connection);
    }
}
