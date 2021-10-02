import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

public class DrawHangman extends JPanel {

    //todo

    private String guess = null;
    private int guessesLeft = 6;
    private JTextField inputLetter = new JTextField(2); //text field to enter the letter guess
    private JTextField inputWord = new JTextField(10); //text field to enter the word to be guessed
    private String lettersGuessed = null;
    private String drawWord = null;
    private JLabel letterInputLabel = new JLabel("Enter the letter and click enter: "); //lable for the text field to input the letter
    private JButton continueButton = new JButton();
    private JLabel buttonLabel = new JLabel();
    private JLabel wordInputLabel = new JLabel("Enter word to be guessed by player");


    public int getGuessesLeft() {
        return guessesLeft;
    }

    public DrawHangman() {

        inputWord.addActionListener(new SetWord());
        wordInputLabel.setLabelFor(inputWord);
        wordInputLabel.setVisible(true);
        inputWord.setVisible(true);
        add(wordInputLabel);
        add(inputWord);


        //todo
        buttonLabel.setLabelFor(continueButton);
        buttonLabel.setVisible(false);
        continueButton.setVisible(false);
        add(buttonLabel);
        add(continueButton);
        //todo
        inputLetter.addActionListener(new HangmanHandler());

        letterInputLabel.setLabelFor(inputLetter); //have the created label be for the inputLetter JTextField object
        //set label and text field to true
        letterInputLabel.setVisible(false);
        inputLetter.setVisible(false);

        continueButton.addActionListener(new GameOverButton());

        //add label and text field to panel
        add(letterInputLabel);
        add(inputLetter);

//        JTextField inputLetter = new JTextField(2); //text field to enter the letter guess
//        JLabel letterInputLabel = new JLabel("Enter the letter and click enter: "); //lable for the text field to input the letter
//
//        letterInputLabel.setLabelFor(inputLetter); //have the created label be for the inputLetter JTextField object
//        //set label and text field to true
//        letterInputLabel.setVisible(true);
//        inputLetter.setVisible(true);
//
//        //todo
//        inputLetter.addActionListener(new HangmanHandler());
//
//        //add label and text field to panel
//        add(letterInputLabel);
//        add(inputLetter);
    }

    private String wordToBeGuessed;
    //HangmanHandler handler = new HangmanHandler();

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

//todo


        //todo

//        add(letterInputLabel);
//        add(inputLetter);

        //todo

        g2d.setStroke(new BasicStroke(8.0f));//set 2d graphics object stroke to a wider one

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

            buttonLabel.setText("You lost, press button to play again");

            inputLetter.setVisible(false);
            letterInputLabel.setVisible(false);
            buttonLabel.setVisible(true);
            continueButton.setVisible(true);



        }

//todo



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


        //todo

        String addLetter;

//        if (wordToBeGuessed.contains(guess)){
//            for (int count = 0; count < wordToBeGuessed.length(); count++){
//
//            }
//        }

    if (wordToBeGuessed != null && !wordToBeGuessed.isEmpty())
    {
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


    //todo win state
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

    private class HangmanHandler implements ActionListener {

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

    private class SetWord implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            wordToBeGuessed = inputWord.getText();

            inputLetter.setText(null);
            inputWord.setVisible(false);
            wordInputLabel.setVisible(false);
            inputLetter.setVisible(true);
            letterInputLabel.setVisible(true);

            repaint();


        }
    }

    private class GameOverButton implements ActionListener {
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

            repaint();
        }
    }


}
