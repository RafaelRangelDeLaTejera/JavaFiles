import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlackJackClientApp extends Application {
    public static void main(String[] args) {


        Application.launch();

    }

    FXMLLoader loader;
    BlackJackClientController controllerInstance;
    ExecutorService worker;
    private String hostName = "127.0.0.1";



    @Override
    public void start(Stage stage) throws Exception {
        try {

            loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("BlackJackClient.fxml").openStream()); //load fxml file

            controllerInstance = (BlackJackClientController) loader.getController();

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("BlackJack Game");
            stage.setScene(scene);
            stage.show();

            controllerInstance.hostName = this.hostName;
            controllerInstance.startClient();

            // create and start worker thread for this client
             worker = Executors.newFixedThreadPool(1);
            worker.execute(controllerInstance); // execute client


        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        controllerInstance.closeConnection();
        controllerInstance.isGame = false;
        worker.shutdownNow();
    }
}

//todo find a way to stop the thread before when you close the window