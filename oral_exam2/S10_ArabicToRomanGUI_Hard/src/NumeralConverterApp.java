import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * application to convert in real time from roman to arabic numeral and vice versa
 */
public class NumeralConverterApp extends Application {

    /**
     * main method that launches the app
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args){
        Application.launch(args); //launch the NumeralConverter application
    }

    /**
     * overridden start method that will be called when the app is launched in order to load the fxml file edited
     * in the scene builder and show the stage
     * @param stage the stage that will show the app GUI
     * @throws Exception in case the GUI could not have been set up properly
     */
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NumeralConverter.fxml")); //load fxml file

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("ARABIC/ROMAN CONVERTER");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
//todo
//set text from invalid input to not editable