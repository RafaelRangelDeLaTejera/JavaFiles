public class CalculatorModel {
//    private double resultValue = 0;
//    private String operationsAndValues = "";

//    public CalculatorModel() {
//        resultValue = 0;
//        operationsAndValues = "";
//    }

//    public static double getResultValue() {
//        return resultValue;
//    }
//
//    public void setResultValue(double resultValue) {
//        this.resultValue = resultValue;
//    }

//    public String getOperationsAndValues() {
//        return operationsAndValues;
//    }
//
//    public void setOperationsAndValues(String operationsAndValues) {
//        this.operationsAndValues += operationsAndValues;
//    }

    public static double computeResult(String operationsAndValues){
        String values = "";
        double resultValue = 0;

        for (int i = 0; i < operationsAndValues.length(); i++){
            if (Character.isDigit(operationsAndValues.charAt(i))){
                values+= operationsAndValues.charAt(i);
                resultValue = Double.parseDouble(values);
            }
            else if (operationsAndValues.charAt(i) == '+'){
                i++;
                values = "";
                while (Character.isDigit(operationsAndValues.charAt(i))){
                    values+= operationsAndValues.charAt(i);
                    i++;
                }
                double sum = Double.parseDouble(values);
                resultValue += sum;
            }
            else if (operationsAndValues.charAt(i) == '-'){
                i++;
                values = "";
                while (Character.isDigit(operationsAndValues.charAt(i))){
                    values+= operationsAndValues.charAt(i);
                    i++;
                }
                double substraction = Double.parseDouble(values);
                resultValue -= substraction;
            }
            else if (operationsAndValues.charAt(i) == '*'){
                i++;
                values = "";
                while (Character.isDigit(operationsAndValues.charAt(i))){
                    values+= operationsAndValues.charAt(i);
                    i++;
                }
                double times = Double.parseDouble(values);
                resultValue *= times;
            }
            else if (operationsAndValues.charAt(i) == '/'){
                i++;
                values = "";
                while (Character.isDigit(operationsAndValues.charAt(i))){
                    values+= operationsAndValues.charAt(i);
                    i++;
                }
                double divide = Double.parseDouble(values);
                resultValue /= divide;
            }
        }
        return resultValue;
    }

}
