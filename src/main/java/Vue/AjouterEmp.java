package Vue;

import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AjouterEmp extends JFrame {
    private JButton ajouterButton;
    private JTextField prix;
    private JTextField film;
    private JTextField genre;
    private JTextField durée;
    private JTextField description;
    private JButton retourButton;
    private JPanel mainPanel;
    private JButton horaireButton;
    Connexion con=new Connexion();

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
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                int id ;
                con.Connecter("cinema");
                ArrayList<ArrayList<String>> L = con.doQuery("SELECT * FROM `films`");
                int ID = 0;
                for (int i = 0; i < L.size(); i++)
                {
                    if ((i != L.size() - 1) && (Integer.parseInt(L.get(i).get(5)) < Integer.parseInt(L.get(i + 1).get(5))))
                    {
                        ID = Integer.parseInt(L.get(i + 1).get(5));
                    }
                }
                ID = ID + 1;
                String erreur="";
                int condition=0;

                if(film.getText().length()<=3)
                    erreur=erreur+"\n Votre titre doit être supérieur à 3 caractères\n";
                else
                    condition=condition+1;
                if(genre.getText().length()<=3)
                    erreur=erreur+"\nVotre genre doit être supérieur à 3 caractères\n";
                else
                    condition=condition+1;
                if(durée.getText().contains("a")||durée.getText().contains("z")||durée.getText().contains("e")||durée.getText().contains("r")||durée.getText().contains("t"))
erreur=erreur+"\nLaduree ne doit contenir que des chiffres\n";
                else
                    condition=condition+1;
                if(prix.getText().contains("a")||prix.getText().contains("z")||prix.getText().contains("e")||prix.getText().contains("r")||prix.getText().contains("t"))
erreur=erreur+"\nVotre prix doit contenir que des chiffres\n";
                else
                    condition=condition+1;
                if(description.getText().length()<=6)
                    erreur=erreur+"\nVotre description doit être supérieur à 3 caractères\n";
                else
                    condition=condition+1;


                if(condition!=5)
                JOptionPane.showMessageDialog(AjouterEmp.this ,erreur,"AJOUT IMPOSSIBLE",JOptionPane.WARNING_MESSAGE);
else
                {//id=Integer.parseInt(L.get(L.size()-1).get(0));
                //id=L.size()+1;//Implementation de l'ID automatiquement
                String query = "INSERT INTO `films`(`Titre`, `Genre`, `Prix`, `Duree`, `Description`, `ID`) VALUES ("
                        +"'" +film.getText() +"',"+
                        "'" +genre.getText() +"',"+
                        "'" +prix.getText()+"'," +
                        "'" +durée.getText() +"',"+
                        "'" +description.getText()+"',"
                            +"'" +ID+"')";
                con.doQuery(query);
            }}
        });
        horaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AjouterHoraire ajt = new AjouterHoraire();
                ajt.setVisible(true);
            }
        });
    }
}
