import javax.swing.*;

public class HangmanDriver {
    public static void main(String[] args) {
        HangmanGUI hangmanFrame = new HangmanGUI();
        hangmanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangmanFrame.setSize(1000, 800);
        hangmanFrame.setVisible(true);
    }
}
