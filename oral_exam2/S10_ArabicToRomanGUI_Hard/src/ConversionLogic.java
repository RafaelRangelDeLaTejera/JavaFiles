public class ConversionLogic {
    //private static int value;
    private static final String[] units = {"I","II","III","IV","V","VI","VII","VIII","IX"};
    private static final String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static final String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static final String thousands = "M";

    public ConversionLogic() {
       // value = 0;
    }

    public static String convertArabicToRoman(String Arabic) throws Exception {

        if (Arabic.length()<1){
            System.out.print("in exception");
            throw new Exception();
        }


       int value = Integer.parseInt(Arabic);
        String romanNumeral = "";

        System.out.print("in function arabic to roman");
        if (value <= 0 || value > 3999 || Arabic.charAt(0) == '0' ){
            System.out.print(Arabic.charAt(0));
            throw new Exception(); //return exception when passed in Arabic number is just 0 from the beginning

        }


        while(value != 0 ){
            System.out.print("in while arabic to roman");
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

        System.out.print("return succesfull");
        return romanNumeral;
    }

    public static String convertRomanToArabic(String romanNumeral) throws Exception {


System.out.print("in function");

String savedCopy = romanNumeral;

if (romanNumeral.length() == 0 ){
    System.out.print("in function");
    throw new Exception();
}

       int  value = 0;
        romanNumeral+=" ";

        while(romanNumeral.length() > 1){
            System.out.print("in while");
            if (romanNumeral.charAt(0) == 'M' ){
                value+=1000;
                romanNumeral = romanNumeral.substring(1);

            }
            else if (romanNumeral.charAt(0) == 'C'){
                if (romanNumeral.charAt(1) == 'D'){
                    value+=400;
                    romanNumeral = romanNumeral.substring(2);
                }
                else if (romanNumeral.charAt(1) == 'M'){
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
            else {
                throw new Exception();
            }

        }


        if (convertArabicToRoman(String.valueOf(value)).equals(savedCopy)){ //if passed in roman numeral is not in the right format
            System.out.print(value);
        System.out.print("finish");
            return String.valueOf(value);
        }
        else{
            System.out.print(savedCopy);
            throw new Exception();
        }
    }
}

//todo
//handle exceptions
//make sure user inputs valid bounds
//make sure user inputs valid roman numeral format
//todo
//fix bug where invalid input does not work for both text fields make sure that both text fields are coordinated meaning that they both change properly
