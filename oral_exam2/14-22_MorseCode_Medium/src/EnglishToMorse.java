public class EnglishToMorse {

    //private String encodedPhrase;
    private static final String[] code = {"-----",".----",
            "..---","...--","....-",".....","-....","--...","---..","----.",".-","=...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


    public EnglishToMorse() {
        //encodedPhrase = "";
    }

    public String encodeToMorse(String englishPhrase){

        String encodedPhrase = "";

        for(int i = 0; i < englishPhrase.length(); i++){
            if (englishPhrase.charAt(i) == ' '){
                encodedPhrase += "  ";

            }
            else {
                int characterIndex = englishPhrase.charAt(i);
                System.out.print(characterIndex + " ");
                if (characterIndex >= 65 && characterIndex <= 90){
                    encodedPhrase = encodedPhrase + code[characterIndex-55] + " ";
                }
                else if (characterIndex >= 48 && characterIndex <= 57){
                    encodedPhrase = encodedPhrase + code[characterIndex-48] + " ";
                }
                else if (characterIndex >= 97 && characterIndex <= 122){
                    encodedPhrase = encodedPhrase + code[characterIndex-87] + " ";
                }
                else {
                    encodedPhrase = encodedPhrase + englishPhrase.substring(i,i);
                }
            }
        }
        return encodedPhrase;
    }

    public String decipherToEnglish(String code){
        String englishWord = "";
        String singleCharacter = "";

        for (int i = 0; i < code.length(); i ++){
            if (code.charAt(i) != ' '){
                singleCharacter+=code.charAt(i);
            }
            else if ((i+1) < code.length() && (i+2) < code.length()){
                if (code.charAt(i) == ' ' && code.charAt(i+1)==' ' && code.charAt(i+2) == ' '){
                    englishWord+=convertCodedChar(singleCharacter);
                    singleCharacter = "";
                    englishWord+=' ';
                    i+=2;

                }
                else if (code.charAt(i) == ' '){
                englishWord+=convertCodedChar(singleCharacter);
                singleCharacter = "";
                }
            }




//            while (code.charAt(i) != ' '){
//                singleCharacter+=code.charAt(i);
//            }
        }

        englishWord+=convertCodedChar(singleCharacter);

        return englishWord;
    }

    public int findIndexOfCode(String findThis){
        int e = 0;
        while (e < code.length){
            if (findThis.equals(code[e])){
                return e;
            }
            e++;
        }
        return -1;
    }

    public char convertCodedChar(String codedChar){
        int index = findIndexOfCode(codedChar);

        if (index >= 0 && index <= 9){
            index +=48;
        }
        else if (index >= 10 && index <= 35){
            index +=87;
        }

        return (char)index;
    }
}
