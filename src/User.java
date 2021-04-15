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
    private JLabel message;
    private JLabel seq1;
    private JLabel ap1;
    private JLabel seq2;
    private JLabel ap2;
    private JButton delete1;
    private JButton delete2;

    public User() {
        setTitle("Projet M1 BIBS");
        setContentPane(JPane1);
        setModal(true);

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


    }

    private void delete(int i) {
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
        Worker m = new Worker("", this.message);
        m.execute();
        if (seq.length() == 0){
            Worker w = new Worker("veuillez remplir le champ sequence", this.message);
            w.execute();
        }
        else if (ap.length() == 0 && fichier.length() != 0){
            File f = new File(fichier);
            ARN arn = new ARN(seq, f);
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
            } else {
                Worker worker = new Worker("veuillez reinitialiser arn 1 ou 2", this.message);
                worker.execute();
            }
        }else if (ap.length() != 0 && fichier.length() == 0){
            ARN arn = new ARN(seq, ap);
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
        System.out.println("$$$");/*
        System.out.println(contentPane3.getWidth());
        System.out.println(max(ap1.getWidth(),ap2.getWidth())> getWidth()- (delete1.getWidth()));
        System.out.println(ap2.getSize());*/
    }


    public static void main(String[] args) {
        User dialog = new User();
        dialog.pack();
        dialog.setVisible(true);
        System.out.println(dialog.getWidth());
        System.exit(0);
    }



}
