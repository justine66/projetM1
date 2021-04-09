
import java.util.*;

public class Arbre  {
    private LinkedHashMap<Arbre, String> noeuds;

    /**
     * constructeur
     */
    public Arbre() {
        this.noeuds = new LinkedHashMap<Arbre, String>();

    }


    public LinkedHashMap<Arbre, String> getNoeuds() {
        return noeuds;
    }

    /**
     *  creation de notre arbre à partir de l'appariement
     */
    public void create_arbre(String arn) {
        String a = arn;
        while (a.length() > 0) {
            if (a.charAt(0) == '-') {
                this.noeuds.put(new Arbre(), "feuille");
                a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
            }
            else if (a.charAt(0) == '(') {
                int cpt = 1;
                a = a.replaceFirst("\\(", "");
                String s = "";
                while (cpt != 0 ) {
                    if (a.charAt(0) == '(') {
                        s += '(';
                        a = a.replaceFirst("\\(", "");
                        cpt++;
                    }
                    else if (a.charAt(0) == ')') {
                        cpt--;
                        if (cpt != 0) {
                            s += ')';
                        }
                        a = a.replaceFirst("\\)", "");
                    }
                    else if (a.charAt(0) == '-') {
                        s += '-';
                        a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
                    }

                }
                Arbre A = new Arbre();
                if (s.equals("")){
                    this.noeuds.put(A,"sous-arbre");
                }else {
                    A.create_arbre(s);
                    this.noeuds.put(A, "sous-arbre");
                }
            }
            else if (a.charAt(0) == ')') {
                a = a.replaceFirst("\\)", "");
                System.out.println("a : " + a);


            }


        }

    }

    /**
     * test si l'arbre est vide
     * @return true si l'arbre est vide
     */
    public boolean isEmpty() {
        return this.noeuds.isEmpty();
    }

    /**
     * recupère l'appariement à partir de l'arbre
     * @return un string correspondant à l'appariement
     */
    public String get_appariement (){
        String res = "";
        for (Arbre a : this.noeuds.keySet()){
            if (this.noeuds.get(a).equals("feuille")) {
                res += "-";
            } else {
                res += "(";
                res += a.get_appariement();
                res += ")";
            }
        }
        return res;
    }

    /**
     * affiche les noeuds de l'arbre dans la console (n'affiche pas les sous-arbres)
     */
    public void affiche_arbre(){
        Iterator iterator = this.noeuds.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry mapentry = (HashMap.Entry) iterator.next();
            System.out.print(mapentry.getValue() + " | ");
        }
        System.out.println("");
    }

    /*public Arbre plus_grand_sous_arbre(Arbre arbre){
        Arbre arbre = new Arbre();

        for (int i = 0; i< min(this.))
        return arbre;
    }*/

}
