import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumeralConverter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NumeralConverter.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("ARABIC/ROMAN CONVERTER");
        stage.setScene(scene);
        stage.show();
    }
}
