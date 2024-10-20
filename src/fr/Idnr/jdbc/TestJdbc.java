//Exercice 4 : Nous souhaitons dorénavant utiliser un fichier de configuration unique 
//contenant toutes les informations de connexion. En effet, afin de rendre notre application 
//ouverte aux évolutions notamment lorsqu’il s’agit de migrer d’un SGBD à un autre sans 
//avoir à toucher au code source, un fichier de configuration contiendra toutes les 
//informations nécessaires comme ici :
//db.driver.class = org.mariadb.jdbc.Driver
//db.url = jdbc:mariadb://localhost:3306/Shop
//db.login = le votre
//db.password = le vôtre
//Dans un premier temps, il faudra le créer/générer à l’aide d’une classe CreateConfigFile
//puis dans un second temps l’utiliser pour exploiter votre base de données, vérifier que le 
//tout fonctionne parfaitement. Pour vous aider, voir l’exemple ici



package fr.Idnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Article;

public class TestJdbc {

    public static void main(String[] args) throws Exception {

        ArrayList<Article> articles = new ArrayList<>(); // Import ArrayList

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Load MariaDB driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connection details
        String url = "jdbc:mariadb://localhost:3306/shop";
        String login = "root";
        String password = "fms2024";

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            // Correct table name (case sensitive)
            String strSql = "SELECT * FROM t_articles"; 
            
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(strSql)) {
                    while (resultSet.next()) {
                        // Use column names directly
                        int rsIdArticle = resultSet.getInt("IDArticle");
                        String rsDescription = resultSet.getString("Description");
                        String rsBrand = resultSet.getString("Brand");
                        double rsUnitaryPrice = resultSet.getDouble("UnitaryPrice");

                        // Assuming Article has the correct constructor
                        articles.add(new Article(rsIdArticle, rsDescription, rsBrand, rsUnitaryPrice));
                    }
                }
            }

            // Print the articles (assuming the Article class has appropriate getters)
            for (Article a : articles) {
                System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
            }
        }
    }
}




//package fr.Idnr.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class TestJdbc {
//
//    public static void main(String[] args) throws Exception {
//
//        ArrayList<Article> articles = new ArrayList<>(); // Import ArrayList
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver"); // Load MariaDB driver
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Connection details
//        String url = "jdbc:mariadb://localhost:3306/shop";
//        String login = "root";
//        String password = "fms2024";
//
//        try (Connection connection = DriverManager.getConnection(url, login, password)) {
//            String strSql = "SELECT * FROM T_Articles";
//            try (Statement statement = connection.createStatement()) {
//                try (ResultSet resultSet = statement.executeQuery(strSql)) {
//                    while (resultSet.next()) {
//                        int rsIdUser = resultSet.getInt(1);
//                        String rsDescription = resultSet.getString(2);
//                        String rsBrand = resultSet.getString(3); // Corrected column name
//                        double rsUnitaryPrice = resultSet.getDouble(4);
//
//                        // Assuming Article has the correct constructor
//                        articles.add(new Article(rsIdUser, rsDescription, rsBrand, rsUnitaryPrice));
//                    }
//                }
//            }
//
//            // Print the articles (assuming the Article class has appropriate getters)
//            for (Article a : articles) {
//                System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
//            }
//        }
//    }
//}
