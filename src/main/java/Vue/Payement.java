package Vue;

import Controleur.Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payement extends JFrame {
    private JPanel panel1;
    private JTextField cardName;
    private JTextField cardNumber;
    private JTextField valable;
    private JTextField cvcNumber;
    private JLabel montant;
    private JButton validerButton;


    public Payement(int cl_ID ,String prenom, String film, int hor) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 400));
        this.setResizable(false);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();


        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
Fin fin = new Fin(cl_ID, prenom,film, hor);
fin.setVisible(true);
            }
        });
    }
}
