package test;

import dao.UserDao;  
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import entities.Article;
import util.DatabaseConfig;
import java.sql.SQLException;


public class Exercise7Jdbc {

    public static void main(String[] args) {
        // Create an instance of DatabaseConfig and specify the properties file
        DatabaseConfig dbConfig = new DatabaseConfig("db.properties");
        try (Connection connection = dbConfig.getConnection()) { // Use try-with-resources to manage the connection
            if (connection != null) {
                // Create an instance of UserDao to handle user insertions
                UserDao userDao = new UserDao(connection);

                // Define new users to insert
                String[][] usersToInsert = {
                    {"newuser1", "password1"},
                    {"newuser2", "password2"},
                };

                // Insert new users into the database
                for (String[] user : usersToInsert) {
                    String username = user[0];
                    String password = user[1];
                    if (!userDao.userExists(username)) {
                        userDao.insertUser(username, password);
                    } else {
                        System.out.println("User " + username + " already exists. Skipping insertion.");
                    }
                }

                System.out.println("User insertion complete.");
            } else {
                System.out.println("Failed to establish a database connection.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}