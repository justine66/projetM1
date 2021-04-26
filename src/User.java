import javax.swing.*;
import java.awt.event.*;
import java.io.File;

import static java.lang.Math.max;

public class User extends JDialog {

    private JPanel JPane1;
    private JPanel contentPane1;
    private JPanel contentPane2;
    private JPanel contentPane3;
    private JTextField sequence;
    private JTextField file;
    private JTextField appariement;
    private JButton ajouterButton;
    private JTextArea message;
    private JTextArea seq1;
    private JTextArea ap1;
    private JTextArea seq2;
    private JTextArea ap2;
    private JButton delete1;
    private JButton delete2;
    private JButton trouverLePlusGrandButton;
    private JPanel jpan3;
    private JTextArea textPane1;

    public User() {
        setTitle("Projet M1 BIBS");
        setContentPane(JPane1);
        setModal(true);
        message.setOpaque(false);
        seq1.setOpaque(false);
        ap1.setOpaque(false);
        seq2.setOpaque(false);
        ap2.setOpaque(false);
        textPane1.setOpaque(false);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { ajouter(); }
        });
        delete1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { delete(1); }
        });

        delete2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { delete(2); }
        });
        trouverLePlusGrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARN arn1 = null;
                try {
                    arn1 = new ARN(seq1.getText(),ap1.getText());
                } catch (Exception exception) {
                    Worker w = new Worker("", new JTextArea());
                    w.execute();
                }
                ARN arn2 = null;
                try {
                    arn2 = new ARN(seq2.getText(),ap2.getText());
                } catch (Exception exception) {
                    Worker w = new Worker(exception.getMessage(),textPane1);
                    w.execute();
                }
                plus_grand_sous_arbre(arn1,arn2);
            }
        });


    }

    public void delete(int i) {
        if (i == 1){
            Worker w = new Worker("", this.ap1);
            w.execute();
            w = new Worker("",this.seq1);
            w.execute();
        } else if (i == 2){
            Worker w = new Worker("", this.ap2);
            w.execute();
            w = new Worker("",this.seq2);
            w.execute();
        } else {
            Worker w = new Worker("attention pb d'appel de la fonction delete", this.message);
            w.execute();
        }

    }

    public void ajouter(){
        String seq = sequence.getText();
        String ap = appariement.getText();
        String fichier = file.getText();

        if (seq.length() == 0){
            Worker w = new Worker("veuillez remplir le champ sequence", this.message);
            w.execute();
        }
        else if (ap.length() == 0 && fichier.length() != 0){
            File f = new File(fichier);
            ARN arn = null;
            try {
                arn = new ARN(seq, f);
            } catch (Exception e) {
                Worker worker = new Worker(e.getMessage(), this.message);
                worker.execute();
            }
            if (this.ap1.getText().equals("") || this.ap2.getText().equals("")) {
                if (this.ap1.getText().equals("")) {
                    Worker worker = new Worker(arn.getAppariement(), this.ap1);
                    worker.execute();
                    Worker worker1 = new Worker(arn.getSequence(), this.seq1);
                    worker1.execute();
                } else {
                    Worker worker = new Worker(arn.getAppariement(), this.ap2);
                    worker.execute();
                    Worker worker1 = new Worker(arn.getSequence(), this.seq2);
                    worker1.execute();
                }
                if (max(ap1.getText().length(),ap2.getText().length())> 10 )
                {
                    setSize(max(getWidth() + ap1.getWidth(), getWidth() + ap2.getWidth()), getHeight());
                }
            } else {
                Worker worker = new Worker("veuillez reinitialiser arn 1 ou 2", this.message);
                worker.execute();
            }
        }else if (ap.length() != 0 && fichier.length() == 0){
            ARN arn = null;
            try {
                arn = new ARN(seq, ap);
            } catch (Exception e) {
                Worker worker = new Worker(e.getMessage(), this.message);
                worker.execute();
            }
            if (this.ap1.getText().equals("") || this.ap2.getText().equals("")) {
                if (this.ap1.getText().equals("")) {
                    Worker worker = new Worker(arn.getAppariement(), this.ap1);
                    worker.execute();
                    Worker worker1 = new Worker(arn.getSequence(), this.seq1);
                    worker1.execute();
                } else {
                    Worker worker = new Worker(arn.getAppariement(), this.ap2);
                    worker.execute();
                    Worker worker1 = new Worker(arn.getSequence(), this.seq2);
                    worker1.execute();
                }
                if (max(ap1.getText().length(),ap2.getText().length())> 10 )
                {
                    setSize(max(getWidth() + ap1.getWidth(), getWidth() + ap2.getWidth()), getHeight());
                }
            } else {
                Worker worker = new Worker("veuillez reinitialiser arn 1 ou 2", this.message);
                worker.execute();
            }


        }else{
            Worker w = new Worker("veuillez remplir le champ appariement ou fichier", this.message);
            w.execute();
        }
        /*System.out.println("$$$");
        System.out.println(contentPane3.getWidth());
        System.out.println(max(ap1.getWidth(),ap2.getWidth())> getWidth()- (delete1.getWidth()));
        System.out.println(ap2.getSize());*/
    }

    /**
     * affiche le plus grand sous-arbre commun de 2 arn
     * @param arn1
     * @param arn2
     */
    public void plus_grand_sous_arbre(ARN arn1, ARN arn2){
        Worker w = new Worker(arn1.plus_grand_sous_arbre(arn2), textPane1);
        w.execute();
    }


    public static void main(String[] args) {
        User dialog = new User();
        dialog.pack();
        dialog.setVisible(true);
        //System.out.println(dialog.getWidth());
        System.exit(0);
    }
}
