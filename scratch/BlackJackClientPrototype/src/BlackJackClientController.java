import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BlackJackClientController implements Runnable{

    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String hostName; // host server for this application
    private Socket connection; // socket to communicate with server

    public BlackJackClientController(String hostName) {
        this.hostName = hostName;
    }

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

