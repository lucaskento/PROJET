package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MClient extends JFrame {
    private JButton modifierButton;
    private JButton supprimerButton;
    private JPanel mainPanel;
    private JButton voirTouteLesReservationsButton;
    private JButton voirLesReservationsButton;
    private JTextField recup_client;

    public MClient() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ModifierClient Modiclient = new ModifierClient();
                Modiclient.setVisible(true);
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SupprimerClient Suppcli = new SupprimerClient();
                Suppcli.setVisible(true);
            }
        });
        voirLesReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Ancienne_Resa rs = new Ancienne_Resa(Integer.parseInt(recup_client.getText()), 1, "a", "b", 2);
                rs.setVisible(true);
            }
        });
        voirTouteLesReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Ancienne_Resa rsa = new Ancienne_Resa(0, 3, "b", "c", 1);
                rsa.setVisible(true);
            }
        });
    }
}
