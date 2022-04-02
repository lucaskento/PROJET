package Vue;

import Modele.Connexion;
import Controleur.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;


public class LoginC extends JFrame {
    private JPanel LoginP;
    private JTextField Champ_lg;
    private JTextField Champ_mdp;
    private JButton NV;
    private Connexion con = new Connexion();

    public LoginC() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);

        this.setContentPane(LoginP);
        this.pack();
        NV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose();
                String Nom;
                String Prenom;
                String Mail;
                String Login;
                String Mdp;
                String Type;
                int ClientID;
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `clients`");

                for (int i = 0; i < L.size(); i++) {
                    if (L.get(i).get(3).equals(Champ_lg.getText()) && L.get(i).get(4).equals(Champ_mdp.getText())) {
                        ClientID = Integer.parseInt(L.get(i).get(0));
                        Prenom = L.get(i).get(1);
                        Nom = L.get(i).get(2);
                        Mail = L.get(i).get(6);
                        Login = L.get(i).get(3);
                        Mdp = L.get(i).get(4);
                        Type = L.get(i).get(5);

                        dispose();
                        Films fl = new Films(new Clients (Nom, Prenom, Mail, Login, Mdp, ClientID, Type) );
                        fl.setVisible(true);
                    }

                }
            }
        });
    }


}

