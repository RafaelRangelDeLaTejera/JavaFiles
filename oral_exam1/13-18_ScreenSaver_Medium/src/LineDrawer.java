import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class LineDrawer extends JPanel {

    private int lineCount = 0;

    @Override
    public void paintComponent(Graphics g) {

        if (lineCount == 0 || lineCount == 100){
            super.paintComponent(g);
            lineCount = 0;
        }


       //while (lineCount < 100) {
            g.setColor(Color.white);

            int x1 = randomNumber(g.getClipBounds().width);
            int x2 = randomNumber(g.getClipBounds().width);
            int y1 = randomNumber(g.getClipBounds().height);
            int y2 = randomNumber(g.getClipBounds().height);

            g.drawLine(x1, x2, y1, y2);
            ;
            //repaint(); // repaint panel

            repaint();

            lineCount++;
//
//            System.out.print(lineCount);
//        }

    }

    public void drawMultipleLines(){
        for(int i = 0; i < 100;i++);
        {
            repaint();
        }
    }

    public int randomNumber(int bound)
    {
        int randomNumber = (int)(Math.random()*bound + 1);

        return randomNumber;
    }

}
