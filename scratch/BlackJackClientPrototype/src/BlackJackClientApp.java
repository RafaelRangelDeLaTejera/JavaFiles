import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJackClientApp extends Application {

    public BlackJackClientApp(String hostName) {
        new BlackJackClientController(hostName);
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



        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
