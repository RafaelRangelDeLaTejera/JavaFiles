import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGUI extends JFrame {

    public HangmanGUI(){
        super("Hangman Game");

//        String guessWord = null;
//
//        while(guessWord == null || guessWord.isEmpty()) {
//
//            JOptionPane inputWord = new JOptionPane();
//            inputWord.createInternalFrame(this,"Enter Word to be guessed");
//            JTextField inputTheWord = new JTextField();
//            inputWord.add(inputTheWord);
//
//            if (guessWord == null){
//                guessWord = JOptionPane.showInputDialog("Before the game, please enter a word to be guessed by player");
//            }
//            else if (guessWord.isEmpty()){
//                guessWord = JOptionPane.showInputDialog("Please input a word to be guessed by player");
//            }
//        }

        DrawHangman drawingHangman = new DrawHangman();
        drawingHangman.setBackground(Color.white);
        Dimension minFrameDimension = new Dimension(800,800);
        setMinimumSize(minFrameDimension);

        add(drawingHangman);

        if (drawingHangman.getGuessesLeft() == 0){
            JOptionPane.showMessageDialog(this, "Game Over");
        }



    }

}


