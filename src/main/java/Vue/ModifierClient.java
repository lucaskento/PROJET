package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifierClient extends JFrame {
    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField mailTextField;
    private JTextField motDePasseTextField;
    private JTextField typeTextField;
    private JButton retourButton;
    private JButton modifierButton;
    private JPanel panel1;
    private JTextField loginTextField;
    private JButton afficherButton;
    Connexion con = new Connexion();
    private int ID;

    public ModifierClient() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));
        this.setResizable(false);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MClient retour = new MClient();
                retour.setVisible(true);
            }
        });
        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `clients`");
                for(int i = 0; i<L.size(); i++)
                {
                    if (loginTextField.getText().equals(L.get(i).get(3)))
                    {
                        prenomTextField.setText(L.get(i).get(1));
                        nomTextField.setText(L.get(i).get(2));
                        motDePasseTextField.setText(L.get(i).get(4));
                        typeTextField.setText(L.get(i).get(5));
                        mailTextField.setText(L.get(i).get(6));
                        ID=Integer.parseInt(L.get(i).get(0));

                    }
                }
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String query = "UPDATE `clients` SET "
                        + "`ID`='"+ID+"',"
                        + "`Prenom`='"+prenomTextField.getText()+"',"
                        + "`Nom`='"+ nomTextField.getText()+"',"
                        + "`Login`='"+loginTextField.getText()+"',"
                        + "`Mdp`='"+motDePasseTextField.getText()+"',"
                        + "`Type`='"+typeTextField.getText()+"',"
                        + "`Email`='"+mailTextField.getText()+"'"
                        + "WHERE ID = " + ID;
                System.out.println(query);
                        con.doQuery(query);
            }
        });
    }


    }

