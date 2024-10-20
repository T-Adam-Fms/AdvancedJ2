//Exercice 5 : LE CODE DEVIENT ILLISIBLE, N’EST-CE PAS ?
//Reprenons donc nos bonnes habitudes et découpons notre appli à l’aide des packages :
//5.1 Ajouter le package fr.fms.entities et ajoutez-y la classe Article
//5.2 Ajouter le package fr.fms.dao qui va faire le lien entre notre application et la base de 
//données, ajoutez-y l’interface générique Dao (ci-dessous) contenant les méthodes dites 
//CRUD pour Create, Read, Update et Delete, puis ajouter la classe ArticleDao qui
//implémente l’interface générique Dao : public class ArticleDao implements Dao<Article>

package entities;

public class Article {
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
<<<<<<< HEAD

=======
>>>>>>> 37b2420 (ex7)
