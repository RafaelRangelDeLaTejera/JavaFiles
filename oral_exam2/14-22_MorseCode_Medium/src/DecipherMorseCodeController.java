import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class for the DecipherMorseCodeController GUI
 */
public class DecipherMorseCodeController {

    /**
     * text field where the user writes the morse code to be deciphered
     */
    @FXML
    private TextField enteredMorseCode;

    /**
     * button the user will pressed to decipher the written code
     */
    @FXML
    private Button decipherButton;

    /**
     * text field that will display the written code in alphanumeric characters
     */
    @FXML
    private TextField textOutput;

    /**
     * on action method that is called when the user pressed the decipher Button. This method calls the decipher model method to convert the text and then displays it in the text output field
     * @param event the event of when the button is pressed
     */
    @FXML
    void decipherPressed(ActionEvent event) {

        textOutput.setText(MorseCodeModel.decipherToEnglish(enteredMorseCode.getText()));

    }

}
