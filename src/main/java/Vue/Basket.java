package Vue;

import Controleur.Film;
import Controleur.Horaire;
import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Basket extends JFrame{
    private JButton Paiement;
    private JLabel FilmChoisi;
    private JLabel PrixFinal;
    private JPanel BasketP;
    private JTextField nb_tickets;
    private JButton refreshLePrixTotalButton;
    private JLabel Horaire1;
    private JLabel Horaire2;
    private JLabel Horaire4;
    private JLabel Horaire3;
    private JTextField horaire_choisi;
    private JLabel heure;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private int prix_final;
    private int C_ID;
    private int hor;
    private String nb;
    Connexion con = new Connexion();

    public Basket(Film fl, String type, int client_ID)  {
        System.out.println("arrive à basket");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 400));
        this.setResizable(false);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(BasketP);
        this.pack();


        con.Connecter("cinema");
        ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `offre`");

        for(int i=0; i< L.size(); i++ )
        {
            System.out.println("parcours des offres");

            if(L.get(i).get(1).equals(type))
            {
                System.out.println("recup le prix de l'offre");

                prix_final=Integer.parseInt(L.get(i).get(2));
            }
        }
        FilmChoisi.setText(fl.getTitre());
        nb=comboBox1.getSelectedItem().toString();
                //nb_tickets.getText();
        PrixFinal.setText(String.valueOf((fl.getPrix()- prix_final)*Integer.parseInt(nb)));

        con.Connecter("cinema");
        ArrayList<ArrayList<String>> B = con.doQuery("SELECT * FROM `horaire`");
        ArrayList<Integer> I = new ArrayList<Integer>();

        for(int i=0; i< B.size(); i++ )
        {
            if(B.get(i).get(1).equals(String.valueOf(fl.getFilmID())))
            {
                // System.out.println("passage");
                I.add(Integer.parseInt(B.get(i).get(2)));
                //System.out.println(B.get(i).get(2));
            }
        }
        switch (I.size()) {
            case 1:
                Horaire1.setText(String.valueOf(I.get(0)));
                comboBox2.addItem(String.valueOf(I.get(0)));
                break;
            case 2:
                Horaire1.setText(String.valueOf(I.get(0)));
                Horaire2.setText(String.valueOf(I.get(1)));
                comboBox2.addItem(String.valueOf(I.get(0)));
                comboBox2.addItem(String.valueOf(I.get(1)));

                break;
            case 3:
                Horaire1.setText(String.valueOf(I.get(0)));
                Horaire2.setText(String.valueOf(I.get(1)));
                Horaire3.setText(String.valueOf(I.get(2)));
                comboBox2.addItem(String.valueOf(I.get(0)));
                comboBox2.addItem(String.valueOf(I.get(1)));
                comboBox2.addItem(String.valueOf(I.get(2)));
                break;
            case 4:
                Horaire1.setText(String.valueOf(I.get(0)));
                Horaire2.setText(String.valueOf(I.get(1)));
                Horaire3.setText(String.valueOf(I.get(2)));
                Horaire4.setText(String.valueOf(I.get(3)));
                comboBox2.addItem(String.valueOf(I.get(0)));
                comboBox2.addItem(String.valueOf(I.get(1)));
                comboBox2.addItem(String.valueOf(I.get(3)));
                break;
        }
        Paiement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Horaire hr = new Horaire();

                hor = Integer.parseInt(comboBox2.getSelectedItem().toString());
                String prenom="oui";
                ArrayList<ArrayList<String>> A = con.doQuery("SELECT * FROM `clients`");

                for(int i=0; i<A.size(); i++ )
                {
                    if(A.get(i).get(0).equals(String.valueOf(client_ID)))
                    {
                        C_ID=client_ID;
                        prenom = A.get(i).get(1);
                    }
                }


                ArrayList<ArrayList<String>> C = con.doQuery("SELECT * FROM `reservations`");
                int ID = 0;
                for (int i = 0; i < C.size(); i++)
                {
                    if ((i != C.size() - 1) && (Integer.parseInt(C.get(i).get(0)) < Integer.parseInt(C.get(i + 1).get(0))))
                    {
                        ID = Integer.parseInt(C.get(i + 1).get(0));
                    }
                }
                ID = ID + 1;
                //Reservations resa = new Reservations(0, C_ID, fl.getFilmID(), hor, Integer.parseInt(nb_tickets.getText()));
                 String query = "INSERT INTO `reservations`(`ID`, `IDClient`, `IDFilm`, `Heure`, `NbTicket`) VALUES ("
                        +"'" + ID +"',"+
                        "'" +C_ID+"',"+
                        "'" +fl.getFilmID() +"',"+
                        "'" +hor+"'," +
                        "'"+nb+"')";
                con.doQuery(query);//Execute la commande et ajoute à notre table la requete!
                dispose();
                Payement pyt= new Payement(C_ID, prenom, fl.getTitre(), hor);
                pyt.setVisible(true);
            }
        });
        refreshLePrixTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nb=comboBox1.getSelectedItem().toString();
                PrixFinal.setText(String.valueOf((fl.getPrix()- prix_final)*Integer.parseInt(nb)));
            }
        });
    }
}
