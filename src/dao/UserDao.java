<<<<<<< HEAD
//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :


package dao;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
=======
//Exercice 7 : Effectuer des insertions d’utilisateurs, vous pouvez modifier le script Shop.sql 
//par exemple et le regénérer mais attention aux doublons !
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> 37b2420 (ex7)

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

<<<<<<< HEAD
    // Method to validate user login
    public boolean validateUser(String login, String password) {
        String sql = "SELECT * FROM T_Users WHERE Login = ? AND Password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  // Return true if user exists
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
=======
    // Method to insert a user
    public void insertUser(String username, String password) {
        String sql = "INSERT INTO t_users (Login, Password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Inserted user: " + username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to check if a user already exists
    public boolean userExists(String username) {
        String sql = "SELECT COUNT(*) FROM t_users WHERE Login = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Return true if the count is greater than 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Default return false if there's an error
    }
}






////Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
////accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
////homologue en base dont voici le contenu :
//
//
//package dao;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserDao {
//    private Connection connection;
//
//    public UserDao(Connection connection) {
//        this.connection = connection;
//    }
//
//    // Method to validate user login
//    public boolean validateUser(String login, String password) {
//        String sql = "SELECT * FROM T_Users WHERE Login = ? AND Password = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, login);
//            stmt.setString(2, password);
//            try (ResultSet rs = stmt.executeQuery()) {
//                return rs.next();  // Return true if user exists
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
>>>>>>> 37b2420 (ex7)
