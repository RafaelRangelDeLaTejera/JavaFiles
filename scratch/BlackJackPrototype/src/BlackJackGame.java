import java.util.Random;

public class BlackJackGame {

    private Deck gameDeck;
    private Random randomNumber = new Random();//object to create random numbers to draw cards
    private boolean startOfGame;

    public BlackJackGame() {
        gameDeck = new Deck();
        startOfGame = true;
    }

    public Cards drawCard(){
        return gameDeck.getDeck()[randomNumber.nextInt(52)];
    }

    public boolean isStartOfGame() {
        return startOfGame;
    }

    public void setStartOfGame(boolean startOfGame) {
        this.startOfGame = startOfGame;
    }
}
//ideas
//compare with a hash table to see if card has already been drawn