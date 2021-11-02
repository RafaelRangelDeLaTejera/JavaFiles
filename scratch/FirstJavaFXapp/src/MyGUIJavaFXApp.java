import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyGUIJavaFXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("MyGUIJavaFXApp.fxml")); //load fxml file

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            primaryStage.setTitle("ARABIC/ROMAN CONVERTER");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }

    }
}
