//Exercice 5 : LE CODE DEVIENT ILLISIBLE, N’EST-CE PAS ?
//Reprenons donc nos bonnes habitudes et découpons notre appli à l’aide des packages :
//5.1 Ajouter le package fr.fms.entities et ajoutez-y la classe Article
//5.2 Ajouter le package fr.fms.dao qui va faire le lien entre notre application et la base de 
//données, ajoutez-y l’interface générique Dao (ci-dessous) contenant les méthodes dites 
//CRUD pour Create, Read, Update et Delete, puis ajouter la classe ArticleDao qui
//implémente l’interface générique Dao : public class ArticleDao implements Dao<Article>

package dao; //  Data Access Object

import java.sql.Connection;

public interface Dao<T> {
	public Connection connection = BddConnection.getConnection();
	public void create(T obj);  // Generic method to insert object of type T
	public void read(int id);  // Generic method to send object of type T
	public void update(T obj);  // Generic method to update object of type T
	public void delete(T obj);  // Generic method to delete object of type T
	public ArrayList<t> readAll();  // Generic method to send all objects of type T
}
//
//The purpose of the DAO pattern is to provide an 
//abstraction layer for accessing data from a database 
//or any other data source