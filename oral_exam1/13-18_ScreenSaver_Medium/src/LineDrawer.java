import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LineDrawer extends JPanel {
    private final Color[] colors = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.WHITE, Color.ORANGE, Color.YELLOW};
    private Random randomNumber = new Random();

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int x1, x2, y1, y2;

        for (int i = 0; i < 99; i++) {


            g.setColor(colors[randomNumber.nextInt(6)]);

            x1 = randomNumber.nextInt(getWidth());
            x2 = randomNumber.nextInt(getWidth());
            y1 = randomNumber.nextInt(getHeight());
            y2 = randomNumber.nextInt(getHeight());

            if (x1 == x2) {
                x2 = x2 / 2;
            }

            if (y1 == y2) {
                y2 = y2 / 2;
            }

            g.drawLine(x1, x2, y1, y2);


        }
        repaint();


    }


}









