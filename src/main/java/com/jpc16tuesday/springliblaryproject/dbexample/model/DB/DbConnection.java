package com.jpc16tuesday.springliblaryproject.dbexample.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static  com.jpc16tuesday.springliblaryproject.dbexample.model.constants.DBConstants.*;
public enum DbConnection {
    INSTANCE;
    private Connection connection;

    public Connection newConnection() throws SQLException {
        if (connection == null) {
            return DriverManager.getConnection("jdbc:postgresql://" + DB_HOST +":" + PORT +
                     "/" + DB, USER, PASSWORD);
        }
        return connection;
    }
}
