package org.example.exercices.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/exo1_jdbc";
        String username = "root";
        String password = "test";

        Connection connection = DriverManager.getConnection(url,username, password);
        return connection;
    }
}
