/**
 * Deck class, an object of this class can be used to simulate a real life french card deck, it contains an inner card class with attributes a normal card has
 */
public class Deck {

    /**
     * Final instance data member deck of type Cards array. Cards is the inner class. This deck holds the 52 card objects to be used as real life cards
     */
    private final Cards[] deck = new Cards[52];

    /**
     * Deck object no parameter constructor that initializes the deck member to the cards a normal deck holds, it assigns a type and a value to each card, Aces have
     * a value of 11 and royalty cards have a value of 10
     */
    public Deck() {
        //this game will be played with one standard deck
        for (int i = 1; i <= 13; i++) {
            if (i == 1){ //give all ace cards a default value of 11
                deck[i - 1] = new Cards("Spades", 11);
                deck[i + 12] = new Cards("Clubs", 11);
                deck[i + 25] = new Cards("Hearts", 11);
                deck[i + 38] = new Cards("Diamonds", 11);
            } //set the rest of the numerical card values
            else if (i<11){
                deck[i - 1] = new Cards("Spades", i);
                deck[i + 12] = new Cards("Clubs", i);
                deck[i + 25] = new Cards("Hearts", i);
                deck[i + 38] = new Cards("Diamonds", i);
            }
            else { //if its a royal card it will have a standard value of 10
                deck[i - 1] = new Cards("Spades", 10);
                deck[i + 12] = new Cards("Clubs", 10);
                deck[i + 25] = new Cards("Hearts", 10);
                deck[i + 38] = new Cards("Diamonds", 10);
            }

        }
    }

    /**
     * getter for the value of a specific card held in the deck array
     * @param index , the position on the array at which the card stands, of type int
     * @return the assign value of the card at the passed in index
     */
    public int getCardValue(int index) {
        return deck[index].getValue();
    }

    /**
     * getter for the name of a specific card held in deck array, this getter names the card when it is called
     * @param index , the position on the array at which the card stands, of type int
     * @return the name of the card according to its type and value
     */
    public String getCardName(int index){

        if (index == 0| index == 13|index == 26|index == 39){ //if the card is in the position an ace is
            return "Ace of " + deck[index].getType();
        }
        else if (index == 10| index == 23 |index ==36 |index==49){ //if the card is at the postion a jack is
            return "Jack of " + deck[index].getType();
        }
        else if (index == 11|index == 24|index==37|index == 50){//if its at a queens position
            return "Queen of " + deck[index].getType();
        }
        else if (index == 12|index == 25|index == 38|index == 51){//if its at a kings position
            return "King of " + deck[index].getType();
        }
        else {
            return deck[index].getValue() + " of " + deck[index].getType(); //if its a card with a number as its first name
        }
    }

    /**
     * inner Cards class, an object of this class is used to simulate a real life deck card, it holds a card type and value
     */
    public class Cards {

        /**
         * private member that holds the type of the card as a string
         */
        private String type;

        /**
         * private member to hold the value of the card
         */
        private int value;

        /**
         * Cards public constructor, it assigns the passed in type and value to the instance of the Cards object being created
         * @param type string to be assigned to the type of the card being constructed
         * @param value int value that will be assigned to the value of the constructed card
         */
        public Cards(String type, int value) {
            this.type = type;
            this.value = value;
        }

        /**
         * getter for the type of card, the type refers to the suit of the card
         * @return the type of the card as a String
         */
        public String getType() {
            return type;
        }

        /**
         * getter for the value of the card, this is used to access the value member from outside the deck class
         * @return int holding the value assigned to the card
         */
        public int getValue() {
            return value;
        }

    }
}
