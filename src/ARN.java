
public class ARN extends Affichage{
    private String sequence;
    private String appariement;

    /**
     * constructeur
     * @param a appariement des bases
     * @param s sequence de l'ARN
     **/
    public ARN(String s, String a){
        this.appariement = a;
        this.sequence = s;
    }


    public String getAppariement() {
        return appariement;
    }

    public String getSequence() {
        return sequence;
    }

    /**
     * verifie si this a le meme appariement que l'autre ARN
     * @param a appariement de l'autre ARN
     * @return vrai si meme appariement
     */
    public boolean is_appiered(String a){
        return this.appariement.equals(a);
    }

    /*equivalent à la methode is_appiered mais pouvoir utilisé .equals (conseil du prof)*/
    public boolean equals (String a){return is_appiered(a);}

    /**
     * verifie si this a le meme appariement et la meme sequence que l'autre ARN
     * @param a appariement de l'autre ARN
     * @param s sequence de l'autre ARN
     * @return vrai si les sequences et les appariements sont les memes
     */
    public boolean is_appiered(String a, String s){
        return this.appariement.equals(a) && this.sequence.equals(s);
    }

    /*equivalent a la methode is_appiered mais pouvoir utilisé .equals (conseil du prof)*/
    public boolean equals (String a, String s) { return is_appiered(a, s); }

    /**
     * affichage de l'appariement
     */
    public void affiche_a(){

    }

    /**
     * affichage de la sequence
     */
    public void affiche_s(){

    }

    /**
     * affichage de l'arbre associé
     */
    public void affiche_arbre(){

    }
}
