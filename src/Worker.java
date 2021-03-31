import javax.swing.*;
import java.awt.*;

public class Worker extends SwingWorker<Void, Void> {
    protected MyCanvas canvas ;
    private Container conteneur;
    private Arbre arbre;



    public Worker( Container container, Arbre arbre){
        this.canvas = new MyCanvas(arbre);
        this.conteneur = container;
        this.arbre = arbre;

    }
    @Override
    protected Void doInBackground() throws Exception {



        return null;
    }


    public void process(){
        //double rand = random.get(random.size()-1);

    }
    public void done (){
        conteneur.add(canvas, BorderLayout.CENTER);
    }
}

