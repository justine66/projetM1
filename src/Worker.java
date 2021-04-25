import javax.swing.*;

public class Worker extends SwingWorker<Void, Void> {

    private JTextArea jtext;
    private String message;

    public Worker(String m, JTextArea j){
        this.message = m;
        this.jtext = j;
    }

    @Override
    protected Void doInBackground() throws Exception {
        jtext.replaceRange(message,0, jtext.getText().length());
        return null;
    }


    public void process(){

    }
    public void done (){

    }
}

