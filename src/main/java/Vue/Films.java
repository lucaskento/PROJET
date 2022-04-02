package Vue;

import Controleur.Clients;
import Controleur.Film;
import Modele.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Films extends JFrame
{
    private JLabel test;
    private JPanel Jpan;
    private JButton validerButton;
    private JLabel Film1;
    private JLabel Genre1;
    private JLabel Prix1;
    private JLabel Description1;
    private JLabel Duree1;

    private JComboBox comboBox1;
    private JButton voirButton;
    Connexion con = new Connexion();


    Films(Clients cl)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setResizable(false);
        this.setSize(1200, 600);
        this.setLocationRelativeTo(null);
        this.setContentPane(Jpan);
        this.setVisible(true);
        this.pack();

        con.Connecter("cinema");
        ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `films`");

        for(int h=0; h<L.size(); h++)
            comboBox1.addItem(L.get(h).get(0));

        Film1.setText(L.get(0).get(0));
        Genre1.setText(L.get(0).get(1));
        Prix1.setText(L.get(0).get(2));
        Duree1.setText(L.get(0).get(3));
        Description1.setText(L.get(0).get(4));


        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Film film_choisi = new Film("a", "b", 0, 0, "c", 0);
                ArrayList<ArrayList<String>> C = con.doQuery("SELECT * FROM `films`");
                System.out.println("a");
                for (int i=0; i<C.size();i++)
                {
                    if(C.get(i).get(0).equals(comboBox1.getSelectedItem().toString()))
                    {
                        System.out.println("b");
                        film_choisi.setTitre(C.get(i).get(0));
                        film_choisi.setGenre(C.get(i).get(1));
                        film_choisi.setPrix(Integer.parseInt(C.get(i).get(2)));
                        film_choisi.setDuree(Integer.parseInt(C.get(i).get(3)));
                        film_choisi.setSynopsis(C.get(i).get(4));
                        film_choisi.setFilmID(Integer.parseInt(C.get(i).get(5)));
                        dispose();
                        Basket bsk = new Basket(new Film(film_choisi.getTitre(), film_choisi.getSynopsis(), film_choisi.getPrix(), film_choisi.getDuree(), film_choisi.getGenre(), film_choisi.getFilmID()), cl.getType(), cl.getClientID() );
                        bsk.setVisible(true);
                    }}

            }
        });


        voirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i< L.size(); i++ )
                {
                    if(comboBox1.getSelectedItem().toString().equals(L.get(i).get(0)))
                    {
                        Film1.setText(L.get(i).get(0));
                        Genre1.setText(L.get(i).get(1));
                        Prix1.setText(L.get(i).get(2));
                        Duree1.setText(L.get(i).get(3));
                        Description1.setText(L.get(i).get(4));
                    }

                }
            }
        });
    }
}
