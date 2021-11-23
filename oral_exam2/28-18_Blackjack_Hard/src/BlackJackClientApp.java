import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class BlackJackClientApp extends Application {

    public static void main(String[] args){
        Application.launch(args); //launch the blackJack player application
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BlackJackClient.fxml")); //load fxml file

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("BlackJack Game");
            stage.setScene(scene);
            stage.show();

            if (args.length == 0)
                application = new Client("127.0.0.1"); // connect to localhost
            else
                application = new Client(args[0]); // use args to connect

            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.runClient(); // run client application
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
