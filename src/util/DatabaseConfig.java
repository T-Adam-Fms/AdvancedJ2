//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :
<<<<<<< HEAD


package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private final String url = "jdbc:mariadb://localhost:3306/shop"; // Database URL
    private final String user = "root"; // Database username
    private final String password = "fms2024"; // Database password

    // Method to get the database connection
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
=======
//
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseConfig {
    private final String url = "jdbc:mariadb://localhost:3306/shop";  // Replace with your actual DB details
    private final String user = "root";  // Your database username
    private final String password = "fms2024";  // Your database password

    public DatabaseConfig(String string) {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MariaDB driver (Make sure you have the JDBC driver in your classpath)
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
>>>>>>> 37b2420 (ex7)
    }
}