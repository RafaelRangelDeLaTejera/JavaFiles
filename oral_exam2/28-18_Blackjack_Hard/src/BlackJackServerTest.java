import javax.swing.*;

public class BlackJackServerTest {
    public static void main(String[] args) {
        BlackJackServer dealerApplication = new BlackJackServer(); // create server
        dealerApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dealerApplication.startServer(); // run server application
    }
}
