package org.example.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {

    public static void main(String[] args) {

        // 1 Création nouveau projet
        // File => new => project => Build System :  maven


        // 2 Ajout dépendancies maven :
        // ne pas oublier de rajouter la balise dependencies
// dans le fichier pom.xml
        //   a la racine du projet

        //  3 Ajouter le connector correspondant à ma BDD
        // https://mvnrepository.com/
        // Une fois la dépendance rajouter entre les balises dependencies
// je recharge maven


        // Je peux vérifier la présence de la nouvelle librairie
        // en regardant les external librairies présentes sur intelliJ


        // Preparation pour se connecter à ma BDD
        // url = jdbc:nom_dbconnecteur:localisation_bdd::nbPort/nom_db:
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = "test";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("La connexion est OK!!");
            } else {
                System.out.println("Connexion échoué");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        // Meilleur pratique mettre la connection dans une classe a part
        // Voir ConnectionUtils et Demo2

    }
}