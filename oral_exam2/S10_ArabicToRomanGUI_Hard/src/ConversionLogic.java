public class ConversionLogic {
    private static int value;
    private static final String[] units = {"I","II","III","IV","V","VI","VII","VIII","IX"};
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
            else if (value >= 100){
                romanNumeral += hundreds[value/100-1];
                value = value%100;
            }
            else if (value >= 10){
                romanNumeral += tens[value/10-1];
                value = value%10;
            }
            else {
            romanNumeral += units[value-1];
            value = 0;}

        }

        return romanNumeral;
    }

    public static String convertRomanToArabic(String romanNumeral){


System.out.print("in function");

        value = 0;
        romanNumeral+=" ";

        while(romanNumeral.length() > 1){
            System.out.print("in while");
            if (romanNumeral.charAt(0) == 'M'){
                value+=1000;
                romanNumeral = romanNumeral.substring(1);
            }
            else if (romanNumeral.charAt(0) == 'C'){
                if (romanNumeral.charAt(2) == 'D'){
                    value+=400;
                    romanNumeral = romanNumeral.substring(2);
                }
                else if (romanNumeral.charAt(2) == 'M'){
                    value+=900;
                    romanNumeral = romanNumeral.substring(2);
                }
                else {
                    value+=100;
                    romanNumeral = romanNumeral.substring(1);
                }
            }
            else if (romanNumeral.charAt(0) == 'D'){
                value +=500;
                romanNumeral = romanNumeral.substring(1);
            }
            else if (romanNumeral.charAt(0) == 'X'){
                if (romanNumeral.charAt(1) == 'L'){
                    value+=40;
                    romanNumeral = romanNumeral.substring(2);
                }
                else if (romanNumeral.charAt(1) == 'C'){
                    value+=90;
                    romanNumeral = romanNumeral.substring(2);
                }
                else {
                    value+=10;
                    romanNumeral = romanNumeral.substring(1);
                }
            }
            else if (romanNumeral.charAt(0) == 'L'){
                value +=50;
                romanNumeral = romanNumeral.substring(1);
            }
            else if (romanNumeral.charAt(0) == 'I'){
                if (romanNumeral.charAt(1) == 'V'){
                    value+=4;
                    romanNumeral = romanNumeral.substring(2);
                }
                else if (romanNumeral.charAt(1) == 'X'){
                    value+=9;
                    romanNumeral = romanNumeral.substring(2);
                }
                else {
                    value+=1;
                    romanNumeral = romanNumeral.substring(1);
                }
            }
            else if (romanNumeral.charAt(0) == 'V'){
                value +=5;
                romanNumeral = romanNumeral.substring(1);
            }

        }


        return String.valueOf(value);
    }
}

//todo
//handle exceptions
//make sure user inputs valid bounds
//make sure user inputs valid roman numeral format
