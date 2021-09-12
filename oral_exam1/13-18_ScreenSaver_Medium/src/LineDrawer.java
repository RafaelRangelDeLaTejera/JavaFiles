import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.Scanner; //testing purposes

public class LineDrawer extends JPanel {
    private final Color[] colors = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.WHITE,Color.ORANGE,Color.YELLOW};
    private int lineCount = 100;
    int x1,x2,y1,y2;
    Random randomNumber = new Random();
    //ActionListener taskPerformer = new ActionListener();



    @Override
    public void paintComponent(Graphics g) {

        if (lineCount == 100){
            super.paintComponent(g);
            lineCount = 0;}

//        for (int i = 0; i < 99; i++){
//
//        }

            g.setColor(colors[randomNumber.nextInt(6)]);

            int x1 = randomNumber.nextInt(1001);
            int x2 = randomNumber.nextInt(1001);
            int y1 = randomNumber.nextInt(801);
            int y2 = randomNumber.nextInt(801);

            g.drawLine(x1, x2, y1, y2);


        repaint();

        lineCount++;

        }





//
//            System.out.print(lineCount);
//        }






}
