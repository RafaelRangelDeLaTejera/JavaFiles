import javax.swing.*;

/**
 * driver class to run the GUI
 */
public class HangmanDriver {

    /**
     * main method that starts the app with the HangmanGUI
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args) {
        HangmanGUI hangmanFrame = new HangmanGUI();
        hangmanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangmanFrame.setSize(1000, 800);
        hangmanFrame.setVisible(true);
    }
}
