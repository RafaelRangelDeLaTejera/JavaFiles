import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

public class NumeralConverterController {

    @FXML
    private TextField arabic;

    @FXML
    private TextField roman;

    @FXML
    private Text validationMessage;

    @FXML
    public void initialize() {

        validationMessage.setVisible(false);

        arabic.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try{
                    roman.setText(ConversionLogic.convertArabicToRoman(t1)); //try to convert the input roman numerals to arabic numbers

                    validationMessage.setVisible(false); //set the validation message to false if succesfully converted numbers
                }
                catch (Exception e){ //if the numbers could not be changed smoothly then the output text on the other text field will be set to the same string as the one the user input


                    //roman.setText(s);

                    if (arabic.getText().equals("")){ //if nothing is written display the error message
                        validationMessage.setVisible(false);
                        roman.setText("");
                    }
                    else {
                        validationMessage.setVisible(true);
                    }

                }

            }
        });
        roman.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
               try {
                   arabic.setText(ConversionLogic.convertRomanToArabic(t1));

//                   if (ConversionLogic.convertArabicToRoman(ConversionLogic.convertRomanToArabic(roman.getText())).equals(roman.getText())){ //if passed in roman numeral in the right format
//                       arabic.setText(ConversionLogic.convertRomanToArabic(t1));
//                   }
//                   else{
//                        roman.setText(ConversionLogic.convertRomanToArabic(roman.getText()));
//                   }

                   validationMessage.setVisible(false);
               }
               catch (Exception e){
//                   if (t1.length()==0){
                  // arabic.setText(s);

                   if (roman.getText().equals("")){
                       validationMessage.setVisible(false);
                       arabic.setText("");
                   }
                   else {
                       validationMessage.setVisible(true);
                   }
//                   }
//                   else {
//                       arabic.setText("invalid input");
//                   }

               }
            }
        });
    }
}


