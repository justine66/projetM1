import javax.swing.*;


import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Affichage extends JFrame implements ActionListener{
    private JLabel status;
    protected Canvas canvas ;

    protected Container conteneur;
    private JButton button1;


    public Affichage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Projet M1 BIBS");
        setSize(500, 250);

        conteneur = getContentPane();
        status = new JLabel("test");
        conteneur.add(status, BorderLayout.NORTH);


        ActionListener tictac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                status.setText("action performed");
            }
        };

        button1 = new JButton("dessiner l'arbre");
        conteneur.add(button1, BorderLayout.EAST);
        button1.addActionListener(this);


    }
    public void setCanvas (Canvas cnv ){
        this.canvas = cnv;
        //conteneur.update(this.getGraphics());
    }
    public void addPanel(Component c){
        this.conteneur.add(c);
    }


    public void actionPerformed(ActionEvent e) {

        /*ARN arn1 = new ARN("AAUU", "----");
        Arbre A1 = new Arbre();
        A1.create_arbre(arn1.getAppariement());
        Worker worker = new Worker();
        worker.execute();*/
    }


}
