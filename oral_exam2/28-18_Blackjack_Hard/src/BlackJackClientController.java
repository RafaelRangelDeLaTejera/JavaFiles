import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlackJackClientController implements Runnable{

    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String hostName; // host server for this application
    private Socket connection; // socket to communicate with server

    @FXML
    private Button hitButton;

    @FXML
    private Button stayButton;

    @FXML
    private Button doubleButton;

    @FXML
    private Button outButton;

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

        startClient();
    }

    //on action methods

    @FXML
    void playAgainPressed(ActionEvent event) {

    }

    @FXML
    void doublePressed(ActionEvent event) {

    }

    @FXML
    void hitPressed(ActionEvent event) {

    }

    @FXML
    void outPressed(ActionEvent event) {

    }

    @FXML
    void stayPressed(ActionEvent event) {

    }

    // connect to server
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        connection = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                connection.getInetAddress().getHostName());
    }



    // process connection with server
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    // close streams and socket
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // send message to server
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    @Override
    public void run() {

    }

    public void startClient(){
        try // connect to server and get streams
        {
            // make connection to server
            connection = new Socket(
                    InetAddress.getByName(hostName), 23765);

            // get streams for input and output
            // set up output stream for objects
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush(); // flush output buffer to send header information

            // set up input stream for objects
            input = new ObjectInputStream(connection.getInputStream());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        // create and start worker thread for this client
//        ExecutorService worker = Executors.newFixedThreadPool(1);
//        worker.execute(this); // execute client
    }

    
}

