public class Deck {
    private Cards[] deck = new Cards[52];

    public Deck() {
        //this game will be played with one standard deck
        for (int i = 1; i <= 13; i++) {
            if (i == 1){ //give all ace cards a default value of 11
                deck[i - 1] = new Cards("Spades", 11);
                deck[i + 12] = new Cards("Clubs", 11);
                deck[i + 25] = new Cards("Hearts", 11);
                deck[i + 38] = new Cards("Diamonds", 11);
            } //set the rest of the card values
            else if (i<11){
                deck[i - 1] = new Cards("Spades", i);
                deck[i + 12] = new Cards("Clubs", i);
                deck[i + 25] = new Cards("Hearts", i);
                deck[i + 38] = new Cards("Diamonds", i);
            }
            else {
                deck[i - 1] = new Cards("Spades", 10);
                deck[i + 12] = new Cards("Clubs", 10);
                deck[i + 25] = new Cards("Hearts", 10);
                deck[i + 38] = new Cards("Diamonds", 10);
            }

        }
    }

    public Cards[] getDeck() {
        return deck;
    }
}
