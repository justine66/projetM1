import javax.swing.*;

public class Worker extends SwingWorker<Void, Void> {

    private JLabel jlabel;
    private String message;

    public Worker(String m, JLabel j){
        this.message = m;
        this.jlabel = j;
    }
    @Override
    protected Void doInBackground() throws Exception {
        jlabel.setText(message);
        return null;
    }


    public void process(){

    }
    public void done (){

    }
}

