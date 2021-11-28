import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class extends the JPanel class to display and implement the hangman game
 */
public class DrawHangman extends JPanel {

    /**
     * string letter the player entered
     */
    private String guess = null;

    /**
     * number of guesses the player has left
     */
    private int guessesLeft = 6;

    /**
     * text field to enter the letter guess
     */
    private JTextField inputLetter = new JTextField(2);

    /**
     * text field to enter the word to be guessed
     */
    private JTextField inputWord = new JTextField(10);

    /**
     * string that holds the letters the user has guessed
     */
    private String lettersGuessed = null;

    /**
     * string for the word to be drawn
     */
    private String drawWord = null;

    /**
     * label for the text field to input the letter
     */
    private JLabel letterInputLabel = new JLabel("Enter the letter and click enter: ");

    /**
     * button to start over once the game is over
     */
    private JButton continueButton = new JButton();

    /**
     * label for the continueButton
     */
    private JLabel buttonLabel = new JLabel();

    /**
     * label for the text field where the user will enter the word to be guessed
     */
    private JLabel wordInputLabel = new JLabel("Enter word to be guessed by player");

    /**
     * string that stores the word to be guessed
     */
    private String wordToBeGuessed;

    /**
     * getter for the number of guesses the player has left
     * @return the int guesses left
     */
    public int getGuessesLeft() {
        return guessesLeft;
    }

    /**
     * no argument constructor that sets up the GUI and implements the game logic
     */
    public DrawHangman() {

        //add input word field and label (also assign this label to that field ) and display components to set up the game
        inputWord.addActionListener(new SetWord()); //add action listener to input word for when the player writes in the text field
        wordInputLabel.setLabelFor(inputWord);
        wordInputLabel.setVisible(true);
        inputWord.setVisible(true);
        add(wordInputLabel);
        add(inputWord);

        //add the buttons to the panel but dont show them at the beginning
        buttonLabel.setLabelFor(continueButton);
        buttonLabel.setVisible(false);
        continueButton.setVisible(false);
        add(buttonLabel);
        add(continueButton);

        inputLetter.addActionListener(new HangmanHandler());//add action listener to the inputLetter field for when the user inputs text on the text field

        letterInputLabel.setLabelFor(inputLetter); //have the created label be for the inputLetter JTextField object
        //set label and text field to true
        letterInputLabel.setVisible(false);
        inputLetter.setVisible(false);

        continueButton.addActionListener(new GameOverButton()); //add action listener to the continue button for when it is pressed

        //add label and text field to panel
        add(letterInputLabel);
        add(inputLetter);

    }

