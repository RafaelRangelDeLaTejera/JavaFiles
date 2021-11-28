import javax.swing.*;
import java.awt.*;

/**
 * class that extends the JFrame class to implement a GUI with a the DrawHangman panel as its main component
 */
public class HangmanGUI extends JFrame {

    /**
     * no argument constructor that sets up the GUI, it adds the DrawHangman panel to implement the hangman game functionality and display the hangman
     */
    public HangmanGUI(){

        super("Hangman Game"); //call the constructor of the superclass Jframe

        //set up the frame and panel
        DrawHangman drawingHangman = new DrawHangman();
        drawingHangman.setBackground(Color.white);
        Dimension minFrameDimension = new Dimension(800,800);
        setMinimumSize(minFrameDimension);

        add(drawingHangman); //add the panel to the frame

        if (drawingHangman.getGuessesLeft() == 0){ //if there are no guesses left end the game
            JOptionPane.showMessageDialog(this, "Game Over");
        }
    }
}


