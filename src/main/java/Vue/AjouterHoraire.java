package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AjouterHoraire extends JFrame
{

    private JPanel panel1;
    private JTextField ID_Film;
    private JTextField Horaire_ajt;
    private JButton OKButton1;
    private JButton retourButton;
    Connexion con = new Connexion();

    AjouterHoraire()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();


        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id ;
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `films`");
                ArrayList<ArrayList<String>> H = con.doQuery("SELECT * FROM `horaire`");
                int ID = 0;
                for (int i = 0; i < H.size(); i++)
                {
                    if ((i != H.size() - 1) && (Integer.parseInt(H.get(i).get(0)) < Integer.parseInt(H.get(i + 1).get(0))))
                    {
                        ID = Integer.parseInt(H.get(i + 1).get(0));
                    }
                }
                ID = ID + 1;

                String query = "INSERT INTO `horaire`(`ID`, `IDFilm`, `Horaire`) VALUES ("
                        +"'" +ID +"',"+
                        "'" + ID_Film.getText() +"',"+
                        "'" +Horaire_ajt.getText()+"')";
                con.doQuery(query);
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MEmp m=new MEmp();
                m.setVisible(true);
            }
        });
    }

}
