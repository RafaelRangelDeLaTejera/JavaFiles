public class EnglishToMorse {

    private String encodedPhrase;
    private static final String[] code = {"-----",".----",
            "..---","...--","....-",".....","-....","--...","---..","----.",".-","=...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


    public EnglishToMorse() {
        encodedPhrase = "";
    }

    public String encodeToMorse(String englishPhrase){

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
}
