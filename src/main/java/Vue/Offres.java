package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Offres extends JFrame{
    private JPanel mainPanel;
    private JTextField nom_offre;
    private JTextField remise;
    private JButton OKButton;
    private JButton retourButton;
    Connexion con = new Connexion();

    public Offres() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID =0;
                String des="";
con.Connecter("cinema");
                        ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `offre`");
                for(int i=0; i<L.size(); i++)
                {
                    if(L.get(i).get(1).equals(nom_offre.getText()))
                    {
                        ID=Integer.parseInt(L.get(i).get(0));
                        des=L.get(i).get(3);
                    }
                }



                String query = "UPDATE `offre` SET "
                        + "`ID`='"+ID+"',"
                        + "`Type`='"+nom_offre.getText()+"',"
                        + "`Remise`='"+ remise.getText()+"',"
                        + "`Description`='"+des+"'"
                        + "WHERE ID = " +ID;
System.out.print(query);
                con.doQuery(query);

            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

