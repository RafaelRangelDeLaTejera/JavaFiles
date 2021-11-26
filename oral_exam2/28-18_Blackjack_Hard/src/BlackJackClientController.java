import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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


    @FXML
    private Button hitButton;

    @FXML
    private Button stayButton;

    @FXML
    private Button doubleButton;

    @FXML
    private Button outButton;

    @FXML
    private Button betAvailable;

    @FXML
    private TextArea cardDealt;

    @FXML
    private TextField playerTotal;

    @FXML
    private TextField dealerTotal;

    @FXML
    private TextField bet;

    @FXML
    private Button playAgainButton;

    @FXML
    public void initialize() {




        playAgainButton.setVisible(false);

        int playerTotal = 0;

        int dealerTotal = 0;

        ;
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
        outButton.setVisible(true);
        stayButton.setVisible(true);

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
    void outPressed(ActionEvent event) {
        try {
            output.writeObject("out");
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



        while (isGame){
            System.out.print("inside run while loop");
//            try {
//                System.out.print("in run");
//                messageFromServer = (HashMap<String, Integer>) input.readObject();
//
//                if(messageFromServer.get("card") == 0){
//                    playAgainButton.setVisible(true);
//                    doubleButton.setVisible(false);
//                    hitButton.setVisible(false);
//                    outButton.setVisible(false);
//                    stayButton.setVisible(false);
//                }
//                else {
//                    betAvailable.setText("Bet available: " + messageFromServer);
//                }
//            } catch (IOException | ClassNotFoundException ioException) {
//                ioException.printStackTrace();
//            }


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
            cardDealt.setText("\nServer terminated connection");
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

