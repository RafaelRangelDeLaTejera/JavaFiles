import java.util.Random;

public class BlackJackModel {

    private Deck gameDeck;
    private Random randomNumber = new Random();//object to create random numbers to draw cards

    public BlackJackModel() {
        gameDeck = new Deck();
    }

    public Cards drawCard(){
        return gameDeck.getDeck()[randomNumber.nextInt(52)];
    }
}
//ideas
//compare with a hash table to see if card has already been drawn