import java.util.Scanner;

/**
 * this class is a command line interface where the user that implements polymorphism, depending the user input it creates an object of the according sport class that inherits from the sport super class
 * the entire command line interface works for whatever object is created. The class simulates a sports game and keeps track of the stats. The interface is written in a generic way using polymorphism
 */
public class ScoreboardDriver {

    /**
     * main method of the command line interface, in this method first the user is prompted to select the type of game and throughout the user interact with the interface
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args) {

        /* create input object of the scanner class to read in from the user
          the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        // Promp user to enter item price
        System.out.print("Enter the number for the game played\n" +
                         "1 for Soccer\n2 for Basketball\n3 for Hockey\n4 for Football\n");

        // read in from user the next input string available for the game type selection
        int sportIndex = input.nextInt();

        // Promp user to enter item price
        System.out.print("Write the name of the home team: ");

        String team1 = input.next();

        // Promp user to enter item price
        System.out.print("Write the name of the away team: ");

        String team2 = input.next();
        Sports game;

        //create the according game based on the index read from the user
        if (sportIndex == 1 ){
            game = new Soccer(team1,team2);
        }
        else if (sportIndex == 2){
            game = new Basketball(team1,team2);
        }
        else if (sportIndex == 3){
             game = new Hockey(team1,team2);
        }
        else if (sportIndex == 4) {
            game = new Football(team1, team2);
        }
        else{
            System.out.print("Invalid input, please enter a valid value");
            game = new Football(team1,team2);
        }

        game.startTheGame(); //start the game

        while(!game.isGameOver()){ //while the game is is still happening
            //print the game game period and the score, then prompt the user to input the scoring method that happened
            System.out.print("Current " + game.getPeriodName()+": "+game.getCurrentPeriod()+"\n");
            System.out.print(game.getScoreBoard()+"\n");
            System.out.print(game.getScoringMethods());

            int option = input.nextInt(); //read the scoring method the user input

            game.addScore(option); //add the score according to the user input
        }

        //final message
        System.out.print("Final quarter completed, the game ended\n" + game.getScoreBoard() + "\n"
                         + "Winner " + game.winningTeam());

    }
}

