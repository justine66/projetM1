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

    public User() {
        setTitle("Projet M1 BIBS");
        setContentPane(JPane1);
        setModal(true);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { ajouter(); }
        });


    }

    public void ajouter(){
        String seq = sequence.getText();
        String ap = appariement.getText();
        String fichier = file.getText();
        if (seq.length() == 0){
            Worker m = new Worker("veuillez remplir le champ sequence", this.message);
            m.execute();
        }
        else if (ap.length() == 0 && fichier.length() != 0){
            File f = new File(fichier);
            ARN arn = new ARN(seq, f);
            if (this.ap1.equals("")) {
                Worker worker = new Worker(arn.getAppariement(), this.ap1);
                worker.execute();
                Worker worker1 = new Worker(arn.getSequence(), this.seq1);
                worker1.execute();
            }else{
                Worker worker = new Worker(arn.getAppariement(), this.ap2);
                worker.execute();
                Worker worker1 = new Worker(arn.getSequence(), this.seq2);
                worker1.execute();
            }
        }else if (ap.length() != 0 && fichier.length() == 0){
            ARN arn = new ARN(seq, ap);
            if (this.ap1.getText().equals("")) {
                Worker worker = new Worker(arn.getAppariement(), this.ap1);
                worker.execute();
                Worker worker1 = new Worker(arn.getSequence(), this.seq1);
                worker1.execute();
                setSize(max(getWidth() + ap1.getWidth(),getWidth() + ap2.getWidth()),max(getHeight() + ap1.getHeight(),getHeight() + ap2.getHeight()));
            }else{
                Worker worker = new Worker(arn.getAppariement(), this.ap2);
                worker.execute();
                Worker worker1 = new Worker(arn.getSequence(), this.seq2);
                worker1.execute();
                setSize(max(getWidth() + ap1.getWidth(),getWidth() + ap2.getWidth()),max(getHeight() + ap1.getHeight(),getHeight() + ap2.getHeight()));
            }
        }else{
            Worker m = new Worker("veuillez remplir le champ appariement ou fichier", this.message);
            m.execute();
        }
    }


    public static void main(String[] args) {
        User dialog = new User();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }



}
