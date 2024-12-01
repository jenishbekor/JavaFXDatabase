package com.example.demo1gui;

import java.sql.Connection;
import java.sql.SQLException;
public interface DatabaseConnection {
    Connection getConnection() throws SQLException;
}
