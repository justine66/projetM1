import javax.swing.*;


import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.WindowFocusListener;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Affichage extends JFrame {
    private JLabel status;
    protected Canvas canvas ;
    private int width = 2;
    private int height = 2;
    private int X = 10;
    private int Y = 10;


    public Affichage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Projet M1 BIBS");
        setSize(500, 250);

        Container conteneur = getContentPane();
        status = new JLabel("test");
        conteneur.add(status, BorderLayout.NORTH);
        canvas = new Canvas();
        conteneur.add(canvas, BorderLayout.CENTER);

    }

    public void paint (Graphics g , Arbre arbre, int x , int y) {
        super.paint(g);
        g.setColor(Color.BLACK);

        for (Arbre a : arbre.getNoeuds()) {
           if (a.isEmpty()){
               g.fillOval(x, y, width, height);
           } else{
               g.fillOval(x, y, width, height);
               g.drawLine(x, y, x+10,y+5);
               paint(g, a, x+10, y+5 );
               y+= 5;
           }
        }
    }
    /*public void draw_arbre (Graphics g , Arbre arbre) {
        draw_arbre(g, arbre, this.X, this.Y);
    }*/


    }
