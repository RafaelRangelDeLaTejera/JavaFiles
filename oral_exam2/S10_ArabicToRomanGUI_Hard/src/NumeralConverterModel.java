/**
 * model class with static methods to be called by controller to change from roman numerals to arabic and vice verse
 */
public class NumeralConverterModel {

    /**
     * string array holding the unit values of the roman numerals, from 1 to 9
     */
    private static final String[] units = {"I","II","III","IV","V","VI","VII","VIII","IX"};

    /**
     * string array holding the tens values of the roman numerals, 10,20,.....,90
     */
    private static final String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};

    /**
     * string array holding the hundreds values of the roman numerals, 100, 200, ........, 9000
     */
    private static final String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};

    /**
     * string holding the thousand value in roman numeral
     */
    private static final String thousands = "M";

    /**
     * no argument constructor with no process in it since no object of this class is instantiated
     */
    public NumeralConverterModel(){}

    /**
     * method to convert from arabic to roman numerals
     * @param Arabic string holding the value to transform to roman
     * @return string holding the roman numeral equivalent
     * @throws Exception when the arabic numeral is invalid
     */
    public static String convertArabicToRoman(String Arabic) throws Exception {

        if (Arabic.length()<1){
            throw new Exception(); //throw exception when the passed in string is a null string
        }


        int value = Integer.parseInt(Arabic); //get the value in int from the passed in string
        String romanNumeral = ""; //string that will hold the numeral to be returned

        if (value <= 0 || value > 3999 || Arabic.charAt(0) == '0' ){ //if character is invalid because it out of range or starts with a 0
            System.out.print(Arabic.charAt(0));
            throw new Exception(); //return exception when passed in Arabic number is outside of bounds or begins with a 0

        }


        while(value != 0 ){  //continue in this loop until value has reached 0
            if (value >= 1000){ //if value has thousands units
                for (int i = 1; i <= value/1000; i++){
                    romanNumeral += thousands; //add the thousand numerals
                }
                value = value%1000;
            }
            else if (value >= 100){ //set the hundreds  on the roman numeral
                romanNumeral += hundreds[value/100-1];
                value = value%100;
            }
            else if (value >= 10){ //set the tens numerals on the roman numeral
                romanNumeral += tens[value/10-1];
                value = value%10;
            }
            else { //set the units on the roman numerals
            romanNumeral += units[value-1];
            value = 0;}

        }
        return romanNumeral;
    }

    /**
     * method to convert roman numeral to arabic
     * @param romanNumeral roamn numeral to be converted to arabic
     * @return string holding the arabic numeral equivalent
     * @throws Exception whenever conversion could not occur because passed in roman numeral is invalid
     */
    public static String convertRomanToArabic(String romanNumeral) throws Exception {

        String savedCopy = romanNumeral;

        if (romanNumeral.length() == 0 ){ //if empty passed in string throw exception
            throw new Exception();
        }

       int  value = 0; //start the value to 0
        romanNumeral+=" "; // add a final space to the passed in string, this will mark the end of the numeral and allow the method to loop over the entire numeral

        while(romanNumeral.length() > 1){ //loop over the roman numeral and update the int value and also read in the roman numerals units and delete it once its read

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
                throw new Exception(); //throw exception for invalid character
            }

        }

        //validate passed in roman numeral, if it is invalid throw exception
        if (convertArabicToRoman(String.valueOf(value)).equals(savedCopy)){ //if passed in roman numeral is not in the right format throw exception
            return String.valueOf(value);
        }
        else{
            throw new Exception();
        }
    }
}