    /**
     * overridden paint component that updates the panel for when the player interacts with the GUI
     * @param g Graphics object for graphics context to allow application to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(8.0f));//set 2d graphics object stroke to a wider one

        g2d.setColor(Color.black);// set 2d graphics object to draw to black color
        //draw the hanging structure
        g2d.fillRect(getWidth()/5,getHeight()/9,400,20);
        g2d.fillRect(getWidth()/5+380,getHeight()/9+20,20,100);
        g2d.fillRect(getWidth()/5,getHeight()/9+20,20,400);
        g2d.fillRect(getWidth()/5-90,getHeight()/9+420,200,20);


        g2d.setStroke(new BasicStroke(8.0f));//set 2d graphics object stroke to a wider one

        //draw hangman figure according to the players guesses
        if (guessesLeft == 5){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
        }
        else if (guessesLeft == 4){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
            g2d.drawLine(getWidth()/5+390,getHeight()/9+180,getWidth()/5+390,getHeight()/9+280);//draw trunk

        }
        else if (guessesLeft == 3){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
            g2d.drawLine(getWidth()/5+390,getHeight()/9+180,getWidth()/5+390,getHeight()/9+280);//draw trunk
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+430,getHeight()/9+330);//draw right arm

        }
        else if (guessesLeft == 2){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
            g2d.drawLine(getWidth()/5+390,getHeight()/9+180,getWidth()/5+390,getHeight()/9+280);//draw trunk
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+430,getHeight()/9+330);//draw right arm
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+350,getHeight()/9+330);//draw left arm

        }
        else if (guessesLeft == 1){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
            g2d.drawLine(getWidth()/5+390,getHeight()/9+180,getWidth()/5+390,getHeight()/9+280);//draw trunk
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+430,getHeight()/9+330);//draw right arm
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+350,getHeight()/9+330);//draw left arm
            g2d.drawLine(getWidth()/5+390,getHeight()/9+230,getWidth()/5+420,getHeight()/9+190);//draw right leg

        }
        else if (guessesLeft == 0){
            g2d.drawOval(getWidth()/5+360,getHeight()/9+120,60,60);//draw head
            g2d.drawLine(getWidth()/5+390,getHeight()/9+180,getWidth()/5+390,getHeight()/9+280);//draw trunk
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+430,getHeight()/9+330);//draw right arm
            g2d.drawLine(getWidth()/5+390,getHeight()/9+280,getWidth()/5+350,getHeight()/9+330);//draw left arm
            g2d.drawLine(getWidth()/5+390,getHeight()/9+230,getWidth()/5+420,getHeight()/9+190);//draw right leg
            g2d.drawLine(getWidth()/5+390,getHeight()/9+230,getWidth()/5+360,getHeight()/9+190);//draw left leg

            buttonLabel.setText("You lost, press button to play again");//let the player know they lost

            //hide text fields and show the button for player to continue playing
            inputLetter.setVisible(false);
            letterInputLabel.setVisible(false);
            buttonLabel.setVisible(true);
            continueButton.setVisible(true);

        }

        Font textFont = new Font("Arial", Font.BOLD, 20);
        g2d.setFont(textFont);

        //write the letters used
        if (lettersGuessed == null){
            g2d.drawString("Guessed Letters: ",getWidth()/8,getHeight()/9+480);
            if(guess != null){
                lettersGuessed = guess + " ";
                g2d.drawString("Guessed Letters: " + lettersGuessed,getWidth()/8,getHeight()/9+480);
            }
        }
        else  {
            if (!lettersGuessed.contains(guess)){
                lettersGuessed = lettersGuessed + guess + " ";
                g2d.drawString("Guessed Letters: " + lettersGuessed,getWidth()/8,getHeight()/9+480);
            }
            g2d.drawString("Guessed Letters: " + lettersGuessed,getWidth()/8,getHeight()/9+480);

        }


        //display the guesses the user has left
        g2d.drawString("Guesses Left: " + guessesLeft ,getWidth()/8,getHeight()/9+520);


        if (wordToBeGuessed != null && !wordToBeGuessed.isEmpty()) {
            if (drawWord == null){
                drawWord = " _";
                for (int count = 1; count < wordToBeGuessed.length(); count++) //go over all the lettres of the word
                {drawWord = drawWord + " _";}
            }
        else{



            for (int count = 0; count < wordToBeGuessed.length(); count++) //go over all the lettres of the word
            {

                if (Character.toString(wordToBeGuessed.charAt(count)).equals(guess)){

                    drawWord = drawWord.substring(0,2*count) + " " + guess + drawWord.substring(2*count+2);

                }


            }
        }

            g2d.drawString("Word: " + drawWord, getWidth() / 5 + 200, getHeight() / 9 + 420); //Draw the word with lines for the missing letters

        }

        //when word is guessed
        if (drawWord != null){
            if (!drawWord.contains("_")){
                buttonLabel.setText("You Won, press button to play again");

                inputLetter.setVisible(false);
                letterInputLabel.setVisible(false);
                buttonLabel.setVisible(true);
                continueButton.setVisible(true);
            }
        }


    }

    /**
     * inner class that implements ActionListener interface designed for the text field input letter.
     */
    private class HangmanHandler implements ActionListener {

        /**
         * method for the action performed, this will read in the input letter and check if it was a correct guess or not
         * @param event when the user interacts and triggers an event in the field
         */
        @Override
        public void actionPerformed(ActionEvent event) {

            guess = inputLetter.getText();
            if (!wordToBeGuessed.contains(guess)){
                guessesLeft = guessesLeft - 1;
            }

            repaint();

            inputLetter.setText(null);

        }
    }

    /**
     * inner class that implements the ActionListener interface to handle events for the input word field
     */
    private class SetWord implements ActionListener {

        /**
         * method that will read in the input word on the text field and then update the gui to start a new game with that new word
         * @param event when the user interacts and triggers an event in the field
         */
        @Override
        public void actionPerformed(ActionEvent event){
            wordToBeGuessed = inputWord.getText();

            inputLetter.setText(null);
            inputWord.setVisible(false);
            wordInputLabel.setVisible(false);
            inputLetter.setVisible(true);
            letterInputLabel.setVisible(true);

            repaint(); //update the GUI


        }
    }

    /**
     * inner class that implements the Action Listener interface to handle events for the continueButton
     */
    private class GameOverButton implements ActionListener {

        /**
         * this method will detect when the user preses a button and start a new game
         * @param event when the user interacts and triggers an event in the field
         */
        @Override
        public void actionPerformed(ActionEvent event){


            wordToBeGuessed = inputWord.getText();

            buttonLabel.setVisible(false);
            continueButton.setVisible(false);
            wordInputLabel.setVisible(true);
            inputWord.setVisible(true);
            wordToBeGuessed = null;
            lettersGuessed = null;
            drawWord = null;
            guess = null;
            guessesLeft = 6;

            inputWord.setText(null);

            repaint(); //update the gui
        }
    }


}
