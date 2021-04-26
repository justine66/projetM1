import java.io.File;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class ARN {
    private String sequence;
    private String appariement;
    private Arbre arbre = new Arbre() ;

    /**
     * constructeur
     * @param a appariement des bases
     * @param s sequence de l'ARN
     **/
    public ARN(String s, String a) throws Exception {
        this.sequence = s;
        if (is_correct(a)){
            this.appariement = a;
            arbre.create_arbre(appariement);
        } else {
            throw new Exception("appariement incorrect");
        }
    }

    /**
     * constructeur
     * @param a fichier Stockholm pour recuperer l'appariement
     * @param s sequence de l'ARN
     **/
    public ARN(String s, File a) throws Exception {
        this.sequence = s;
        Parser p = new Parser(a);
        if (is_correct(p.string)){
            this.appariement = p.string;
            arbre.create_arbre(appariement);
        } else {
            throw new Exception("appariement incorrect");
        }

    }

    public String getAppariement() {
        return appariement;
    }

    public String getSequence() {
        return sequence;
    }

    /**
     * vérifie si l'appariement est un arbre correct
     * @param a sequence d'appariement à vérifier
     * @return true si l'appariement est un arbre correct
     */
    public static boolean is_correct(String a) {
        int count1 = StringUtils.countMatches(a, "(");
        int count2 = StringUtils.countMatches(a, ")");
        if (Objects.equals(count1, count2)){
            String s = a.replace("-","");
            while (!s.isEmpty()){
                if(s.indexOf("(")>(s.indexOf(")"))){
                    return false;
                } else {
                    s = s.replaceFirst("\\(","");
                    s = s.replaceFirst("\\)","");
                }
            }
            return true;
        }else return false;
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
     * @param arn ARN à comparer
     * @return vrai si les sequences et les appariements sont les memes
     */
    public boolean is_appiered(ARN arn){
        return this.appariement.equals(arn.appariement) && this.sequence.equals(arn.sequence);
    }

    /*equivalent a la methode is_appiered mais pouvoir utilisé .equals (conseil du prof)*/
    public boolean equals (ARN arn) { return is_appiered(arn); }

    /**
     * teste si this est contenue dans arn
     * @param a sequence d'appariement à comparer avec le this.appariement
     * @return true si this.appariement est un motif de a
     */
    public boolean is_motif (String a){
            return a.contains(this.appariement);
    }

    /**
     * teste si this est contenue dans arn
     * @param arn arn à comparer avec this
     * @return true si this est un motif de arn
     */
    public boolean is_motif (ARN arn){
        return arn.appariement.contains(this.appariement) && arn.sequence.contains(this.sequence);
    }

    /**
     * recupère le plus grand sous-arbre commun entre this et arn
     * @param arn
     * @return un string avec l'appariement du plus grand sous-arbre commun
     */
    public String plus_grand_sous_arbre(ARN arn){
        if (this.is_motif(arn)){
            return this.appariement;
        }else if (arn.is_motif(this)){
            return arn.appariement;
        }else {
            int min;
            String res = "";
            if (this.appariement.length() < arn.appariement.length()) {
                min = this.appariement.length();
                for (int i = 0; i < min; i++) {
                    for (int j = i + 1; j < min + 1; j++) {
                        String s = this.appariement.substring(i, j);
                        if(is_correct(s)){
                            if (arn.appariement.contains(s) && s.length() > res.length()) {
                                res = s;
                            }
                        }
                    }
                }
            } else {
                min = arn.appariement.length();
                for (int i = 0; i < min - 1; i++) {
                    for (int j = i + 1; j < min; j++) {
                        String s = arn.appariement.substring(i, j);
                        if(is_correct(s)){
                            if (this.appariement.contains(s) && s.length() > res.length()) {
                                res = s;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
