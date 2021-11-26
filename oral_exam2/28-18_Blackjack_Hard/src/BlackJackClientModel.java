import java.awt.*;

public class BlackJackClientModel {

    public BlackJackClientModel(){}

    public static void showCard(TextArea cardArea, String cardName){

        cardArea.setText(cardName);
        cardArea.setVisible(true);

    }

    public static void displayCardsOnTable(TextArea[] cardAreas, int numberOfCards, Cards cardToShow){

        //cardAreas[numberOfCards].setText(cardToShow);
        cardAreas[numberOfCards].setVisible(true);
    }

}
