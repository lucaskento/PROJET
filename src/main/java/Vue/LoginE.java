package Vue;


import Controleur.Employee;
import Modele.Connexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;


public class LoginE extends JFrame {
    private Connexion con = new Connexion();
    private JPanel LoginP;
    private JTextField Champ_log;
    private JTextField Champ_mdp;
    private JButton NV;

    public LoginE() {
        //  super(titre);
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
                 int EmpID;
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `employés`");

                for(int i=0; i< L.size(); i++ )
                {
                    if(L.get(i).get(4).equals(Champ_log.getText())&&L.get(i).get(5).equals(Champ_mdp.getText()))
                    {
                    EmpID = Integer.parseInt(L.get(i).get(0));
                    Prenom = L.get(i).get(1);
                    Nom = L.get(i).get(2);
                    Mail = L.get(i).get(3);
                    Login = L.get(i).get(4);
                    Mdp = L.get(i).get(5);

                    dispose();
                    FilmClient fl_cl=new FilmClient();
                    fl_cl.setVisible(true);

                        }

                }

            }
        });
    }


}
