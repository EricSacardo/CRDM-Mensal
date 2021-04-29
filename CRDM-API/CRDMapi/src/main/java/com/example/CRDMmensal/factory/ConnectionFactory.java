package com.example.CRDMmensal.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projetomensal", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
