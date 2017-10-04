package com.epamhotel.model.dao.impldao;

import com.epamhotel.domain.entities.RoomsEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDao extends AbstractDao<RoomsEntity>{
    private Connection con;
    private PreparedStatement prst;
    private ResultSet rs;
    private String query;


    public ArrayList<RoomsEntity> getAllRooms() {
        try{
            String query = "SELECT roomNumber, numberOfPlaces," +
                    " isFree, roomClass, dateOfRelease FROM room";
//            con = DbConnection.getConnection();
            con = null;
            if(con != null) {
                prst = con.prepareStatement(query);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    public void updateRoom(int roomNumber) {

    }

    @Override
    public String getSelectQuery() {
        return null;
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
        return null;
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
