import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlackJackServerController {

    private  int totalPlayers = 0;
    private BlackJackGame currentGame = new BlackJackGame();
    private int dealerTotal;
    private int numberOfPlayers = 0;
    private ArrayList<Player> players = new ArrayList<>();
    private ServerSocket dealer; // server socket to listen to clients and establich connections
    private ExecutorService game;

    @FXML
    private TextArea gameDetails;

//todo removed for test
//    private ServerSocket dealer; // server socket to listen to clients and establich connections
//
//
//
//    private BlackJackGame currentGame = new BlackJackGame();
//    private int dealerTotal;
//    private int totalPlayers = 0;
//    private ArrayList<Player> players = new ArrayList<>();
//    private ExecutorService game;

                                //    public BlackJackServerController() {
                                //       game = Executors.newCachedThreadPool();
                                //
                                //        try {
                                //            dealer = new ServerSocket(23765, 100); // set up ServerSocket
                                //        } catch (IOException ioException) {
                                //            ioException.printStackTrace();
                                //        }
                                //    }

    @FXML
    public void initialize(){
        gameDetails.setText("Waiting for connection\n");
        game = Executors.newCachedThreadPool();

        try {
            dealer = new ServerSocket(23765, 100); // set up ServerSocket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // private inner class Player manages each Player as a runnable
    public  class Player implements Runnable {
        private Socket connection; // connection to client
        private ObjectInputStream input; // input from client
        private ObjectOutputStream output; // output to client
        private boolean turn = true; // whether its the players turn

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

                gameDetails.setText(gameDetails.getText()+"Player " + totalPlayers + " connected\n");


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
    }

    public void execute(){
        System.out.print("hello");
//        while (true) {
//            try {
//                System.out.print("in");
//
//
//                players.add(new Player(dealer.accept())); //listen to connections and accept them
//                game.execute(players.get(numberOfPlayers)); // execute player runnable
//                numberOfPlayers++;
//
//
////                gameDetails.setText(gameDetails.getText()+"Connection " + totalPlayers + " received from: " +
////                        players.get(totalPlayers).connection.getInetAddress().getHostName());
//
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//                //gameDetails.setText(gameDetails.getText()+"\nServer terminated connection");
//            }
//        }
    }









    //todo set up server and get it running



}

