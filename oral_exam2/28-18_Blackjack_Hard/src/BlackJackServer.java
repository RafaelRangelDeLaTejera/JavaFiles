import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BlackJackServer class that extends the JFrame class, so it works as a server application to which clients will establish a connection with to play blackJack, the
 * server runs all the logic of the game while the client updates the GUI as needed
 */
public class BlackJackServer extends JFrame {


    /**
     * total players int member to hold the total amount of player clients connected to the server
     */
    private  int totalPlayers = 0;

    /**
     * ArrayList of type players, this will hold all of the player client threads that have connected the server
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * ServerSocket to listen to clients and establish connections
     */
    private ServerSocket dealer;

    /**
     * Executor service object to create the thread pool for all the connected clients, each has its own player thread
     */
    private ExecutorService game;

    /**
     * JTextArea game details which is the only component of the server gui to display what the players are doing
     */
    private JTextArea gameDetails;

    /**
     * BlackJackServer constructor that sets up the gui and initializes the server socket with a specific port and limits the connection queue to 100
     */
    public BlackJackServer() {
        super("Server"); //call the super class constructor to start the gui

        gameDetails = new JTextArea(); // create enterField
        gameDetails.setEditable(false);
        gameDetails.setText("Sever opened");
        add(new JScrollPane(gameDetails), BorderLayout.CENTER);
        setSize(150, 150); // set size of window
        setVisible(true); // show window

        gameDetails.setText("Waiting for connection\n");
        game = Executors.newCachedThreadPool();

        try {
            dealer = new ServerSocket(23765, 100); // set up ServerSocket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * method to be called in the main method once the GUI is set up. this will Start the server and started listening for connections, it will accept client connections
     * and execute that player thread for each client connected
     */
    public void startServer(){
        while(true){
            try // wait for connection, create Player, start runnable
            {
                players.add(new Player(dealer.accept()));
                game.execute(players.get(totalPlayers-1)); // execute player runnable
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

    }

    /**
     * private inner class Player that implements Runnable interface to manage each Player as a thread so that clients can run in parallel
     */
    public  class Player implements Runnable {

        /**
         * socket to establish connection with client
         */
        private Socket connection;

        /**
         * input stream that will read a string from client according to the user interaction with the GUI
         */
        private ObjectInputStream input;

        /**
         * output stream that will write a hash map with keys indicating the client what to display on the GUI
         */
        private ObjectOutputStream output;


        /**
         * player constructor, it establishes a connection with the servers using the passed in socket, it also starts the streams from the socket
         * @param connection this socket will be used to connect with the clients
         */
        public Player(Socket connection) {
            this.connection = connection;

            totalPlayers++; //add to the number of players

            try // obtain streams from Socket
            {
                input = new ObjectInputStream(connection.getInputStream());
                output = new ObjectOutputStream(connection.getOutputStream());

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

        /**
         * overriden run method that implements the logic of the game. This method is constantly trying to read from the client and when it reads in
         * from the input stream it used the read in String to perform a certain operation and then send write a hashmap to the client using the output
         * stream, this map will contain keys with values the client will use to determine what to do. Each key indicates something to do and the values
         * are used to update GUI stats
         */
        @Override
        public void run() {

            gameDetails.setText(gameDetails.getText()+ totalPlayers +"Player " + " connected\n");

            //initial conditions for game
            int playerTotal = 0;
            int dealerTotal = 0;
            int playerBettingLot = 10;
            int bet = 0;
            boolean turnPlayer = false;
            //Cards CardDrawn;
            Deck gameDeck = new Deck();
            HashSet<Integer> usedCards = new HashSet<>();
            Random randomNumber = new Random();
            int indexDownwardCard = randomNumber.nextInt(52); //initialize to compile


            String message;
            try{
                while (true) {

                    try {

                        if(turnPlayer){ //if the player has started their turn, first do this to set up the game

                            //draw cards for player and dealer using the random number generator, while loops combined with a hash set containing the used cards indexes are used to make sure cards  are not repeated in a turn since each client is playing with one standard deck
                            int indexPlayerCard = randomNumber.nextInt(52);

                            while (usedCards.contains(indexPlayerCard)) {
                                indexPlayerCard = randomNumber.nextInt(52);
                            }
                            usedCards.add(indexPlayerCard);

                            int indexDealerCard = randomNumber.nextInt(52);
                            while (usedCards.contains(indexDealerCard)) {
                                indexDealerCard = randomNumber.nextInt(52);
                            }
                            usedCards.add(indexDealerCard);

                             indexDownwardCard = randomNumber.nextInt(52);
                            while (usedCards.contains(indexDownwardCard)) {
                                indexDownwardCard = randomNumber.nextInt(52);
                            }
                            usedCards.add(indexDownwardCard);

                            //update player, dealer totals, bet and betting lot available
                            playerTotal += gameDeck.getCardValue(indexPlayerCard);
                            dealerTotal += gameDeck.getCardValue(indexDealerCard);
                            bet++;
                            playerBettingLot--;

                            HashMap<String,Integer> information = new HashMap<>(); //declare and initialize new hashmap to pass in the information for the client to update the GUI
                            //initial conditions to start game
                            information.put("keyPlayerTotal", playerTotal);
                            information.put("keyDealerTotal", dealerTotal);
                            information.put("keyBetAvailable", playerBettingLot);
                            information.put("keyBet", bet);
                            information.put("keyPlayerCard", indexPlayerCard);
                            information.put("keyDealerCard", indexDealerCard);
                            information.put("keyDownwardCard",indexDownwardCard); //this downward card indicates its the first draw

                            //send data to client
                            output.writeObject(information);
                            output.flush();

                            turnPlayer = false; //indicate the initial set up was completed
                        }
                        else {

                        message = (String) input.readObject(); //read in from the client and indicate on the server GUI what the player pressed
                        gameDetails.setText(gameDetails.getText() + "\n" + message);

                        if(message.equals("double")){ //if the player pressed the double button in the client app

                            //double the bet
                            playerBettingLot -=bet;
                            bet *= 2;

                            HashMap<String,Integer> information = new HashMap<>(); //declare and initialize new hashmap to pass in the information for the client to update the GUI
                            information.put("keyPlayerTotal", playerTotal);
                            information.put("keyDealerTotal", dealerTotal);
                            information.put("keyBetAvailable", playerBettingLot);
                            information.put("keyBet", bet);

                            //send data to client
                            output.writeObject(information);
                            output.flush();
                        }
                        if(message.equals("hit")){ //if player pressed hit button

                            //draw a new card for player
                            int newIndexPlayerCard = randomNumber.nextInt(52);
                            while (usedCards.contains(newIndexPlayerCard)) {
                                newIndexPlayerCard = randomNumber.nextInt(52);
                            }
                            usedCards.add(newIndexPlayerCard);

                            playerTotal += gameDeck.getCardValue(newIndexPlayerCard);

                            if (playerTotal == 21 ){ //if the player reaches 21 they win
                                playerBettingLot += bet*2;
                            }


                            HashMap<String,Integer> information = new HashMap<>(); //declare and initialize new hashmap to pass in the information for the client to update the GUI


                                information.put("keyPlayerTotal", playerTotal);
                                information.put("keyDealerTotal", dealerTotal);
                                information.put("keyBetAvailable", playerBettingLot);
                                information.put("keyBet", bet);
                                information.put("keyPlayerCard", newIndexPlayerCard); //this key will specify the client that a new card was drawn


                            output.writeObject(information);
                            output.flush();


                        }
                        if(message.equals("stay")){ //ends the players turn

                            dealerTotal += gameDeck.getCardValue(indexDownwardCard); //add the value of the card that was upside down

                            if (dealerTotal >= 17){
                                HashMap<String, Integer> information = new HashMap<>();
                                information.put("keyPlayerTotal", playerTotal);
                                information.put("keyDealerTotal", dealerTotal);
                                information.put("keyBetAvailable", playerBettingLot);
                                information.put("keyBet", bet);
                                information.put("keyDealerCard", -1); //this key with the value -1 will indicate the client to flip the upside down card

                                output.writeObject(information);
                                output.flush();
                            }
                            else {
                            while  (dealerTotal < 17) //draw a card for the dealer and send it until dealer total is greater than 17
                                {
                                    int newIndexDealerCard = randomNumber.nextInt(52);

                                    while (usedCards.contains(newIndexDealerCard)) {
                                        newIndexDealerCard = randomNumber.nextInt(52);
                                    }
                                    usedCards.add(newIndexDealerCard);

                                    dealerTotal += gameDeck.getCardValue(newIndexDealerCard);

                                    HashMap<String, Integer> information = new HashMap<>();
                                    information.put("keyPlayerTotal", playerTotal);
                                    information.put("keyDealerTotal", dealerTotal);
                                    information.put("keyBetAvailable", playerBettingLot);
                                    information.put("keyBet", bet);
                                    information.put("keyDealerCard", newIndexDealerCard); //this key will indicate have the upside down card faced up and draw a new card

                                    output.writeObject(information);
                                    output.flush();
                                }
                            }

                            HashMap<String, Integer> information = new HashMap<>(); //new hash map to write for client


                            if (playerTotal == 21 | (playerTotal < 21 && playerTotal >= dealerTotal) | dealerTotal > 21){ //if player wins give him the prize bet
                                playerBettingLot += bet*2;
                            }

                            bet=0;
                            information.put("keyPlayerTotal", playerTotal);
                            information.put("keyDealerTotal", dealerTotal);
                            information.put("keyBetAvailable", playerBettingLot);
                            information.put("keyBet", bet);
                            information.put("keyTurnEnded",1); //indication to end the turn

                            output.writeObject(information);
                            output.flush();

                        }
                        if (message.equals("playAgain")){ //if player presses the play again button

                            usedCards = new HashSet<>(); //start again with a complete deck

                            turnPlayer = true; //to set up the game before the turn

                            //reset stats
                            playerTotal = 0;
                            dealerTotal = 0;
                            bet = 0;
                        }
                        }


                    } catch (ClassNotFoundException exception) {
                        exception.printStackTrace();
                    }
                }
            }
            catch (IOException ioException){
                ioException.printStackTrace();
            }
            finally{
                closeConnection();
            }
        }

        /**
         * close connection method to close the socket and streams when the server is turned off
         */
        private void closeConnection() {
            gameDetails.setText(gameDetails.getText()+"\nTerminating connection with player \n");

            try {
                output.close(); // close output stream
                input.close(); // close input stream
                connection.close(); // close socket

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
