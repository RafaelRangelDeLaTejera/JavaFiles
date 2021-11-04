import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorController {

    String operations = "";
    double value = 0;

    @FXML
    private Button sevenButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button multiplyPressed;

    @FXML
    private Button oneButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button ceroButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button equalButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button sinButton;

    @FXML
    private Button cosButton;

    @FXML
    private Button exponentButton;

    @FXML
    private TextField result;

    @FXML
    void ceroPressed(ActionEvent event) {
        if (operations.equals("")){
            operations= "";
        }
        else {
            operations += "0";
        }
        result.setText(operations);

    }

    @FXML
    private void clearPressed(ActionEvent event) {
        operations = "";
        value = 0;
        result.setText(operations);

    }

    @FXML
    void cosPressed(ActionEvent event) {
        value = CalculatorModel.computeResult(operations);
        value = Math.cos(value);
        result.setText(String.valueOf(value));

    }

    @FXML
    void dividePressed(ActionEvent event) {
        if (operations.equals("")){
            operations= "";
        }
        else {
            operations += "/";
        }
        result.setText(operations);
    }

    @FXML
    void eightPressed(ActionEvent event) {
        operations +="8";
        result.setText(operations);
    }

    @FXML
    void equalPressed(ActionEvent event) {
        value = CalculatorModel.computeResult(operations);
        result.setText(String.valueOf(value));
        operations = "";
    }

    @FXML
    void exponentPresed(ActionEvent event) {
        value = CalculatorModel.computeResult(operations);
        value = Math.exp(value);
        result.setText(String.valueOf(value));
        operations = "";
    }

    @FXML
    void fivePressed(ActionEvent event) {
        operations += "5";
        result.setText(operations);
    }

    @FXML
    void fourPressed(ActionEvent event) {
        operations += "4";
        result.setText(operations);
    }

    @FXML
    void minusPressed(ActionEvent event) {
        if (operations.equals("")){
            operations= "";
        }
        else {
            operations += "-";
        }
        result.setText(operations);
    }

    @FXML
    void multiplicationPressed(ActionEvent event) {
        if (operations.equals("")){
            operations= "";
        }
        else {
            operations += "*";
        }
        result.setText(operations);
    }

    @FXML
    void ninePressed(ActionEvent event) {
        operations += "9";
        result.setText(operations);
    }

    @FXML
    void onePressed(ActionEvent event) {
        operations += "1";
        result.setText(operations);
    }

    @FXML
    void plusPressed(ActionEvent event) {
        if (operations.equals("")){
            operations= "";
        }
        else {
            operations += "+";
        }
        result.setText(operations);
    }

    @FXML
    void sevenPressed(ActionEvent event) {
        operations += "7";
        result.setText(operations);
    }

    @FXML
    void sinButton(ActionEvent event) {
        value = CalculatorModel.computeResult(operations);
        value = Math.sin(value);
        result.setText(String.valueOf(value));
        operations = "";
    }

    @FXML
    void sixPressed(ActionEvent event) {
        operations += "6";
        result.setText(operations);
    }

    @FXML
    void squarePressed(ActionEvent event) {
        value = CalculatorModel.computeResult(operations);
        value = value*value;
        result.setText(String.valueOf(value));
        operations = "";
    }

    @FXML
    void threePressed(ActionEvent event) {
        operations += "3";
        result.setText(operations);
    }

    @FXML
    void twoPressed(ActionEvent event) {
        operations += "2";
        result.setText(operations);
    }



}
