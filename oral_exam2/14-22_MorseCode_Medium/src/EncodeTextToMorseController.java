import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * This class is the controller for the EncodeTextToMorseApp GUI
 */
public class EncodeTextToMorseController {

    /**
     * text field from the fxml file where the user will write the text to encode
     */
    @FXML
    private TextField enteredText;

    /**
     * button the user will press when they want to encode the written text
     */
    @FXML
    private Button encodeButton;

    /**
     * text field that will display the encoded text in morse code
     */
    @FXML
    private TextField morseOutput;

    /**
     * on action method for when the encodeButton is pressed, this will call the encodeMorse method from the model and pass in the text written in enteredText Field and
     * translated into mores writing it in the morseOutput textField
     * @param event passed in event, when the button is pressed
     */
    @FXML
    void encodePressed(ActionEvent event) {

        morseOutput.setText(MorseCodeModel.encodeToMorse(enteredText.getText()));
    }

}
