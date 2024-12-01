package com.example.demo1gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection implements DatabaseConnection{

    private final String url = "jdbc:postgresql:testdb";
    private final String username = "postgres";
    private final String password = "postgres";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
