import javax.swing.*;

/**
 * ScreenSaver demo class that implements the ScreenSaver class in the main function by creating an object, calling the
 * setSize method to set the size of the window to pop up, and then makes the ScreenSaver Object visible using the setVisible methodand passing it true.
 */
public class ScreenSaverDemo {
    public static void main(String[] args) {
        ScreenSaver screenSaver = new ScreenSaver();//create new ScreenSaver object
        screenSaver.setSize(2000, 1000);//set screenSaver size to fit the appropriate screen
        screenSaver.setVisible(true); //make the screenSaver frame visible
    }
}
