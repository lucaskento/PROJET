package Vue;

import Modele.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Page extends JFrame {

    private JPanel mainPanel;
    private JLabel Message1;
    private JButton ClientB;
    private JButton EmployéB;

    private Connexion con = new Connexion();


    public Page() {
        CreationFenetre();
        con.Connecter("cinema");


    }

    void CreationFenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();

        ClientB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Client cl = new Client();
                cl.setVisible(true);

            }
        });
        EmployéB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginE lg = new LoginE();
                lg.setVisible(true);
            }
        });
    }

}
