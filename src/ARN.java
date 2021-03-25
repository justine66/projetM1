import static com.sun.tools.doclint.Entity.and;

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
    public boolean is_appiered(String a){
        return this.appariement.equals(a);
    }

    public boolean is_appiered(String a, String s){
        return this.appariement.equals(a) && this.sequence.equals(s);
    }

}
