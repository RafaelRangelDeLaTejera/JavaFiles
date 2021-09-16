import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** class that when created draws a 100 lines on the container and then clears it out and draws them again and just keeps continuously drawing.
 * @extends JPanel
 */
public class LineDrawer extends JPanel {
    /**
     * Array of Color objects that holds the 6 option of colors to draw the lines in
     */
    private final Color[] colors = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.WHITE, Color.ORANGE, Color.YELLOW};

    /**
     * new Random object creation to get random numbers in the paintComponent method in order to randomly pick a color and the position of the lines by
     * calling the nextInt method from the randomNumber Random object
     */
    private final Random randomNumber = new Random();

    /**
     * overrides paintComponent method from the extended JPanel class, this method first constructs a panel and then draws 100 lines using a for loop and the method drawLine of abstract class Graphics, after those lines are drawn, the method calls method repaint from the JPanel class to repeat the process, which means it clears out the panel and draws 100 lines again
     * @param g Graphics object for graphics context to allow application to draw
     */
    @Override
    public void paintComponent(Graphics g) {

        //call the super class paintComponent method to paint the panel, pass a copy of the graphics g to protect the paint components
        super.paintComponent(g); //sets up the Gui to show the painted objects

        int x1, x2, y1, y2; //variables to hold coordinates to draw lines

        //for loop that goes over 100 times to draw 100 lines on the panel
        for (int i = 0; i < 100; i++) {


            g.setColor(colors[randomNumber.nextInt(6)]); //pick a color for the line using a random number

            //pick random coordinates for the lines to be drawn, the coordinates work on a Frame of size 2000x1000 to make sure lines are in frame
            x1 = randomNumber.nextInt(getWidth());
            x2 = randomNumber.nextInt(getWidth());
            y1 = randomNumber.nextInt(getHeight());
            y2 = randomNumber.nextInt(getHeight());


            //if statements to avoid having the line be a dot to have at least the x or y coordinate be different
            if (x1 == x2) {
                x2 = x2 / 2;
            }

            if (y1 == y2) {
                y2 = y2 / 2;
            }

            g.drawLine(x1, x2, y1, y2); //draw the line


        }
        repaint(); //call the repaint method to allow the program to continue drawing by painting the component of the above process again


    }


}









