import javax.swing.*;

/**
 * BlackJackServerTest class which holds the main method to run the server gui app
 */
public class BlackJackServerTest {

    /**
     * main method that starts the BlackJackServer app
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args) {
        BlackJackServer dealerApplication = new BlackJackServer(); // create server
        dealerApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dealerApplication.startServer(); // run server application
    }
}
