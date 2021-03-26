import java.util.ArrayList;

public class Arbre {
    private ArrayList<Arbre> noeuds;

    /**
     * constructeur
     */
    public Arbre() {
        this.noeuds = new ArrayList<Arbre>();
    }

    /**
     * permet de recuperer les noeuds
     */
    public ArrayList<Arbre> getNoeuds() {
        return noeuds;
    }

    /*  il va falloir creer notre propre split je pense*/
    public void create_arbre(String arn) {
        String a = arn;

        while (a.length() > 0) {

            if (a.charAt(0) == '-') {
                this.noeuds.add(new Arbre());
                a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
            }
            if (a.charAt(0) == '(') {
                int cpt = 1;
                a = a.replaceFirst("(", "");
                String s = "(";
                while (cpt != 0) {
                    if (a.charAt(0) == '(') {
                        s += '(';
                        a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
                        cpt++;
                    }
                    if (a.charAt(0) == ')') {
                        s += ')';
                        a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
                        cpt--;
                    }
                    if (a.charAt(0) == '-') {
                        s += '-';
                        a = a.replaceFirst(String.valueOf(a.charAt(0)), "");
                    }
                }
                Arbre A = new Arbre();
                A.create_arbre(s);
                this.noeuds.add(A);
            }
            if (a.charAt(0) == ')') {
                a = a.replaceFirst(String.valueOf(a.charAt(0)), "");

            }

        }
    }


}
