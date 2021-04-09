import javax.swing.*;
import java.awt.*;

public class Worker extends SwingWorker<Void, Void> {

    private ARN arn;
    public Worker(ARN   arn){
        this.arn = arn;
    }
    @Override
    protected Void doInBackground() throws Exception {
        return null;
    }


    public void process(){

    }
    public void done (){

    }
}

