import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumeralConverter extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent design = FXMLLoader.load(getClass().getResource("NumeralConverter.fxml")); //load fxml file

        Scene scene = new Scene(design); //create new scene object with the loaded fxml of the scene builder design

        //set parameters of the stage which is the window that will show our application, and show it
        stage.setTitle("ARABIC/ROMAN CONVERTER");
        stage.setScene(scene);
        stage.show();
    }
}
