import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * application to decipher morse code and output it ar alphanumeric characters
 */
public class DecipherMorseCodeApp extends Application {

    /**
     * main method that launches the app
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args){
        Application.launch(args); //launch the NumeralConverter application
    }

    /**
     * method called to set up the GUI app, here the fxml file is loaded and the stage is set to show the app
     * @param stage stage where the app will show
     * @throws Exception in case the GUI cant be set up
     */
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DecipherMorseCode.fxml")); //load fxml file

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("Morse Code app");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
