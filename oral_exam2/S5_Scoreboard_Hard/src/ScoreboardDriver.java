import java.util.Scanner;

public class ScoreboardDriver {
    public static void main(String[] args) {

        /* create input object of the scanner class to read in from the user
          the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        // Promp user to enter item price
        System.out.print("Enter the number for the game played\n" +
                         "1 for Soccer\n2 for Basketball\n3 for Hockey\n4 for Football\n");

        // read in from user the next input string available
        int sportIndex = input.nextInt();

        // Promp user to enter item price
        System.out.print("Write the name of the home team: ");

        String team1 = input.next();

        // Promp user to enter item price
        System.out.print("Write the name of the away team: ");

        String team2 = input.next();
        Sports game;

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

        game.startTheGame();

        while(!game.isGameOver()){
            System.out.print("Current " + game.getPeriodName()+": "+game.getCurrentPeriod()+"\n");
            System.out.print(game.getScoreBoard()+"\n");
            System.out.print(game.getScoringMethods());

            int option = input.nextInt();

            game.addScore(option);
        }
        System.out.print("Final quarter completed, the game ended\n" + game.getScoreBoard() + "\n"
                         + "Winner " + game.winningTeam());

    }
}

