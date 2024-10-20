//Exercice 5 : LE CODE DEVIENT ILLISIBLE, N’EST-CE PAS ?
//Reprenons donc nos bonnes habitudes et découpons notre appli à l’aide des packages :
//5.1 Ajouter le package fr.fms.entities et ajoutez-y la classe Article
//5.2 Ajouter le package fr.fms.dao qui va faire le lien entre notre application et la base de 
//données, ajoutez-y l’interface générique Dao (ci-dessous) contenant les méthodes dites 
//CRUD pour Create, Read, Update et Delete, puis ajouter la classe ArticleDao qui
//implémente l’interface générique Dao : public class ArticleDao implements Dao<Article>



package test;

import dao.ArticleDao;
import entities.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestArticleDao {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mariadb://localhost:3306/shop";
        String user = "root";
        String password = "fms2024";

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Database connection successful!");

            // Create an instance of ArticleDao
            ArticleDao articleDao = new ArticleDao(connection);

            // Create an Article object
            Article article = new Article(0, "Screen", "Test Brand", 170);

            // Insert the article into the database
            articleDao.create(article);  // This will call the create method in ArticleDao
            System.out.println("Article inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}




////Example of how you'd use ArticleDao in your application
//Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop", "root", "fms2024");
//ArticleDao articleDao = new ArticleDao(connection);
//
////Create an Article object
//Article newArticle = new Article(0, "New Article Description", "New Brand", 100.50);
//
////Insert the Article into the database
//articleDao.create(newArticle);