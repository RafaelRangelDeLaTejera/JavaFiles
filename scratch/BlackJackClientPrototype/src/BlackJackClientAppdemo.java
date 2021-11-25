import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJackClientAppdemo extends Application {
    public static void main(String[] args) {


        Application.launch();

    }

    FXMLLoader loader;
    BlackJackClientControllerdemo controllerInstance;
    private String hostName = "127.0.0.1";



    @Override
    public void start(Stage stage) throws Exception {
        try {

            loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("BlackJackClientdemo.fxml").openStream()); //load fxml file

            controllerInstance = (BlackJackClientControllerdemo) loader.getController();

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("BlackJack Game");
            stage.setScene(scene);
            stage.show();

            controllerInstance.hostName = this.hostName;
            controllerInstance.startClient();


        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
