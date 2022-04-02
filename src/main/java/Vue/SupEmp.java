package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupEmp extends JFrame {
    private JButton supprimerButton;
    private JButton retourButton;
    private JLabel Film;
    private JPanel mainPanel;
    private JTextField film_supp;
    Connexion con = new Connexion();

    public SupEmp() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MEmp Memp = new MEmp();
                Memp.setVisible(true);
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `films`");


                for (int i = 0; i < L.size(); i++) {
                    if (film_supp.getText().equals(L.get(i).get(5)))
                    {
                    String query = "DELETE FROM `films` WHERE `ID`="+L.get(i).get(5);
                    String query2= "DELETE FROM `horaire` WHERE `IDFilm`="+L.get(i).get(5);
                    con.doQuery(query);
                    con.doQuery(query2);
                    }
                }

            }
        });
    }
}

