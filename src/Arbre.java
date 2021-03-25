import java.util.ArrayList;

public class Arbre {
    private ArrayList<Arbre> noeuds;

    /**
     * constructeur
     */
    public Arbre (){
        this.noeuds = new ArrayList<Arbre>();
    }

    /**
     * permet de recuperer les noeuds
     */
    public ArrayList<Arbre> getNoeuds() {
        return noeuds;
    }

   /*  il va falloir creer notre propre split je pense
   public void create_arbre (ARN arn){
        String a = arn.getAppariement().split("(");
        for (int i = 0; i< a.length(); i++){

        }
    }*/
}
