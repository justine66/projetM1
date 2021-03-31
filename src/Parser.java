import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser<File> {

    protected String string;
        public Parser (File F) {

            try {

        BufferedReader br = new BufferedReader(new FileReader((java.io.File) F));

                String string1 = br.readLine();



            while (string1 != null) {

                String S = "#=GC SS_cons               ";
                if (string1.regionMatches(0, S, 0, S.length())) { // on crée un if pour tester si on est dans la bonne ligne contenant le motif #
                    string = string1.replace(S, "");


                }
                string1 = br.readLine();
            }

            string = string.replace("<", "(");
            string = string.replace(">", ")");
            string = string.replace(".", "-");
            string = string.replace(",", "-");
            string = string.replace(":", "-");
            string = string.replace("_", "-");
        }
            catch (IOException e) {

                e.printStackTrace();
            }



    }


}
