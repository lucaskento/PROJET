package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupprimerClient  extends JFrame {
    private JPanel panel1;
    private JButton retourButton;
    private JButton supprimerButton;
    private JTextField ID_client;
    Connexion con = new Connexion();

    public SupprimerClient() {

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
                MClient Mcli = new MClient();
                Mcli.setVisible(true);
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `clients`");
                for (int i = 0; i < L.size(); i++) {
                    if (ID_client.getText().equals(L.get(i).get(0)))
                    {
                        String query = "DELETE FROM `clients` WHERE `ID`="+L.get(i).get(0);
                        con.doQuery(query);
                    }
                }
            }
        });
    }
}
