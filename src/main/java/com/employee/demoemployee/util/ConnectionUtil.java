package com.employee.demoemployee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private Connection con;

    public static Connection getConnection() {

        String driver = "org.postgresql.Driver";
        System.setProperty("jdbc.Drivers", driver);
        try {
            String local = "jdbc:postgresql://localhost/jdbc-sample";
            String usuario = "postgres";
            String password = "Neves123";
            con = DriverManager.getConnection(local, usuario, password);
        } catch (SQLException ex) {
            ex.getMessage();

        }

        return con;
    }
}
