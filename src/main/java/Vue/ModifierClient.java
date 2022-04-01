package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierClient extends JFrame {
    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField mailTextField;
    private JTextField motDePasseTextField;
    private JTextField typeTextField;
    private JButton retourButton;
    private JButton modifierButton;
    private JPanel panel1;
    private JTextField loginTextField1;

    public ModifierClient() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();

        });

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
