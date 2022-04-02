package Vue;

import Controleur.SSLEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fin extends JFrame{
    private JPanel panel1;
    private JButton retourAuMenuButton;
    private JButton iciButton;
    private JTextField mail;

    public Fin(int cl_ID, String prenom, String film, int hor) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 200));
        this.setResizable(false);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.pack();


        retourAuMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String contenu = "oui";
                contenu = "Bonjour "+prenom+" nous vous remercions pour votre commande et vous souhaitons bon visionnage de "+film+" à "+hor+"h";
                System.out.println(contenu);
                System.out.println(mail.getText());
                SSLEmail confirm=new SSLEmail(mail.getText(), contenu);
                System.out.println("email envoyé");
                dispose();
                Page accueil = new Page();
                accueil.setVisible(true);
            }
        });

            iciButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (cl_ID==0){}
                        else{
                    dispose();
                    Ancienne_Resa an = new Ancienne_Resa(cl_ID, 0, prenom, film, hor);
                    an.setVisible(true);
                            }
                }
            });


    }
}
