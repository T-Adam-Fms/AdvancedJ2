//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :


package entities;

public class User {
    private int idUser;
    private String login;
    private String password;

    public User(int idUser, String login, String password) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}