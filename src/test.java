import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;

import com.mxgraph.view.mxGraph;


public class test  {

    public static void main(String[] args) {
        ARN arn1 = new ARN("AAUU", "(())");
        ARN arn2 = new ARN("AAAU", "(--)");
        ARN arn3 = new ARN("AAAU", "-(-)");

        /* test de la methode is_appiered(a)*/
        System.out.println("test de la methode is_appiered(a)");
        System.out.println(arn1.is_appiered(arn2.getAppariement()));
        System.out.println(arn1.is_appiered(arn1.getAppariement()));

        /* test de la methode is_appiered(a, s)*/
        System.out.println("test de la methode is_appiered(a, s)");
        System.out.println(arn1.is_appiered(arn2.getAppariement(), arn2.getSequence()));
        System.out.println(arn1.is_appiered(arn1.getAppariement(), arn1.getSequence()));

        /* test de la creation d'arbre */
        System.out.println("test creation arbre");
        Arbre A1 = new Arbre();
        A1.create_arbre(arn1.getAppariement());
        Arbre A2 = new Arbre();
        A2.create_arbre(arn2.getAppariement());
        Arbre A3 = new Arbre();
        A3.create_arbre(arn3.getAppariement());

        /* test de la recuperation de l'appariement a partir d'un arbre */
        System.out.println("test recuperation appariement a partir d'un arbre");
        System.out.println(arn1.is_appiered(A1.get_appariement()));
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


        /* test du parser*/
        System.out.println("test parser");
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
