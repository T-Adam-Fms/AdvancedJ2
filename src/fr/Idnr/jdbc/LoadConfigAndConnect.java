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
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadConfigAndConnect {

    public static void main(String[] args) {
        Properties config = new Properties();

        try (FileInputStream input = new FileInputStream("db.properties")) {
            // Load the properties from the file
            config.load(input);

            // Retrieve connection properties
            String driverClass = config.getProperty("db.driver.class");
            String url = config.getProperty("db.url");
            String login = config.getProperty("db.login");
            String password = config.getProperty("db.password");

            // Load the JDBC driver
            Class.forName(driverClass);

            // Establish the database connection
            try (Connection connection = DriverManager.getConnection(url, login, password)) {
                System.out.println("Connected to the database successfully!");

                // Perform some basic queries to verify the connection
                // Example: connection.prepareStatement("SELECT * FROM your_table");

            } catch (SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the configuration file: " + e.getMessage());
        }
    }
}