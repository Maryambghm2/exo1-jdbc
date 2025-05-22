# Gestion des Étudiants - Projet JDBC Java

Ce petit projet a été réalisé dans le cadre d’un exercice pratique autour de JDBC en Java avec IntelliJ. L’objectif est de se connecter à une base de données MySQL pour effectuer des opérations simples (CRUD) sur une table `students`.

## 📚 Fonctionnalités

Le programme permet :

- d'afficher tous les étudiants
- de filtrer les étudiants par numéro de classe
- de supprimer un étudiant à partir de son nom et prénom
- de se connecter à la base de données via une classe utilitaire dédiée

## 🧱 Structure du projet

### 🔌 utils/ConnectionUtils.java

Contient une méthode statique pour établir la connexion avec la base de données MySQL. Les identifiants de connexion sont définis en dur pour l’exercice (`root` / `test`).

### 📋 AllStudents.java

Affiche tous les étudiants présents dans la table `students` avec leurs informations : nom, prénom, numéro de classe, date de diplôme.

### 🧑‍🏫 ClassStudents.java

Permet de saisir un numéro de classe dans la console et affiche les étudiants de cette classe.

### 🗑️ DeleteStudent.java

Demande le nom et le prénom d’un étudiant, vérifie s’il existe dans la base, puis le supprime.

## 🛠️ Pré-requis

- Java 21
- IntelliJ IDEA
- Base de données MySQL avec une table `students` ayant au minimum les colonnes :
- `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL
  - `lastname` (VARCHAR 150)
  - `firstname` (VARCHAR)
  - `class_number` (INT)
  - `graduation_date` (DATE)

## 🔌 Connexion à la base de données

Vérifiez que la base `exo1_jdbc` existe bien en local et que les identifiants correspondent dans `ConnectionUtils.java`.

## 💡 Remarques

L’objectif ici était surtout de se familiariser avec :
- l’utilisation de `PreparedStatement` pour éviter les injections SQL
- la manipulation de `ResultSet`
- les bonnes pratiques de fermeture de connexion

## 📦 Exécution

Lancement des différentes classes depuis IntelliJ ou la ligne de commande.

---

