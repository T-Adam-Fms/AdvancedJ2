//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :




package test;

<<<<<<< HEAD
import dao.UserDao;
import entities.Article;
import util.DatabaseConfig;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
=======
import dao.UserDao;  
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import entities.Article;
import util.DatabaseConfig;
>>>>>>> 37b2420 (ex7)

public class Exercise6Jdbc {
    public static void main(String[] args) {
        // Create an instance of DatabaseConfig to manage the connection
        DatabaseConfig dbConfig = new DatabaseConfig();
<<<<<<< HEAD

=======
        
>>>>>>> 37b2420 (ex7)
        try (Connection connection = dbConfig.getConnection()) {
            if (connection != null) {
                // Create an instance of UserDao for user validation
                UserDao userDao = new UserDao(connection);

                // Get user login credentials
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter login: ");
                String login = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Validate user login
                if (userDao.validateUser(login, password)) {
<<<<<<< HEAD
                    System.out.println("Login successful!");

                    // Perform database operations if login is valid
                    // Assuming you have implemented methods for Article operations
                    insertArticle(connection, new Article(0, "Smartwatch", "Apple", 299.99));
                    ArrayList<Article> articles = selectAllArticles(connection);
                    printArticles(articles);
=======
                    System.out.println("Login successful! Welcome, " + login);

                    // Execute CRUD operations only after successful login

                    // Insert a new article
                    insertArticle(connection, "Smartwatch", "Apple", 299.99);
                    System.out.println("Inserted a new article.");

                    // Update an article's price
                    updateArticle(connection, "Smartwatch", 279.99);
                    System.out.println("Updated the price of Smartwatch.");

                    // Delete an article
                    deleteArticle(connection, "Smartwatch");
                    System.out.println("Deleted the article Smartwatch.");

                    // Select and display all articles
                    ArrayList<Article> articles = selectAllArticles(connection);
                    printArticles(articles);

>>>>>>> 37b2420 (ex7)
                } else {
                    System.out.println("Login failed! Invalid credentials.");
                }
            } else {
                System.out.println("Failed to establish a database connection.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    // Assuming you have the following methods defined elsewhere in your code:
    public static void insertArticle(Connection connection, Article article) {
        // Implement the method to insert an article into the database
    }

    public static ArrayList<Article> selectAllArticles(Connection connection) {
        // Implement the method to retrieve all articles from the database
        return new ArrayList<>(); // Return an empty list for now
    }

    public static void printArticles(ArrayList<Article> articles) {
        // Implement the method to print articles
=======
    // Method to insert a new article
    public static void insertArticle(Connection connection, String description, String brand, double price) {
        String insertSql = "INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(insertSql)) {
            stmt.setString(1, description);
            stmt.setString(2, brand);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update an article's price
    public static void updateArticle(Connection connection, String description, double newPrice) {
        String updateSql = "UPDATE t_articles SET UnitaryPrice = ? WHERE Description = ?";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(updateSql)) {
            stmt.setDouble(1, newPrice);
            stmt.setString(2, description);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete an article by description
    public static void deleteArticle(Connection connection, String description) {
        String deleteSql = "DELETE FROM t_articles WHERE Description = ?";
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(deleteSql)) {
            stmt.setString(1, description.trim());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to select all articles
    public static ArrayList<Article> selectAllArticles(Connection connection) {
        ArrayList<Article> articles = new ArrayList<>();
        String selectSql = "SELECT * FROM t_articles";
        try (java.sql.Statement stmt = connection.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(selectSql)) {

            while (rs.next()) {
                int id = rs.getInt("IDArticle");
                String description = rs.getString("Description");
                String brand = rs.getString("Brand");
                double price = rs.getDouble("UnitaryPrice");

                articles.add(new Article(id, description, brand, price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    // Method to print all articles
    public static void printArticles(ArrayList<Article> articles) {
        for (Article article : articles) {
            System.out.println(article.getId() + " - " + article.getDescription() + " - " + article.getBrand() + " - " + article.getPrice());
        }
>>>>>>> 37b2420 (ex7)
    }
}
