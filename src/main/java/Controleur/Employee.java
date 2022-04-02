package Controleur;

public class Employee
{
    private String Nom;
    private String Prenom;
    private String Mail;
    private String Login;
    private String Mdp;
    private int EmpID;


    public Employee(String nom, String prenom, String mail, String login, String mdp, int empID) {
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Login = login;
        Mdp = mdp;
        EmpID = empID;
    }
}

