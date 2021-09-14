import javax.swing.*;
import java.awt.*;

/**
 * When object of ScreenSaver class is created, an invisible frame is created where the LineDrawer object will draw 100 lines continuously in a container with a black background.
 * @extends JFrame
 */
public class ScreenSaver extends JFrame {

    /**
     * ScreenSaver constructor, first it calls the the super class JFrame constructor and passes in the title of the Frame (string)
     * to create the window frame, then an object from the subclass LineDrawer, named panel is created, from which the method setBackgroundColor is called
     * to set background color to black. Then the LineDrawer object panel is added to the ScreenSaver frame. at the end of the constructor the setDefaultCloseOperation
     * method is called and the static variable EXIT_ON_CLOSE from the JFrame class is passed in to stop the program when the window is closed.
     */
    public ScreenSaver() {

        super("Multiple line drawer cool eye effect screensaver"); //call the super class JFrame constructor and pass in the title to create an invisible frame with the passed in title

        LineDrawer panel = new LineDrawer(); //create a new LineDrawer object to have a container in the ScreenSaver frame
        panel.setBackground(Color.black); //set the background color of the LineDrawer panel to black
        add(panel); //add the LineDrawer panel to the ScreenSaver frame as a container

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //have the program end when the window gets closed

    }

}
