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

public class BlackJackServer extends JFrame {

    private  int totalPlayers = 0;
    private ArrayList<Player> players = new ArrayList<>();
    private ServerSocket dealer; // server socket to listen to clients and establich connections
    private ExecutorService game;
    private JTextArea gameDetails; // show messages about the game

    // set up simple GUI that will display the events of the game
    public BlackJackServer() {
        super("Server");

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


    // private inner class Player manages each Player as a runnable so that program can run in parallel
    public  class Player implements Runnable {
        private Socket connection; // connection to client
        //these streams will write arrays to the clients
        private ObjectInputStream input; // input from client
        private ObjectOutputStream output; // output to client
        private boolean isGameOver = false;
        //private HashMap<String,Integer> information = new HashMap<>();

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
                while (!isGameOver) {

                    try {

                        if(turnPlayer){

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

                            playerTotal += gameDeck.getCardValue(indexPlayerCard);
                            dealerTotal += gameDeck.getCardValue(indexDealerCard);

                            System.out.print("totals" + playerTotal + " " + dealerTotal);

                            bet++;
                            playerBettingLot--;

                            HashMap<String,Integer> information = new HashMap<>();
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

                            turnPlayer = false;
                        }
                        else {
                        message = (String) input.readObject();
                        gameDetails.setText(gameDetails.getText() + "\n" + message);

                        if(message.equals("double")){
                            playerBettingLot -=bet;
                            bet *= 2;

                            HashMap<String,Integer> information = new HashMap<>();
                            //initial conditions to start game
                            information.put("keyPlayerTotal", playerTotal);
                            information.put("keyDealerTotal", dealerTotal);
                            information.put("keyBetAvailable", playerBettingLot);
                            information.put("keyBet", bet);

                            output.writeObject(information);
                            output.flush();
                        }
                        if(message.equals("hit")){
                            int newIndexPlayerCard = randomNumber.nextInt(52);
                            while (usedCards.contains(newIndexPlayerCard)) {
                                newIndexPlayerCard = randomNumber.nextInt(52);
                            }
                            usedCards.add(newIndexPlayerCard);

                            playerTotal += gameDeck.getCardValue(newIndexPlayerCard);

                            if (playerTotal == 21 ){
                                playerBettingLot += bet*2;
                            }


                            HashMap<String,Integer> information = new HashMap<>();


                                information.put("keyPlayerTotal", playerTotal);
                                information.put("keyDealerTotal", dealerTotal);
                                information.put("keyBetAvailable", playerBettingLot);
                                information.put("keyBet", bet);
                                information.put("keyPlayerCard", newIndexPlayerCard);


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
                                information.put("keyDealerCard", -1);

                                output.writeObject(information);
                                output.flush();
                            }
                            else {
                            while  (dealerTotal < 17)
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
                                    information.put("keyDealerCard", newIndexDealerCard);

                                    output.writeObject(information);
                                    output.flush();
                                }
                            }

                            HashMap<String, Integer> information = new HashMap<>();


                            if (playerTotal == 21 | (playerTotal < 21 && playerTotal > dealerTotal) | dealerTotal > 21){
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
                        if (message.equals("playAgain")){
                            usedCards = new HashSet<>(); //start again with a complete deck
                            turnPlayer = true;
                            HashMap<String,Integer> information = new HashMap<>();
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

        // send message to client
        private void sendData(String message) {
            try // send data to client
            {
                output.writeObject("SERVER>>> " + message);
                output.flush(); // flush output to client
                gameDetails.setText(gameDetails.getText()+ "\nSERVER>>> " + message);
            } catch (IOException ioException) {
                gameDetails.setText(gameDetails.getText()+ "\nerror sending -> " + message);
            }
        }

        // close streams and socket
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

//todo turn dealer card around