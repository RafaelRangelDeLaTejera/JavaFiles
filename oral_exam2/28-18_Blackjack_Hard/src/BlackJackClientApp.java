import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BlackJackClientApp, this class extends the appication class because it is the client application for the player to play a blackjackgame
 * while connected to a server.
 */
public class BlackJackClientApp extends Application {

    /**
     * main method of the application class that launches the client app
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args) {
        Application.launch(); //launch the app
    }

    /**
     * FXML loader to load the fxml file constructed through scene builder
     */
    private FXMLLoader loader;

    /**
     * BlackJackClient controller member controller instance to hold the instance of the client app controller created when the fxml file was loaded, this
     * instantiated object will allow for the app to establish a connection with the server once the GUI was set up
     */
    private  BlackJackClientController controllerInstance;

    /**
     * Executor service slave thread to be used to run the client as a separate thread to implement the run method
     */
    private ExecutorService slave;

    /**
     * String hostname holds the IP needed to establish a connection with the server (right now its set to work with a server on the same machine)
     */
    private String hostName = "127.0.0.1";

    /**
     * overridden start method to set up the GUI from the fxml file and also to start a thread pool with just the client thread from the controller object
     * @param stage the stage in which the GUI will be displayed
     */
    @Override
    public void start(Stage stage) {
        try {

            loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("BlackJackClient.fxml").openStream()); //load fxml file

            controllerInstance = (BlackJackClientController) loader.getController();

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("BlackJack Game");
            stage.setScene(scene);
            stage.show();

            controllerInstance.setHostName(this.hostName);
            controllerInstance.startClient();

            // create and start worker thread for this client
             slave = Executors.newFixedThreadPool(1);
            slave.execute(controllerInstance); // execute client


        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    /**
     * stop method to be called when the GUI is closed, this was overridden to end the controller object running thread and close the connection with the server
     * @throws Exception for any exception the call to the super class stop method might throw
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        controllerInstance.closeConnection();
        controllerInstance.setIsGame(false);
        slave.shutdownNow();
    }
}

