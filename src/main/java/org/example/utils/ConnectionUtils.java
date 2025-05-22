package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getSQLConnection() throws SQLException {
        // Preparation pour se connecter à ma BDD
        // url = jdbc:nom_dbconnecteur:localisation_bdd::nbPort/nom_db:
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = "test";

        Connection connection = DriverManager.getConnection(url,username, password);
        return connection;
    }
}
