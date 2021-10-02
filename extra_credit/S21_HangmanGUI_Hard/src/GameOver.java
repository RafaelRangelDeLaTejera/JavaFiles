import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JDialog implements ActionListener {
    private String word;
    //private JTextField inputWord;
    private JButton play;

    public GameOver (JFrame owner,Boolean wonOrLost){

        super(owner, "Before game starts enter word for player to guess",true); //frame where it will be drawn, title and block user input to other main window



    }

        @Override
        public void actionPerformed(ActionEvent event) {



        }

}
