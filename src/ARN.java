
public class ARN {
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

    /**
     * verifie si this a le meme appariement et la meme sequence que l'autre ARN
     * @param a appariement de l'autre ARN
     * @param s sequence de l'autre ARN
     * @return vrai si
     */
    public boolean is_appiered(String a, String s){
        return this.appariement.equals(a) && this.sequence.equals(s);
    }

}
