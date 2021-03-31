import java.awt.*;

class MyCanvas extends Canvas {
    private int width = 10;
    private int height = 10;
    private int X = 10;
    private int Y = 10;
    private Arbre arbre;

    public MyCanvas (Arbre a) {
        arbre = a;
        setBackground (Color.WHITE);
        setSize(200, 200);
    }

    public void draw (Graphics g ) {
        int x = X;
        int y = Y;

        for (Arbre a : arbre.getNoeuds()) {
            g.fillOval(x, y, width, height);
            g.setColor(Color.BLUE);
            g.drawLine(x, y, x+10,y+5);
            g.setColor(Color.BLACK);
            if (a.isEmpty()){
                g.fillOval(x, y, width, height);
            } else{
                g.fillOval(x, y, width, height);
                g.drawLine(x, y, x+20,y+15);
                draw(g, x+20, y+15 );
                y+= 15;
            }
        }

    }
    public void draw (Graphics g , int x , int y) {
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x+20,y+15);
        g.setColor(Color.BLACK);
        for (Arbre a : arbre.getNoeuds()) {
            System.out.println(a);
            if (a.isEmpty()){
                g.fillOval(x, y, width, height);
            } else{
                g.fillOval(x, y, width, height);
                g.drawLine(x, y, x+20,y+15);
                draw(g, x+20, y+15 );
                y+= 15;
            }
        }

    }

    public void paint (Graphics g) {

        g.setColor(Color.BLACK);
        draw(g, X, Y );

    }
}
