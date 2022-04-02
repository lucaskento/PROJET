package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifEmp extends JFrame {
    private JPanel panel1;
    private JButton modifierButton;
    private JTextField prix;
    private JButton retourButton;
    private JTextField film;
    private JTextField genre;
    private JTextField duree;
    private JTextField description;
    private JButton afficherButton;
    Connexion con = new Connexion();
    private int ID;

    public ModifEmp() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();


        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MEmp Memp = new MEmp();
                Memp.setVisible(true);
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String query = "UPDATE `films` SET "
                        + "`Titre`='"+film.getText()+"',"
                        + "`Genre`='"+genre.getText()+"',"
                        + "`Prix`='"+prix.getText()+"',"
                        + "`Duree`='"+duree.getText()+"',"
                        + "`Description`='"+description.getText()+"'"
                        + "WHERE ID = " + ID;
                con.doQuery(query);
            }
        });
        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `films`");
                for(int i = 0; i<L.size(); i++)
                {
                    if (film.getText().equals(L.get(i).get(0)))
                    {
                        genre.setText(L.get(i).get(1));
                        prix.setText(L.get(i).get(2));
                        duree.setText(L.get(i).get(3));
                        description.setText(L.get(i).get(4));
                        ID=Integer.parseInt(L.get(i).get(5));


                    }
                }
            }
        });
    }
}
