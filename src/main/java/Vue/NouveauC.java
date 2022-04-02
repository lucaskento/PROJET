package Vue;


import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NouveauC extends JFrame {
    private JTextField Champ_prenom;
    private JTextField Champ_nom;
    private JTextField Champ_type;
    private JTextField Champ_mail;
    private JTextField Champ_login;
    private JPasswordField Champ_mdp;
    private JPanel CompteP;
    private JButton Creation;
    private JComboBox comboBox1;
    Connexion con = new Connexion();

    public NouveauC() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 400));
        this.setResizable(false);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(CompteP);
        this.pack();


        Creation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int condition=0;
                String erreur ="";
                if(Champ_prenom.getText().length()<=2)
                    erreur=erreur+"\nPrenom doit être suppérieur à 2 caractères\n";
                else
                    condition=condition+1;
                if(Champ_nom.getText().length()<=2)
                    erreur=erreur+"\nNom doit être supérieur à 2 caractères\n";
                else
                    condition=condition+1;
                if(Champ_mail.getText().contains(".")&&Champ_mail.getText().contains("@"))
                    condition=condition+1;
                else
                    erreur=erreur+"\nL'email doit contenir un @ et un point\n";
                if(Champ_login.getText().length()<=2)
                    erreur=erreur+"\nL'identifiant doit contenir au moins 2 caractère\n";
                else
                    condition=condition+1;
                if(Champ_mdp.getText().length()<=2)
                    erreur=erreur+"\nLe mdp doit contenir au moins 2 caractère\n";
                else
                    condition=condition+1;



                if(condition!=5)
                    JOptionPane.showMessageDialog(NouveauC.this ,erreur,"CREATION IMPOSSIBLE",JOptionPane.WARNING_MESSAGE);

else {
                    con.Connecter("cinema");
                    ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `clients`");
                    int ID = 0;
                    for (int i = 0; i < L.size(); i++) {
                        if ((i != L.size() - 1) && (Integer.parseInt(L.get(i).get(0)) < Integer.parseInt(L.get(i + 1).get(0)))) {
                            ID = Integer.parseInt(L.get(i + 1).get(0));
                        }
                    }
                    ID = ID + 1;
                    String query = "INSERT INTO `clients`(`ID`, `Prenom`, `Nom`, `Login`, `Mdp`, `Type`, `Email`) VALUES ("
                            + "'" + ID + "'," +
                            "'" + Champ_prenom.getText() + "'," +
                            "'" + Champ_nom.getText() + "'," +
                            "'" + Champ_login.getText() + "'," +
                            "'" + String.valueOf(Champ_mdp.getPassword()) + "'," +
                            "'" + comboBox1.getSelectedItem().toString() + "'," +
                            "'" + Champ_mail.getText() + "')";
                    con.doQuery(query);//Execute la commande et ajoute à notre table la requete!
                    dispose();
                    Client cl = new Client();
                    cl.setVisible(true);
                }
            }
        });
    }


}

