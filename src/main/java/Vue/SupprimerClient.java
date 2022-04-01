package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupprimerClient  extends JFrame {
    private JLabel Nom;
    private JPanel panel1;
    private JLabel Prenom;
    private JLabel Mail;
    private JLabel Login;
    private JLabel Mdp;
    private JLabel Type;
    private JButton retourButton;
    private JButton supprimerButton;

    public SupprimerClient() {

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
                MClient Mcli = new MClient();
                Mcli.setVisible(true);
            }
        });
    }
}
