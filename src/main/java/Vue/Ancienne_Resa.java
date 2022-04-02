package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ancienne_Resa extends JFrame {
    private JLabel nom_film1;
    private JLabel nom_film2;
    private JLabel nom_film3;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private javax.swing.JPanel JPanel;
    private JButton reroutButton;
    private JLabel nom_film4;
    private JLabel h4;
    private JLabel nom_film5;
    private JLabel h5;
    private JLabel nom_film6;
    private JLabel h6;
    private JLabel nom_film7;
    private JLabel h7;
    private JLabel nom_film8;
    private JLabel h8;
    private JLabel nom_film9;
    private JLabel h9;
    private JLabel nom_film10;
    private JLabel h10;
    private JLabel ID_1;
    private JLabel ID2;
    private JLabel ID_3;
    private JLabel ID_4;
    private JLabel ID5;
    private JLabel ID_6;
    private JLabel ID_7;
    private JLabel ID_8;
    private JLabel ID_9;
    private JLabel ID_10;
    Connexion con = new Connexion();
    ArrayList<ArrayList<String>> E= new ArrayList<ArrayList<String>>();

    public Ancienne_Resa(int cl_ID, int nature, String prenom, String film, int hor) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 400));
        this.setResizable(false);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(JPanel);
        this.pack();
        con.Connecter("cinema");

if(nature==0||nature ==1)
{
    E = con.doQuery("SELECT * FROM reservations WHERE `IDClient`=" + cl_ID);
}
else
        {
            E = con.doQuery("SELECT * FROM reservations");
        }

        ArrayList<ArrayList<String>> R = new ArrayList<ArrayList<String>>();
        R = con.doQuery("SELECT * FROM films");

        ArrayList<ArrayList<String>> K = new ArrayList<ArrayList<String>>();
        K= con.doQuery("SELECT * FROM clients");



for(int h=0;h<R.size();h++) {
    for(int k=0; k<K.size(); k++) {


        if (E.size() >= 1) {
            h1.setText(String.valueOf(E.get(0).get(3)));
            if (R.get(h).get(5).equals(E.get(0).get(2)))
                nom_film1.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(0).get(1)))
            ID_1.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 2) {
            h2.setText(String.valueOf(E.get(1).get(3)));
            if (R.get(h).get(5).equals(E.get(1).get(2)))
                nom_film2.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(1).get(1)))
            ID2.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 3) {
            h3.setText(String.valueOf(E.get(2).get(3)));
            if (R.get(h).get(5).equals(E.get(2).get(2)))
                nom_film3.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(2).get(1)))
            ID_3.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 4) {
            h4.setText(String.valueOf(E.get(3).get(3)));
            if (R.get(h).get(5).equals(E.get(3).get(2)))
                nom_film4.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(3).get(1)))
            ID_4.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 5) {
            h5.setText(String.valueOf(E.get(4).get(3)));
            if (R.get(h).get(5).equals(E.get(4).get(2)))
                nom_film5.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(4).get(1)))
            ID5.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 6) {
            h6.setText(String.valueOf(E.get(5).get(3)));
            if (R.get(h).get(5).equals(E.get(5).get(2)))
                nom_film6.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(5).get(1)))
            ID_6.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 7) {
            h7.setText(String.valueOf(E.get(6).get(3)));
            if (R.get(h).get(5).equals(E.get(6).get(2)))
                nom_film7.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(k).get(1)))
            ID_7.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 8) {
            h8.setText(String.valueOf(E.get(7).get(3)));
            if (R.get(h).get(5).equals(E.get(7).get(2)))
                nom_film8.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(7).get(1)))
            ID_8.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 9) {
            h9.setText(String.valueOf(E.get(8).get(3)));
            if (R.get(h).get(5).equals(E.get(8).get(2)))
                nom_film9.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(8).get(1)))
            ID_9.setText(String.valueOf(K.get(k).get(3)));
        }
        if (E.size() >= 10) {
            h10.setText(String.valueOf(E.get(9).get(3)));
            if (R.get(h).get(5).equals(E.get(9).get(2)))
                nom_film10.setText(R.get(h).get(0));
            if (K.get(k).get(0).equals(E.get(9).get(1)))
            ID_10.setText(String.valueOf(K.get(k).get(3)));
        }
    }

}

        reroutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nature == 0) {
                    dispose();
                    Fin fn = new Fin(cl_ID, prenom, film, hor);
                    fn.setVisible(true);
                }
                if (nature == 1||nature==3) {
                    dispose();
                    MClient mc = new MClient();
                    mc.setVisible(true);

                }
            }
        });
    }


}
