import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * controller class for the NumeralConverter fxml file build in scene builder
 */
public class NumeralConverterController {

    /**
     * text field for user to write in arabic numerals or output in arabic
     */
    @FXML
    private TextField arabic;

    /**
     * text field for user to write in roman numerals or output in roman
     */
    @FXML
    private TextField roman;

    /**
     * text to display if user inputs invalid roman numeral or invalid character in either field
     */
    @FXML
    private Text validationMessage;

    /**
     * method called at at the beginning when the GUI is set up, this method is override to implement action listeners for when the text fields texts change
     */
    @FXML
    public void initialize() {

        validationMessage.setVisible(false); //hide validation message at the beginning

        //implement and action listener to the arabic text field for when the text it holds changes
        arabic.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try{
                    roman.setText(NumeralConverterModel.convertArabicToRoman(t1)); //try to convert the input roman numerals to arabic numbers and display conversion on roman field

                    validationMessage.setVisible(false); //hide the validation message if successfully converted numbers
                }
                catch (Exception e){ //if the numbers could not be changed smoothly then the output text on the other text field will be set to the same string as the one the user input

                    if (arabic.getText().equals("")){ //if nothing is written hide the error message
                        validationMessage.setVisible(false);
                        roman.setText("");
                    }
                    else {
                        validationMessage.setVisible(true); //display message if input text could not be converted
                    }

                }

            }
        });
        //implement action listener to the roman field to detect when the text of the field has changed
        roman.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
               try {
                   arabic.setText(NumeralConverterModel.convertRomanToArabic(t1)); //pull out of if statement in case this does not work
                   validationMessage.setVisible(false);
               }
               catch (Exception e){
                   if (roman.getText().equals("")){ //if nothing is written
                       validationMessage.setVisible(false);
                       arabic.setText("");
                   }
                   else {
                       validationMessage.setVisible(true); //if numeral could not be converted then display invalid message
                   }
               }
            }
        });
    }
}


