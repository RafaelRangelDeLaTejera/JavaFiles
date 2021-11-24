import javax.swing.*;

public class BlackJackClientTest {
    public static void main(String[] args) {
        BlackJackClientApp application;

        // if no command line args
        if (args.length == 0){
            application = new BlackJackClientApp("127.0.0.1");
        }
        else{
            application = new BlackJackClientApp(args[0]); // use args to connect

        }



    }
}
