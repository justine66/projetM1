import java.util.HashMap;

public class Arbre {
    private HashMap<Arbre, String> noeuds;

    /**
     * constructeur
     */
    public Arbre() {
        this.noeuds = new HashMap<>();
    }

    /**
     * permet de recuperer les noeuds
     * @return
     */
    public HashMap<Arbre, String> getNoeuds() {
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
                while (cpt > 0 || a.length() > 0) {
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
                    this.noeuds.put(A, "feuille");
                }
            }
            else if (a.charAt(0) == ')') {
                a = a.replaceFirst("\\)", "");

            }
        }

    }


    public boolean isEmpty() {
        return this.noeuds.isEmpty();
    }

    public String get_appariement (){
        String res = "";
        for (Arbre a : this.noeuds.keySet()){
            if (a.noeuds.values().equals("feuille")){
                res +="-";
            } else {
                res +="(";
                res+= a.get_appariement();
                res +=")";
            }
        }
        return res;
    }
}
