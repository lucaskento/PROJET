package Controleur;

public class Clients
{
    private String Nom;
    private String Prenom;
    private String Mail;
    private String Login;
    private String Mdp;
    private int ClientID;
    private String Type;

    public Clients()
    {
        this.ClientID = -1;
        this.Login = "pseudo";
        this.Prenom = "prénom";
        this.Nom = "nom";
        this.Mdp = "password";
        this.Mail = " vide@gmail.com";
        this.Type = "Invite";

    }


    public Clients(String nom, String prenom, String mail, String login, String mdp, int clientID, String type) {
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Login = login;
        Mdp = mdp;
        ClientID = clientID;
        Type = type;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public int getClientID() {
        return ClientID;
    }

    public void setClientID(int clientID) {
        ClientID = clientID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
