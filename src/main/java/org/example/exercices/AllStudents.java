package org.example.exercices;

import org.example.exercices.utils.ConnectionUtils;

import java.sql.*;

public class AllStudents {
    public static void main(String[] args) {
        Connection connection = null;
        String allStudents = "SELECT * FROM students";

        try {
            connection = ConnectionUtils.getSQLConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(allStudents);
            while (resultSet.next()) {
                System.out.print(" La colonne nom : " + resultSet.getString("lastname"));
                System.out.print(" La colonne prénom : " + resultSet.getString("firstname"));
                System.out.print(" La colonne numéro de classe : " + resultSet.getInt("class_number"));
                System.out.println(" La date d'obtention du diplôme : " + resultSet.getDate("graduation_date"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
