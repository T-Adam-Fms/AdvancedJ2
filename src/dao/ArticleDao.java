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


package dao; // ensure it matches the folder structure

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Article; // Ensure this import is correct!
import dao.Dao;          // Import the Dao interface

public class ArticleDao implements Dao<Article> {

    private Connection connection; // Connection object

    // Constructor to initialize connection
    public ArticleDao(Connection connection) {
        this.connection = connection;
    }

    // Implementation of the create method defined in Dao<Article>
    @Override
    public void create(Article obj) {
        String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?);";
        try (PreparedStatement ps = connection.prepareStatement(str)) {
            ps.setString(1, obj.getDescription());
            ps.setString(2, obj.getBrand());
            ps.setDouble(3, obj.getPrice());
            int row = ps.executeUpdate();
            if (row == 1) {
                System.out.println("Insertion OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class ArticleDao implements Dao<Article> {
//
//    private Connection connection; // Connection object
//
//    // Constructor to initialize the connection
//    public ArticleDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    // Commented out for now: Insertion using Statement (vulnerable to SQL injection)
//    /*
//    @Override
//    public void create(Article obj) {
//        String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) "
//                   + "VALUES ('" + obj.getDescription() + "', '" + obj.getBrand() + "', " + obj.getPrice() + ");";
//        try (Statement statement = connection.createStatement()) {
//            int row = statement.executeUpdate(str);
//            if (row == 1) {
//                System.out.println("Insertion OK");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    */
//
//    // Insertion using PreparedStatement -> prevents SQL injection by using parameterized queries
//    @Override
//    public void createPrepared(Article obj) {
//        String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?);";
//        try (PreparedStatement ps = connection.prepareStatement(str)) {
//            ps.setString(1, obj.getDescription());
//            ps.setString(2, obj.getBrand());
//            ps.setDouble(3, obj.getPrice());
//            int row = ps.executeUpdate();  // Executes the update and returns the affected row count
//            if (row == 1) {
//                System.out.println("Insertion OK");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}



//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ArticleDao implements Dao<Article> {
//
//    //private Connection connection; // Connection object
//
//    // Constructor to initialize connection
//    //public ArticleDao(Connection connection) {
//     //  this.connection = connection;
//    
//
//    @Override
//    public void create(Article obj) {
//    	 try (Statement statement = connection.createStatement()) {
//        String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice)"
//        		   +" VALUES ('" + obj.getDescription() + "', '" + obj.getBrand() + "', " + obj.getPrice() + ");";
//            int row = statement.executeUpdate(str);
//            if (row == 1) {	          System.out.println("Insertion OK");
//            }catch (SQLException e) {
//            e.printStackTrace();
//            }	
//    }
//     // exemple d'insertion avec preparestament -> evite les attaques par injection       
//   public void createPrepared(Article obj) {
//       String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?);";
//        try (PreparedStatement ps = connection.prepareStatement(str)) {
//            ps.setString(1, obj.getDescription());
//            ps.setString(2, obj.getBrand());
//            ps.setDouble(3, obj.getPrice());
//            int row = ps.executeUpdate(); // Correct method
//           if (ps.executeUpdate() == 1) 
//                System.out.println("Insertion OK");
//            
//        } catch (SQLException e) {
//           e.printStackTrace();
//        }
//    }
//}
//
//
