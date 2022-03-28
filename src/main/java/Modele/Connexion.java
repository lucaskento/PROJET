package Modele;

import java.util.*;
import java.sql.*;
import java.lang.*;

public class Connexion {

    private Connection con = null;
    private Statement stat;

    public Connexion() {
    }

    public void Connecter(String nombdd) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/" + nombdd + "?useUnicode=true\n" +
                    "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&\n" +
                    "serverTimezone=UTC&\n"
                    + "autoReconnect=true&useSSL=false";


            String id = "root";
            String mdp = "";
            con = DriverManager.getConnection(url, id, mdp);
            stat = con.createStatement();

        } catch (Exception e) {
            System.out.println("pb mgl");
            e.printStackTrace();
        }

    }

    public ArrayList<ArrayList<String>> doQuery(String query) {
        ResultSet requete;
        ArrayList<String> temp;
        ArrayList<ArrayList<String>> recupListe = new ArrayList<ArrayList<String>>();

        try {
            requete = stat.executeQuery(query); //On excecute la requete envoyé dans query

            while (requete.next()) //Tant que il y a des lignes a parcourir
            {
                temp = new ArrayList<String>();

                for (int j = 0; j < requete.getMetaData().getColumnCount(); j++) //j egale au nombre de colonnes de la table
                    temp.add(requete.getString(j + 1));

                recupListe.add(temp);

            }
            return recupListe;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
