import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import com.mxgraph.view.mxGraph;


public class test  {

    public static void main(String[] args) {
        /* test creation arn */
        System.out.println("test creation arn");
        ARN arn1 = new ARN("AAUU", "-(((--)-))");
        ARN arn2 = new ARN("AAU", "-(((---)))");
        ARN arn3 = new ARN("AAAU", "-(-)");
        ARN arn4 = new ARN("AAAU", "-(-())--");

        /* test de la methode is_appiered(a)*/
        System.out.println("\ntest de la methode is_appiered(a)");
        System.out.println(arn1.is_appiered(arn2.getAppariement()));
        System.out.println(arn1.is_appiered(arn1.getAppariement()));

        /* test de la methode is_appiered(arn)*/
        System.out.println("\ntest de la methode is_appiered(arn)");
        System.out.println(arn1.is_appiered(arn2));
        System.out.println(arn1.is_appiered(arn1));

        /* test de la methode is_motif(a)*/
        System.out.println("\ntest de la methode is_motif(a)");
        System.out.println(arn1.is_motif("-----()()"));
        System.out.println(arn1.is_motif("--(())--(-(--))"));

        /* test de la methode is_motif(arn)*/
        System.out.println("\ntest de la methode is_motif(arn)");
        System.out.println(arn3.is_motif(arn4));
        System.out.println(arn2.is_motif(arn3));

        /* test de la methode plusgrandsousarbre(arn)*/
        System.out.println("\ntest de la methode plusgrand sousarbre(arn)");
        System.out.println(arn1.plus_grand_sous_arbre(arn2));

        /* test de la creation d'arbre */
        System.out.println("\ntest creation arbre");
        Arbre A1 = new Arbre();
        A1.create_arbre(arn1.getAppariement());
        Arbre A2 = new Arbre();
        A2.create_arbre(arn2.getAppariement());
        Arbre A3 = new Arbre();
        A3.create_arbre(arn3.getAppariement());
        Arbre A4 = new Arbre();
        A4.create_arbre(arn4.getAppariement());

        /* test de la recuperation de l'appariement à partir d'un arbre */
        System.out.println("\ntest recuperation appariement a partir d'un arbre");
        System.out.println(arn1.is_appiered(A1.get_appariement()));
        System.out.print("arn1 :");
        System.out.println(arn1.getAppariement());
        System.out.print("A1 :");
        System.out.println(A1.get_appariement());
        System.out.println(arn2.is_appiered(A2.get_appariement()));
        System.out.print("arn2 :");
        System.out.println(arn2.getAppariement());
        System.out.print("A2 :");
        System.out.println(A2.get_appariement());
        System.out.println(arn3.is_appiered(A3.get_appariement()));
        System.out.print("arn3 :");
        System.out.println(arn3.getAppariement());
        System.out.print("A3 :");
        System.out.println(A3.get_appariement());
        System.out.println(arn4.is_appiered(A4.get_appariement()));
        System.out.print("arn4 :");
        System.out.println(arn4.getAppariement());
        System.out.print("A4 :");
        System.out.println(A4.get_appariement());

        /* test affichage arbre*/
        System.out.println("\ntest affichage arbre");
        System.out.println("A4 :");
        A4.affiche_arbre();

        /* test plus grand sous-arbre commun
        System.out.println("\ntest plus grand sous-arbre commun");
        Arbre a = arn2.plus_grand_sous_arbre(arn3);
        a.affiche_arbre();
        Arbre a2 = arn1.plus_grand_sous_arbre(arn3);
        a2.affiche_arbre();*/

        /* test du parser*/
        System.out.println("\ntest parser");
        File F = new File("./Stockholm.txt");
        Parser P = new Parser(F);
        System.out.println(P.string); //on teste pour savoir si ya une tabulation ou un espace avant le string que l'on cherche

        /* test de JgraphX */
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
            graph.insertEdge(parent, null, "Edge", v1, v2);
        } finally {
            graph.getModel().endUpdate();
        }

    }
}
