import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class NumeralConverterController {

    private String arabicNumber;
    private String romanNumber;

    @FXML
    private TextField arabic;

    @FXML
    private TextField roman;

    @FXML
    public void initialize() {
        arabic.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                roman.setText(ConversionLogic.convertArabicToRoman(t1));
            }
        });
        roman.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //arabic.setText(t1);
            }
        });
    }
}


