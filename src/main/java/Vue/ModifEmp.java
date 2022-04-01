package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifEmp extends JFrame {
    private JPanel panel1;
    private JButton modifierButton;
    private JLabel Film;
    private JLabel Genre;
    private JLabel Duree;
    private JLabel Description;
    private JTextField prixTextField;
    private JButton retourButton;

    public ModifEmp() {

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
    }
}
