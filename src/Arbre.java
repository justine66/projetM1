
import java.util.*;

public class Arbre  {
    private LinkedHashMap<Arbre, String> noeuds;

    /**
     * constructeur
     */
    public Arbre() {
        this.noeuds = new LinkedHashMap<Arbre, String>();

    }

    /**
     * permet de recuperer les noeuds
     * @return
     */
    public LinkedHashMap<Arbre, String> getNoeuds() {
        return noeuds;
    }

    /**
     *  creation de notre arbre a partir de l'appariement
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


    public boolean isEmpty() {
        return this.noeuds.isEmpty();
    }

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

    public void affiche_arbre(){


        for (Arbre arbre : this.noeuds.keySet()){
            if (this.noeuds.get(arbre).equals("feuilles")) {
                System.out.print(this.noeuds.get(arbre));
            } else {
                //System.out.print("test");
                System.out.println(this.noeuds.get(arbre));
                arbre.affiche_arbre();
                System.out.println("fin sous-arbre");
            }
        }
    }


}
