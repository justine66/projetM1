import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class test  {
    public static void draw(){
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(400, 400);

        Canvas cnvs = new Canvas();
        cnvs.setSize(200, 200);


        frmMain.add(cnvs);
        frmMain.setVisible(true);

        Graphics g = cnvs.getGraphics();
        g.fillOval(100, 100, 10, 10);
        g.drawLine(10,10, 100, 100);
    }

    public static void main(String[] args) {
        ARN arn1 = new ARN("AAUU", "(())");
        ARN arn2 = new ARN("AAAU", "(--)");
        ARN arn3 = new ARN("AAAU", "-(-)");

        Arbre A1 = new Arbre();
        A1.create_arbre(arn1.getAppariement());
        Arbre A2 = new Arbre();
        A2.create_arbre(arn2.getAppariement());
        Arbre A3 = new Arbre();
        A3.create_arbre(arn3.getAppariement());
        //System.out.println(A3.getNoeuds());
        Affichage a = new Affichage();
       // a.setVisible(true);


        test.draw();




        /* test de la methode is_appiered(a)*/
        System.out.println(arn1.is_appiered(arn2.getAppariement()));
        System.out.println(arn1.is_appiered(arn1.getAppariement()));

        /* test de la methode is_appiered(a, s)*/
        System.out.println(arn1.is_appiered(arn2.getAppariement(), arn2.getSequence()));
        System.out.println(arn1.is_appiered(arn1.getAppariement(), arn1.getSequence()));

    }
}
