package org.example.demos;

import org.example.utils.ConnectionUtils;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) {

        Connection connection = null;
        String request = "SELECT * FROM users";
        try {
            connection = ConnectionUtils.getSQLConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(request);
//            while (resultSet.next()) {
//                System.out.print(" La colonne id : " + resultSet.getInt("id"));
//                System.out.print(" La colonne firstname : " + resultSet.getString("firstname"));
//                System.out.println(" La colonne lastname : " + resultSet.getString("lastname"));


            String request2 = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(request2);
            statement.setInt(1, 3);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("La personne avec l'id numero 3 :");
                System.out.print(" Son prénom : " + resultSet.getString("firstname"));
                System.out.print(" Son nom : " + resultSet.getString("lastname"));
            }
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
