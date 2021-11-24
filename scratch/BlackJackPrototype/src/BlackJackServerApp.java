import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJackServerApp extends Application {

    private final FXMLLoader loader = new FXMLLoader(getClass().getResource("BlackJackServer.fxml"));
    private final BlackJackServerController myController = (BlackJackServerController)loader.getController();

    //todo added for test




    public static void main(String[] args){

        //myController.execute();


        Application.launch(args); //launch the server application






    }

    @Override
    public void start(Stage stage) throws Exception {
        try {



//            FXMLLoader loader = new FXMLLoader(getClass().getResource("BlackJackServer.fxml"));

            Parent root = loader.load(); //load fxml file


            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("BlackJack Server");
            stage.setScene(scene);

             //myController = (BlackJackServerController)loader.getController();


            stage.show();

            myController.execute();

        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    //todo

    //todo
}
