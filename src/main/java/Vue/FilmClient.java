package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmClient extends JFrame  {
    private JButton modifierFilmButton;
    private JPanel panel1;
    private JButton modifierClientButton;
    private JButton modifierOffresButton;

    public FilmClient() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();

        modifierFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MEmp Memp = new MEmp();
                Memp.setVisible(true);
            }
        });
        modifierClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MClient Mcli = new MClient();
                Mcli.setVisible(true);
            }
        });
        modifierOffresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {dispose();
Offres of = new Offres();
of.setVisible(true);
            }
        });

    }
}
