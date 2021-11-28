/**
 * MorseCodeModel class, containst the static methods to be called by wither one of the Morse-English apps to either encode or decipher
 */
public class MorseCodeModel {

    /**
     * private static array that holds the morse code alphanumeric values, this will be mathed with the ASCII table of characters to translate or convert code to text and viceversa
     */
    private static final String[] code = {"-----",".----",
            "..---","...--","....-",".....","-....","--...","---..","----.",".-","=...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


    /**
     * no argument constructor, no process occurs here since no object will be instantiated in the apps
     */
    public MorseCodeModel() {}

    /**
     * static method to be called by the encode to Morse app to return the passed in characters in morse
     * @param englishPhrase string to be encoded
     * @return String with the encoded passed in string
     */
    public static String encodeToMorse(String englishPhrase){

        String encodedPhrase = ""; //start an empty string

        for(int i = 0; i < englishPhrase.length(); i++){ //loop over the whole word

            if (englishPhrase.charAt(i) == ' '){ //write spaces when a space is found
                encodedPhrase += "  ";

            }
            else { //look for corresponding character from the code array
                int characterIndex = englishPhrase.charAt(i); //save the current index of the read in character

                if (characterIndex >= 65 && characterIndex <= 90){ //if the character is a uppercase letter
                    encodedPhrase = encodedPhrase + code[characterIndex-55] + " ";
                }
                else if (characterIndex >= 48 && characterIndex <= 57){ //if its a number
                    encodedPhrase = encodedPhrase + code[characterIndex-48] + " ";
                }
                else if (characterIndex >= 97 && characterIndex <= 122){ //if its a lowerCase letter
                    encodedPhrase = encodedPhrase + code[characterIndex-87] + " ";
                }
                else {
                    encodedPhrase = encodedPhrase + englishPhrase.substring(i,i); //if its not a valid character to translate just attach it as it is
                }
            }
        }
        return encodedPhrase;
    }

    /**
     * this method is static fo the DecipherMorseCode app to call and translate given morse code into a normal alphanumeric string
     * @param code String to be deciphered
     * @return the deciphered string in normal characters
     */
    public static String decipherToEnglish(String code){
        String englishWord = "";
        String singleCharacter = ""; //to hold the single word

        for (int i = 0; i < code.length(); i ++){

            if (code.charAt(i) != ' '){ //if its a space attach a space to the single character
                singleCharacter+=code.charAt(i);
            }
            else if ((i+1) < code.length() && (i+2) < code.length()){
                if (code.charAt(i) == ' ' && code.charAt(i+1)==' ' && code.charAt(i+2) == ' ' && singleCharacter != ""){ //if the coded word has ended
                    englishWord+=convertCodedChar(singleCharacter); //convert coded character
                    singleCharacter = ""; //reset character
                    englishWord+=' '; //add a space
                    i+=2; //skip the spaces

                }
                else if (code.charAt(i) == ' ' && !singleCharacter.equals("")){ //if single character is not empty and there is a space
                englishWord+=convertCodedChar(singleCharacter);
                singleCharacter = ""; //reset the single character
                }
            }
        }

        englishWord+=convertCodedChar(singleCharacter); //convert last read in character

        return englishWord;
    }

    /**
     * static method to convert a single character from morse code to normal alphanumeric character using the ASCII table
     * @param codedChar character to decipher
     * @return alphanumeric character
     */
    public static char convertCodedChar(String codedChar){
        int index = -1; //initialize to value that does not represent an index of the code array just so the compiler allows for index to be used in if statement

        int e = 0; //variable to loop over the code array

        while (e < code.length){ //loop over the array
            if (codedChar.equals(code[e])){ //if the coded character matches with a code value
               index = e; //save that index
                e = code.length; //exit loop
            }
            e++; //to continue looping over array
        }

        if (index >= 0 && index <= 9){ //if the coded character is numeric
            index +=48; //go to the numbers on the ASCII table
        }
        else if (index >= 10 && index <= 35){ //if it is a letter
            index +=87; //go to the lowercase letters on the ASCII table
        }

        return (char)index;
    }
}

