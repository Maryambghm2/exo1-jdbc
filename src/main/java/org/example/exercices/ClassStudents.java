package org.example.exercices;

import org.example.exercices.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class ClassStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection connection = null;
        String classStudents = "SELECT * FROM students WHERE class_number =?";

        try {
            connection = ConnectionUtils.getSQLConnection();
            PreparedStatement statement = connection.prepareStatement(classStudents);
            System.out.println("Vous souhaites voir les éléves de quel classe (numéro) ?");
            int classNumber = scanner.nextInt();

            statement.setInt(1, classNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Eleves de la classe " + classNumber + " :");
                System.out.println(" Nom : " + resultSet.getString("lastname"));
                System.out.println(" Prénom : " + resultSet.getString("firstname"));
                System.out.println(" Date d'obtention du diplôme : " + resultSet.getDate("graduation_date"));
            } else {
                System.out.println("Impossible d'afficher la classe (classe inexistante)");
            }

        } catch (SQLException e) {
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
