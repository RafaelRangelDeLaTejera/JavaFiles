import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EncodeTextToMorseController {

    @FXML
    private TextField enteredText;

    @FXML
    private Button encodeButton;

    @FXML
    private TextField morseOutput;

    @FXML
    void encodePressed(ActionEvent event) {

        morseOutput.setText(MorseCodeModel.encodeToMorse(enteredText.getText()));
    }

}
