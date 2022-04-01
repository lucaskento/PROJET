package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterEmp extends JFrame {
    private JButton ajouterButton;
    private JTextField prixTextField;
    private JTextField filmTextField;
    private JTextField genreTextField;
    private JTextField duréeTextField;
    private JTextField descriptionTextField;
    private JButton retourButton;

    public AjouterEmp()  {

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
