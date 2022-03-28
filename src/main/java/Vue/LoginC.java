package Vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class LoginC extends JFrame {
    private JPanel LoginP;
    private JTextField Login;
    private JTextField Mdp;
    private JButton NV;

    public LoginC() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);

        this.setContentPane(LoginP);
        this.pack();
        NV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose();

            }
        });
    }


}
