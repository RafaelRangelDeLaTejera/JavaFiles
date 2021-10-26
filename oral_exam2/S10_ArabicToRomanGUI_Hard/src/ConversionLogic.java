public class ConversionLogic {
    private static int value;
    private static final String[] units = {"I","II","III","IV","VI","VII","VIII","IX"};
    private static final String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static final String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static final String thousands = "M";

    public ConversionLogic() {
        value = 0;
    }

    public static String convertArabicToRoman(String Arabic){

        value = Integer.valueOf(Arabic);
        String romanNumeral = "";


        while(value != 0 ){
            if (value >= 1000){
                for (int i = 1; i <= value/1000; i++){
                    romanNumeral += thousands;
                }
                value = value%1000;
            }
            if (value >= 100){
                romanNumeral += hundreds[value/100-1];
                value = value%100;
            }
            if (value >= 10){
                romanNumeral += tens[value/10-1];
                value = value%10;
            }
            romanNumeral += units[value-1];
            value = 0;

        }

        return romanNumeral;
    }

    public static String convertRomanToArabic(String romanNumeral){
        return "hello";
    }
}
