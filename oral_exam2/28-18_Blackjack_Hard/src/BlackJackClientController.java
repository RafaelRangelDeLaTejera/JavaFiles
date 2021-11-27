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

public class BlackJackClientController implements Runnable{

    //this streams will only write strings to be read by the server
    public ObjectOutputStream output; // output stream to server
    public ObjectInputStream input; // input stream from server
    public String hostName; // host server for this application
    private Socket connection; // socket to communicate with server
    public boolean isGame = true ;



    private TextArea[] playerCardAreas;
    private TextArea[] dealerCardAreas;



    @FXML
    private Button hitButton;

    @FXML
    private Button stayButton;

    @FXML
    private Button doubleButton;

    @FXML
    private TextField betAvailable;

    @FXML
    private TextField playerTotal;

    @FXML
    private TextField dealerTotal;

    @FXML
    private TextField bet;

    @FXML
    private Button playAgainButton;

    @FXML
    private Text textForUser;

    @FXML
    private TextArea card1;

    @FXML
    private TextArea card2;

    @FXML
    private TextArea card3;

    @FXML
    private TextArea card4;

    @FXML
    private TextArea card5;

    @FXML
    private TextArea card6;

    @FXML
    private TextArea card7;

    @FXML
    private TextArea card8;

    @FXML
    private TextArea card9;

    @FXML
    private TextArea card10;

    @FXML
    private TextArea card11;

    @FXML
    private TextArea card12;


    @FXML
    private TextArea dealerCard1;

    @FXML
    private TextArea dealerCard2;

    @FXML
    private TextArea dealerCard3;

    @FXML
    private TextArea dealerCard4;

    @FXML
    private TextArea dealerCard5;

    @FXML
    private TextArea dealerCard6;

    @FXML
    private Text headerYourCards;

    @FXML
    private Text headerDealerCards;


    @FXML
    public void initialize() {


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

    @FXML
    void playAgainPressed(ActionEvent event) {

        try {
            output.writeObject("playAgain");
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        playAgainButton.setVisible(false);
        doubleButton.setVisible(true);
        hitButton.setVisible(true);
        stayButton.setVisible(true);
        headerYourCards.setVisible(true);
        headerDealerCards.setVisible(true);

    }

    @FXML
    void doublePressed(ActionEvent event) {
        try {
            output.writeObject("double");
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @FXML
    void hitPressed(ActionEvent event) {
        try {
            output.writeObject("hit");
            output.flush();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @FXML
    void stayPressed(ActionEvent event) {
        try {
            output.writeObject("stay");
            output.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }




    @Override
    public void run() {

        System.out.print("in run");
        //HashMap<String,Integer> messageFromServer;
        Deck referenceDeck = new Deck();
        int playerCards = 0; //keep track of the cards the player has
        int dealerCards = 0; //keep track of the cards the dealer has
        int indexDownwardCard;
        int numberDownwardCardArea;


        while (isGame){

            System.out.print("inside run while loop");
            try {
                System.out.print("in run");

                HashMap<String,Integer> messageFromServer = (HashMap<String, Integer>) input.readObject();

//                if(!messageFromServer.containsKey("keyPlayerCard")){ //when no card is passed in it means that turn has ended, the player can chose if they play again
//                    playAgainButton.setVisible(true);
//
//                    //when no card is drawn it means the game is over so hide all the game option buttons
//                    doubleButton.setVisible(false);
//                    hitButton.setVisible(false);
//                    stayButton.setVisible(false);
//                    for(int i = 0; i < playerCardAreas.length ; i++){ //hide all the cards
//                        playerCardAreas[i].setVisible(false);
//                    }
//                    for(int e = 0; e < dealerCardAreas.length; e++){ //hide all the cards
//                        dealerCardAreas[e].setVisible(false);
//                    }
//                }
                if (messageFromServer.containsKey("keyDownwardCard")){ //first draw
                    textForUser.setText("Game in progress, pick your option");
                    betAvailable.setText("Available to Bet: " + messageFromServer.get("keyBetAvailable"));
                    bet.setText("Bet: " + messageFromServer.get("keyBet"));
                    dealerTotal.setText("Dealer Total: " + messageFromServer.get("keyDealerTotal"));
                    playerTotal.setText("Player total: " + messageFromServer.get("keyPlayerTotal"));

//                    //show the drawn cards
                        playerCardAreas[playerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyPlayerCard")));
                        playerCardAreas[playerCards].setVisible(true);
                        playerCards++;

                    dealerCardAreas[dealerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyDealerCard")));
                    dealerCardAreas[dealerCards].setVisible(true);
                    dealerCards++;

                    numberDownwardCardArea = dealerCards;
                    indexDownwardCard = messageFromServer.get("keyDownwardCard");
                    dealerCardAreas[numberDownwardCardArea].setText("Back of Card");
                    dealerCardAreas[numberDownwardCardArea].setVisible(true);
                }
                else if (messageFromServer.containsKey("keyTurnEnded")){

                }
                else if (messageFromServer.containsKey("keyPlayerCard")){
                    playerCardAreas[playerCards].setText(referenceDeck.getCardName(messageFromServer.get("keyPlayerCard")));
                    playerCardAreas[playerCards].setVisible(true);
                    playerCards++;
                }
                else {
                    textForUser.setText("Game in progress, pick your option");
                    betAvailable.setText("Available to Bet: " + messageFromServer.get("keyBetAvailable"));
                    bet.setText("Bet: " + messageFromServer.get("keyBet"));
                    dealerTotal.setText("Dealer Total: " + messageFromServer.get("keyDealerTotal"));
                    playerTotal.setText("Player total: " + messageFromServer.get("keyPlayerTotal"));
                }

            } catch (IOException | ClassNotFoundException ioException) {
                System.out.print("connection lost");
            }


        }

    }

    public void startClient(){

        try // connect to server and get streams yes
        {

            // make connection to server
            connection = new Socket(
                    InetAddress.getByName(hostName), 23765);
            System.out.print("connected");
            // get streams for input and output
            // set up output stream for objects
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush(); // flush output buffer to send header information

            // set up input stream for objects
            input = new ObjectInputStream(connection.getInputStream());
            System.out.print("end of start client method");


        }
        catch (IOException eofException) {
            textForUser.setText("\nServer not found ");
        }




    }

    public  void closeConnection(){
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    
}

