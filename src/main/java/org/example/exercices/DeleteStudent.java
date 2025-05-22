package org.example.exercices;

import org.example.exercices.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        // Requêtes :
        String verifStudent = "SELECT * FROM students WHERE lastname =? AND firstname=?";
        String deleteStudent = "DELETE FROM students WHERE lastname =? AND firstname=?";

        try {
            connection = ConnectionUtils.getSQLConnection();

            // Demande utilisateur :
            System.out.println("Quel est le nom de l'étudiant que vous souhaitez supprimer ?");
            String lastname = scanner.nextLine();
            System.out.println("Quel est le prénom de l'étudiant que vous souhaitez supprimer ?");
            String firstname = scanner.nextLine();

            PreparedStatement verifStatement = connection.prepareStatement(verifStudent);

            // Recupération valeur pour la vérification
            verifStatement.setString(1, lastname);
            verifStatement.setString(2, firstname);


            ResultSet resultSetVerif = verifStatement.executeQuery();

            // Vérification existance étudiant à supprimer:
            if (resultSetVerif.next()) {
                // Assignement valeur à supprimer
                PreparedStatement suppStatement = connection.prepareStatement(deleteStudent);

                // Recupération valeur pour la suppression
                suppStatement.setString(1, lastname);
                suppStatement.setString(2, firstname);

                // Vérification suppression
                int nbRows = suppStatement.executeUpdate();
                if (nbRows > 0) {
                    System.out.println("L'étudiant avec le nom '" + lastname + "' et le nom  '" + firstname + "' a été supprimé avec succès !");
                }
            } else {
                System.out.println("L'étudiant que vous souhaitez supprimer n'existe pas . Veuillez réessayer!");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
