import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class User extends JDialog {
    private JPanel contentPane;
    private JTextField sequence;
    private JTextField file;
    private JTextField appariement;
    private JButton ajouterButton;
    private JPanel JPane1;
    private JLabel message;

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
        System.out.println(seq.length());
        System.out.println(ap.length());
        System.out.println(fichier.length());
        if (seq.length() == 0){
            add_message("veuillez remplir le champ sequence");
        }
        else if (ap.length() == 0 && fichier.length() != 0){
            File f = new File(fichier);
            ARN arn = new ARN(seq, f);
            Worker worker = new Worker(arn);
            worker.execute();
        }else if (ap.length() != 0 && fichier.length() == 0){
            ARN arn = new ARN(seq, ap);
            Worker worker = new Worker(arn);
            worker.execute();
        }else{
            add_message("veuillez remplir le champ appariement ou fichier");
        }

    }

    private void add_message(String message) {
        this.message.setText(message);
    }

    public static void main(String[] args) {
        User dialog = new User();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
