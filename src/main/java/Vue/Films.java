package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Films extends JFrame
{

    private JLabel test;
    private JPanel Jpan;

    private JScrollPane scroll;
    private JLabel AffichageFilms;


    Films()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 400));
        this.setResizable(false);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(Jpan);
        this.setVisible(true);

        AffichageFilms = new JLabel();
        AffichageFilms.setText("eeeeeee");

        scroll = new JScrollPane(AffichageFilms);
        //this.add(scroll, BorderLayout.CENTER);
        this.pack();

        test = new JLabel();
        test.setText("helzs");


    }

}
