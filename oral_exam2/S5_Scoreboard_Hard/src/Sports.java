/**
 * abstract class that serves as the base class for the sports hierarchy
 */
public abstract class Sports {

    /**
     * private member of type int to hold the number of the current Period
     */
    private int currentPeriod;

    /**
     * array of type string to hold the names of the two teams
     */
    private String[] teams = new String[2];

    /**
     * array of type int that holds the score of both players, index 0 for team 1 and index 1 for team 2
     */
    private int[] score = new int[2];

    /**
     * boolean, determines if the game is over
     */
    private boolean gameOver;

    /**
     * Class super constructor, this cant be used to instantiate an object of the sports class but it can be called by the subclasses
     * @param team1 string holding the name of the first team
     * @param team2 string holding the name of the second team
     */
    public Sports(String team1,String team2) {
        teams[0] = team1; //team 1
        teams[1] = team2;//team 2

        gameOver = false;//start game
    }

    /**
     * public method getter for the gameOver data member
     * @return the boolean value of the gameOver variable
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * setter for the gameOver variable, call this method to indicate the end or start of the game
     * @param gameOver boolean to set gameOver, this to indicate if the game has ended
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * setter for the names of the teasm
     * @param team1 string holding the name of the first team
     * @param team2 string holding the name of the second team
     */
    public void setTeams(String team1,String team2) {
        teams[0] = team1;
        teams[1] = team2;
    }

    /**
     * getter method, this method takes in the team number either 1 for the first team or two for the second team and returns the name of the team
     * @param teamNumber number of the team you want the name of
     * @return string holding the name of the team
     */
    public String getTeams(int teamNumber) {
//        return "team 1: " + teams[0] + " - " + "team 2: " + teams[1];
        return teams[teamNumber-1];
    }

    /**
     * getter for the score member
     * @return the array holding the scores of both teams
     */
    public int[] getScore() {
        return score;
    }

    /**
     * method to be called to get the scoreBoard to be printed by the driver
     * @return string holding the scoreboard to be printed by the driver
     */
    public String getScoreBoard(){
        return teams[0] + ": " + score[0] + " - " + teams[1] + ": " + score[1];
    }

    /**
     * method to set the score of the indicated team
     * @param teamNO team number, first or second team whose score will be set
     * @param points score to be set to the assigned team
     */
    public void setScore(int teamNO, int points){
        score[teamNO-1] = points;
    }

    /** abstract method to add score according to each subclass
     * @param scoringMethodNo scoring method option
     * */
    abstract public void addScore(int scoringMethodNo);

    /** abstract getScoring method for each subclass to implement
     * @return a string
     * */
    abstract public String getScoringMethods();

    /** method to start game by setting the current period to 1 */
    public void startTheGame(){
        setCurrenPeriod(1);
    }

    /** method to end the current period of game , this method calls the chackGameOver method to seee if */
    public void endCurrentPeriod() {
        setCurrenPeriod(getCurrentPeriod()+1);
        checkGameOver();
    }
    /** abstract method to be overridden to get the length of the period
     * @return as string
     * */
    abstract public String getLengthOfPeriod();

    /** get the game period object for the class
     * @return int variable with the currentPeriod game number
     * */
    public int getCurrentPeriod(){return currentPeriod;}

    /**
     * setter to update the currentPeriod
     * @param periodNo the period number to assign to the current period
     */
    public void setCurrenPeriod(int periodNo){currentPeriod = periodNo; }

    /** abstract method to get the name of the period
     * @return string holding the period name this will change according to the type of the game
     * */
    abstract public String getPeriodName();


    /** abstract method to be overridden by the subclasses*/
    abstract public void checkGameOver();

    /** method to determine the winning team
     * @return string variable holding the name of the winning team, or in case of a tie it returns the tie message
     * */
    public String winningTeam(){

        if (score[0] > score[1]){
            return teams[0];
        }
        else if (score[1] > score[0]){
            return teams[1];
        }
        else{
            return "no winner, game tied\n" ;
        }
    }
}
