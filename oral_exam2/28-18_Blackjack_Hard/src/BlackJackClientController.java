import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *controller class for the BlackJackClient fxml file, this contains the event handlers for the GUI elements and it also
 * is the networking client runnable class, which is why it implements the Runnable interface
 */
public class BlackJackClientController implements Runnable{

    /**
     * output stream to server, the client send strings to the server that will indicate it what to do
     */
    private ObjectOutputStream output;

    /**
     * input stream from server, the server receives a hashmap from the server with specific keys to indicate the client what to do
     */
    private ObjectInputStream input;

    /**
     * the name of the host server for this application
     */
    private String hostName;

    /**
     * socket to communicate with server
     */
    private Socket connection;

    /**
     * controlling variable of the while loop inside the run method
     */
    private boolean isGame = true ;

    /**
     * array that hold the text areas in the GUI to display the players cards
     */
    private TextArea[] playerCardAreas;

    /**
     * array that hold the text areas in the GUI to display the dealers cards
     */
    private TextArea[] dealerCardAreas;

    /**
     * button in the JavaFX GUI with hit as default text
     */
    @FXML
    private Button hitButton;

    /**
     * stay button from the JavaFX GUI field
     */
    @FXML
    private Button stayButton;

    /**
     * double button from the Java FX GUI
     */
    @FXML
    private Button doubleButton;

    /**
     * text field to display the amount the player has available to bet
     */
    @FXML
    private TextField betAvailable;

    /**
     * text field that displays the user card sum
     */
    @FXML
    private TextField playerTotal;

    /**
     * text field that displays the dealers card sum, it does not consider the upside down card unless it has been flipped
     */
    @FXML
    private TextField dealerTotal;

    /**
     * text field that displays the amount the user bet
     */
    @FXML
    private TextField bet;

    /**
     * playAgain button which the player presses to play the game whenever they are not currently in a game
     */
    @FXML
    private Button playAgainButton;

    /**
     * text that will display brief information of what is happening in the game so the user dosnt get lost
     */
    @FXML
    private Text textForUser;

    /**
     * text area to hold the first player card when drawn
     */
    @FXML
    private TextArea card1;

    /**
     * text area to hold the second player card when drawn
     */
    @FXML
    private TextArea card2;

    /**
     *text area to hold the third player card when drawn
     */
    @FXML
    private TextArea card3;

    /**
     *text area to hold the fourth player card when drawn
     */
    @FXML
    private TextArea card4;

    /**
     *text area to hold the fifth player card when drawn
     */
    @FXML
    private TextArea card5;

    /**
     *text area to hold the sixth player card when drawn
     */
    @FXML
    private TextArea card6;

    /**
     *text area to hold the seventh player card when drawn
     */
    @FXML
    private TextArea card7;

    /**
     *text area to hold the eight player card when drawn
     */
    @FXML
    private TextArea card8;

    /**
     *text area to hold the ninth player card when drawn
     */
    @FXML
    private TextArea card9;

    /**
     *text area to hold the tenth player card when drawn
     */
    @FXML
    private TextArea card10;

    /**
     *text area to hold the eleventh player card when drawn
     */
    @FXML
    private TextArea card11;

    /**
     *text area to hold the twelfth player card when drawn
     */
    @FXML
    private TextArea card12;

    /**
     *text area to hold the first dealer card when drawn
     */
    @FXML
    private TextArea dealerCard1;

    /**
     *text area to hold the second dealer card when drawn
     */
    @FXML
    private TextArea dealerCard2;

    /**
     *text area to hold the third dealer card when drawn
     */
    @FXML
    private TextArea dealerCard3;

    /**
     *text area to hold the fourth dealer card when drawn
     */
    @FXML
    private TextArea dealerCard4;

    /**
     *text area to hold the fifth dealer card when drawn
     */
    @FXML
    private TextArea dealerCard5;

    /**
     *text area to hold the sixth dealer card when drawn
     */
    @FXML
    private TextArea dealerCard6;

    /**
     *text above the player cards indicating those are their cards
     */
    @FXML
    private Text headerYourCards;

    /**
     * text above the dealer cards indicating those are the dealers cards
     */
    @FXML
    private Text headerDealerCards;

