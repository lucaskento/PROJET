package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MEmp extends JFrame {
   private JButton modifierUnFilmButton;
    private JButton ajouterUnFilmButton;
    private JButton supprimerUnFilmButton;
    private JButton retourButton;
    private JPanel mainPanel;
    private JButton ajouterUnHoraireButton;

    public MEmp() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();

        modifierUnFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                ModifEmp memp = new ModifEmp();
                memp.setVisible(true);
            }
        });

        ajouterUnFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                AjouterEmp aemp = new AjouterEmp();
                aemp.setVisible(true);
            }
        });

        supprimerUnFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                SupEmp semp = new SupEmp();
                semp.setVisible(true);
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                FilmClient fcl = new FilmClient();
                fcl.setVisible(true);
            }
        });
        ajouterUnHoraireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterHoraire a = new AjouterHoraire();
                a.setVisible(true);
            }
        });
    }
}
