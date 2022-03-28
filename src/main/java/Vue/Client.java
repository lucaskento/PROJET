package Vue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Client extends JFrame {
    private JPanel ClientP;
    private JButton InviteB;
    private JButton MembreB;

    public Client() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(ClientP);
        this.pack();

        MembreB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginC lg = new LoginC();
                lg.setVisible(true);
            }
        });
        InviteB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Films fl = new Films();
                fl.setVisible(true);
            }
        });
    }
}
