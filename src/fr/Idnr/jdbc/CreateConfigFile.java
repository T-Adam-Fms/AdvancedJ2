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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {

    public static void main(String[] args) {
        try {
            // Generate and save the configuration file
            Properties config = new Properties();
            FileOutputStream output = new FileOutputStream("db.properties");

            // Set database connection details
            config.setProperty("db.driver.class", "org.mariadb.jdbc.Driver");
            config.setProperty("db.url", "jdbc:mariadb://localhost:3306/shop");
            config.setProperty("db.login", "root");
            config.setProperty("db.password", "fms2024");

            // Save the properties to a file
            config.store(output, null);
            output.close();
            
            System.out.println("Configuration file created!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
