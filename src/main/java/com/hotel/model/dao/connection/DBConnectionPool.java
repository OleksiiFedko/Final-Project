package com.hotel.model.dao.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPool {

    private static DataSource dataSource;

    private DBConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        if(dataSource == null) {
            try {
                Context context = new InitialContext();
                dataSource = (DataSource)context.lookup("java:comp/env/jdbc/hoteldb");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource.getConnection();
    }

}
