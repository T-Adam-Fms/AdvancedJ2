package fr.Idnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Article;

public class Exercise3Jdbc {
    private static final String URL = "jdbc:mariadb://localhost:3306/shop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "fms2024";

    public static void main(String[] args) {
        try {
            // Load MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            // Establish the database connection
            try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
                
                // Set auto-commit to true
                connection.setAutoCommit(true);  
                
                // Insert an article
                //insertArticle(connection, "Tablet", "Apple", 999.99);

                // Update the price of an article                
                //updateArticle(connection, "Tablet", 899.99);

                // Delete an article                
                //deleteArticle(connection, " Tablet");

                // Select and display all articles
                ArrayList<Article> articles = selectAllArticles(connection);
                printArticles(articles);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new article
    public static void insertArticle(Connection connection, String description, String brand, double price) {
        String insertSql = "INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertSql)) {
            stmt.setString(1, description);
            stmt.setString(2, brand);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("Inserted new article: " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update an article's price
    public static void updateArticle(Connection connection, String description, double newPrice) {
        String updateSql = "UPDATE t_articles SET UnitaryPrice = ? WHERE Description = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateSql)) {
            stmt.setDouble(1, newPrice);
            stmt.setString(2, description);
            stmt.executeUpdate();
            System.out.println("Updated article: " + description + " with new price: " + newPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 // Method to delete an article by description
    public static void deleteArticle(Connection connection, String description) {
        String deleteSql = "DELETE FROM t_articles WHERE Description = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteSql)) {
            stmt.setString(1, description.trim());  // Trim the description to remove any extra spaces
            stmt.executeUpdate();
            System.out.println("Deleted article: " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to select all articles
    public static ArrayList<Article> selectAllArticles(Connection connection) {
        ArrayList<Article> articles = new ArrayList<>();
        String selectSql = "SELECT * FROM t_articles";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {

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
    }
}

// Create Article class to store article details
class Article {
    private int id;
    private String description;
    private String brand;
    private double price;

    public Article(int id, String description, String brand, double price) {
        this.id = id;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}