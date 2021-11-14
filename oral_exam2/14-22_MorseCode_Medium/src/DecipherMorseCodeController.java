import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DecipherMorseCodeController {

    @FXML
    private TextField enteredMorseCode;

    @FXML
    private Button decipherButton;

    @FXML
    private TextField textOutput;

    @FXML
    void decipherPressed(ActionEvent event) {

        textOutput.setText(MorseCodeModel.decipherToEnglish(enteredMorseCode.getText()));

    }

}
