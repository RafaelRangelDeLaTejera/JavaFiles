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

    public int getCardValue(int index) {
        return deck[index].getValue();
    }

    public String getCardName(int index){
        if (index == 0| index == 13|index == 26|index == 39){
            return "Ace of " + deck[index].getType();
        }
        else if (index == 10| index == 23 |index ==36 |index==49){
            return "Jack of " + deck[index].getType();
        }
        else if (index == 11|index == 24|index==37|index == 50){
            return "Queen of " + deck[index].getType();
        }
        else if (index == 12|index == 25|index == 38|index == 51){
            return "King of " + deck[index].getType();
        }
        else {
            return deck[index].getValue() + " of " + deck[index].getType();
        }
    }

    public class Cards {
        private String type;
        private int value;

        public Cards(String type, int value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
