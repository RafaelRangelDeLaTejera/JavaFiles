public class Deck {
    private Cards[] deck = new Cards[52];

    public Deck() {
        for (int i = 1; i <= 13; i++) {
            deck[i - 1] = new Cards("Spades", i);
            deck[i + 12] = new Cards("Clubs", i);
            deck[i + 25] = new Cards("Hearts", i);
            deck[i + 38] = new Cards("Diamonds", i);
        }
    }

    public Cards[] getDeck() {
        return deck;
    }
}