    /**
     * initialize method implementation to get the gui ready for the game. This method will be called once the content from the fxml file has been properly loaded
     */
    @FXML
    public void initialize() {

        //fill the text areas arrays with the TextArea members from the fxml file
        playerCardAreas = new TextArea[]{card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12};
        dealerCardAreas = new TextArea[]{dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5, dealerCard6};

        //set up the GUI with no cards showing
        for(int i = 0; i < playerCardAreas.length ; i++){
            playerCardAreas[i].setVisible(false);
        }
        for(int e = 0; e < dealerCardAreas.length; e++){
            dealerCardAreas[e].setVisible(false);
        }

        //and also not showing the buttons and card headers, only the play button
        doubleButton.setVisible(false);
        hitButton.setVisible(false);
        stayButton.setVisible(false);
        headerDealerCards.setVisible(false);
        headerYourCards.setVisible(false);



    }

    //on action methods

    /**
     * on action method for the playAgain button, this button will be pressed everytime the user want to start a new game, the user start over except for the betting lot they have
     * @param event button pressed
     */
    @FXML
    void playAgainPressed(ActionEvent event) {



        try {
            output.writeObject("playAgain"); // send the playAgain string instruction to the server
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }




    }

    /**
     * on action method for the double button, when the user presses this the client thread will send the indication to the server to double the bet
     * @param event button pressed
     */
    @FXML
    void doublePressed(ActionEvent event) {
        try {
            output.writeObject("double"); //send string to server to perform operation assigned to specific string
            output.flush();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    /**
     * on action method activated when the user pressed the hit button, this method will then send a message for the server to draw a new card from the deck
     * @param event button pressed
     */
    @FXML
    void hitPressed(ActionEvent event) {
        try {
            output.writeObject("hit"); //send string to server to perform operation assigned to specific string
            output.flush();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * on action method activated by the user pressing the stay Button, this will indicate the server to end the game summarize stats and then send them to the client to display in the gui
     * @param event button pressed
     */
    @FXML
    void stayPressed(ActionEvent event) {
        try {
            output.writeObject("stay");
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * run method for the thread of the client controller created in the app class, this will be called to execute the thread and do all necessary processing while the game is still going
     */
    @Override
    public void run() {

        Deck referenceDeck = new Deck(); //deck to use as reference for card names
        int playerCards = 0; //keep track of the cards the player has, this will also indicate which new card field to occupy
        int dealerCards = 0; //keep track of the cards the dealer has
        int indexDownwardCard = 0; //card index from deck for the upside down card
        int numberDownwardCardArea = 1; //index of the card area assigned to the upside down card
        boolean endOfTurn = false; //boolean that will indicate if the current turn has ended


        while (isGame){ //while the application is still running, dont stop this thread

            try {

                HashMap<String,Integer> messageFromServer = (HashMap<String, Integer>) input.readObject(); //hash map to read in the servers instructions

                if (messageFromServer.containsKey("keyDownwardCard")){ //first draw to start the game

                    try {
                        //set up the GUI with no cards showing
                        for(int i = 0; i < playerCardAreas.length ; i++){
                            playerCardAreas[i].setVisible(false);
                            playerCardAreas[i].clear();
                        }
                        for(int e = 0; e < dealerCardAreas.length; e++){
                            dealerCardAreas[e].setVisible(false);
                            dealerCardAreas[e].clear();
                        }

                        playAgainButton.setVisible(false);
                        doubleButton.setVisible(true);
                        hitButton.setVisible(true);
                        stayButton.setVisible(true);
                        headerYourCards.setVisible(true);
                        headerDealerCards.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace(); //in case the Gui is not properly set up when this method attempts to modify it
                    }

                    textForUser.setText("Game in progress, pick your option");
                    betAvailable.setText("Available to Bet: " + messageFromServer.get("keyBetAvailable"));
                    bet.setText("Bet: " + messageFromServer.get("keyBet"));
                    dealerTotal.setText("Dealer Total: " + messageFromServer.get("keyDealerTotal"));
                    playerTotal.setText("Player total: " + messageFromServer.get("keyPlayerTotal"));

                   //show the drawn cards
                    playerCardAreas[playerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyPlayerCard")));
                    playerCardAreas[playerCards].setVisible(true);
                    playerCards++;

                    //show the dealers drawn card
                    dealerCardAreas[dealerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyDealerCard")));
                    dealerCardAreas[dealerCards].setVisible(true);
                    dealerCards+=2;

                    //and show the back of the drawn upside down card from the dealer
                    numberDownwardCardArea = 1;
                    indexDownwardCard = messageFromServer.get("keyDownwardCard");
                    dealerCardAreas[numberDownwardCardArea].setText("Back of Card");
                    dealerCardAreas[numberDownwardCardArea].setVisible(true);

                }
                else if (messageFromServer.containsKey("keyPlayerCard")){ //this means a new card was drawn

                    //display that new drawn card from the server
                    playerCardAreas[playerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyPlayerCard")));
                    playerCardAreas[playerCards].setVisible(true);
                    playerCards++;

                    //update player total
                    playerTotal.setText("Player total: " + messageFromServer.get("keyPlayerTotal"));

                    //end turn if player has a blackjack or they busted
                    if(messageFromServer.get("keyPlayerTotal") >= 21){
                        endOfTurn = true;
                    }
                }
                else if (messageFromServer.containsKey("keyDealerCard")){ // this means that either a new card was drawn for the dealer or the upside down card needs to be flipped , meaning that the players turn ended

                    //turn the upside down card around
                    dealerCardAreas[numberDownwardCardArea].setText(referenceDeck.getCardName(indexDownwardCard)); //turn downward card around

                    if (messageFromServer.get("keyDealerCard") != -1){ //if the card is a valid index, meaning a card was drawn from the server, if not then the card was just turned around
                        dealerCardAreas[dealerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyDealerCard")));
                        dealerCardAreas[dealerCards].setVisible(true);
                        dealerCards++;
                    }

                }
                else if (messageFromServer.containsKey("keyTurnEnded")){ //end turn if this key was sent by the server
                    endOfTurn = true;
                }
                else  { //update the fields  if the player doubled

                    try {
                        textForUser.setText("Game in progress, pick your option");
                        betAvailable.setText("Available to Bet: " + messageFromServer.get("keyBetAvailable"));
                        bet.setText("Bet: " + messageFromServer.get("keyBet"));
                        dealerTotal.setText("Dealer Total: " + messageFromServer.get("keyDealerTotal"));
                        playerTotal.setText("Player total: " + messageFromServer.get("keyPlayerTotal"));
                        doubleButton.setVisible(false);//you can only double once
                    } catch (Exception e) {
                        e.printStackTrace(); //in case the gui could not be updated
                    }
                }

                if (endOfTurn){

                    //reset certain fields
                    playerCards = 0;
                    dealerCards = 0;
                    indexDownwardCard = 0; //to compile
                    numberDownwardCardArea = 1; //to compile

                    //hide all buttons except the play
                    try{
                        stayButton.setVisible(false);
                        hitButton.setVisible(false);
                        doubleButton.setVisible(false);
                        playAgainButton.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace(); //in case gui could not update
                    }


                    int playerFinalTotal = messageFromServer.get("keyPlayerTotal");
                    int dealerFinalTotal = messageFromServer.get("keyDealerTotal");

                    //display result message for player
                    if(playerFinalTotal == 21){
                        textForUser.setText("You have a blackJack! Congratulations, you win!");
                    }
                    else if ((playerFinalTotal < 21 && playerFinalTotal >= dealerFinalTotal) | dealerFinalTotal > 21){
                        textForUser.setText("Congratulations, you win!");
                    }
                    else if (playerFinalTotal > 21){
                        textForUser.setText("You Bust, the house automatically wins");
                    }
                    else {
                        textForUser.setText("The house wins");
                    }

                    //attack dept message if negative bet available
                    if (messageFromServer.get("keyBetAvailable") < 0){
                        textForUser.setText(textForUser.getText() + " Ups you have a dept with us");
                    }

                    //update fields
                    dealerTotal.setText("Dealer Total: " + dealerFinalTotal);
                    playerTotal.setText("Player total: " + playerFinalTotal);
                    bet.setText("Bet: ");
                    betAvailable.setText("Available to bet: " + messageFromServer.get("keyBetAvailable"));

                    endOfTurn = false; //reset to false in case the player want to play again
                }

            } catch (IOException | ClassNotFoundException ioException) {
                System.out.print("connection lost");
            }


        }

    }

    /**
     * method to start the client, this method will establish a connection with the server from the host provided by the
     * hostName field, it will also open the object output and input streams for server client communication
     */
    public void startClient(){

        try // connect to server and get streams yes
        {

            // make connection to server
            connection = new Socket(
                    InetAddress.getByName(this.getHostName()), 23765);

            // set up output stream for objects
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush(); // flush output buffer to send header information

            // set up input stream for objects
            input = new ObjectInputStream(connection.getInputStream());

        }
        catch (IOException eofException) {
            textForUser.setText("\nServer not found ");
        }




    }

    /**
     * method to be called once the application has stopped, it will close the connections and the input and output streams
     */
    public  void closeConnection(){
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    /**
     * getter for the host name member variable of type string
     * @return hostname string
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * setter for the host name string member since it is a private field
     * @param hostName to be assigned to the hostname String member
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     *setter for the isGame variable to be called when the application ends to stop the controller thread
     * @param isGame boolean to assing to the is Game member
     */
    public void setIsGame(Boolean isGame){
        this.isGame = isGame;
    }
}

