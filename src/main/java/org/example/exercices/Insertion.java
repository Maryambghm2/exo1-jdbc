package org.example.exercices;


import org.example.exercices.utils.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtils.getSQLConnection();
            if (connection != null) {
                System.out.println("Connexion à la base de donnée!!!");

                System.out.println("Veuillez saisir votre nom : ");
                String lastname = scanner.nextLine();
                System.out.println("Veuillez saisir votre prénom : ");
                String firstname = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Veuillez saisir le numéro de votre classe : ");
                int class_number = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Veuillez saisir la date d'obtention du diplôme (format: AAAA-MM--JJ): ");
                String input = scanner.nextLine();
                LocalDate graduation_date = LocalDate.parse(input);


                String request = "INSERT INTO students (lastname, firstname, class_number, graduation_date) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, lastname);
                preparedStatement.setString(2, firstname);
                preparedStatement.setInt(3, class_number);
                preparedStatement.setDate(4, Date.valueOf(graduation_date));
                int nbRows = preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                System.out.println("Nombre de ligne affecté : " + nbRows);
            } else {
                System.out.println("Connexion échouée");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
