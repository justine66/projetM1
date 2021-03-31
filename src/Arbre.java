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
        String a = (String) arn;
        while (a.length() > 0) {
            if (a.charAt(0) == '-') {
                this.noeuds.add(new Arbre());
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
                    this.noeuds.add(A);
                }else {
                    A.create_arbre(s);
                    this.noeuds.add(A);
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
}
