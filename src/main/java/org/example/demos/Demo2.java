package org.example.demos;

import org.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
//        // Test de connexion :
//
//        try {
//            Connection connection = ConnectionUtils.getSQLConnection();
//            if (connection != null) {
//                System.out.println("Yep ça fonctionne !");
//            } else {
//                System.out.println("Il faut vérifier la classe ConnexionUtils");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
        // Fin de test connexion

        // Demo de Base
        // Enregistrer une saisie utilisateur en BDD
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = ConnectionUtils.getSQLConnection();
            System.out.println("On vien de se connecter a la BDD");
            System.out.println("Merci de saisir le prénom: ");
            String firstname = scanner.nextLine();
            System.out.println("Merci de saisir le nom: ");
            String lastname = scanner.nextLine();

            // Une requête pour l'insertion des données
//            String request = "INSERT INTO users (firstname, lastname) VALUES ('" + firstname + "', '" + lastname + "')";
//            System.out.println("Voici la requête que je vais faire : " + request);


            // Facon 1 => execution d'une requête sans retour
            // Attention danger injection SQL avec ce système (variable dans la chaine de caractère)
//            Statement statement = connection.createStatement();
//            statement.execute(request);
//            System.out.println("Requête exécutée");

            // Facon 2 => Avec une requête préparée
            // version sans récupération de l'id auto généré
//            String request = "INSERT INTO users (firstname, lastname) VALUES (?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(request);
//            preparedStatement.setString(1, firstname);
//            preparedStatement.setString(2, lastname);
//            System.out.println("Voici la requête que je vais faire : " + request);
//            preparedStatement.execute(); // retour boolean
//            int nbRows = preparedStatement.executeUpdate(); // Retour int qui correspond au nombres de ligne affecté
//            System.out.println("Nombre de ligne : " + nbRows);

            //Façon 3 =>    avec récuperation de l'id auto générée
            String request = "INSERT INTO users (firstname, lastname) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            int nbrRows = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("nombre de ligne: "+nbrRows);
            if (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // fermer la connection dans le bloc finally pour garantir sa fermeture
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
