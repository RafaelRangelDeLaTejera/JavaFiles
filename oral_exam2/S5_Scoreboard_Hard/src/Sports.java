import java.util.ArrayList;

public abstract class Sports {
private Team team1;
private Team team2;
private GamePeriod period;
private ArrayList<ScoringMethods> scoringMethods;
private boolean gameOver;

    /** superclass sports constructor */
    public Sports(String team1,String team2) {
        this.team1.setName(team1);
        this.team2.setName(team2);

        gameOver = true;
    }

    /** team one setter */
    public void setTeam1(String team1) {
        this.team1.setName(team1);
        this.team1.setScore(0);
    }

    /** team two setter*/
    public void setTeam2(String team2) {
        this.team2.setName(team2);
        this.team2.setScore(0);
    }

    /** set the different scoring methods of the sport */
    public void addScoringMethods(ScoringMethods method) {
        this.scoringMethods.add(method);
    }

    /** team one getter*/
    public Team getTeam1() {
        return team1;
    }

    /** team two getter*/
    public Team getTeam2() {
        return team2;
    }

    /** get team 1's score*/
    public int getScoreTeam1() {
        return team1.getScore();
    }

    /** get team 2's score*/
    public int getScoreTeam2() {
        return team2.getScore();
    }

    /** set team 1's score*/
    public void setScoreTeam1(int scoreTeam1) {
        team1.setScore(scoreTeam1);
    }

    /** set team 2's score*/
    public void setScoreTeam2(int scoreTeam2) {
        team2.setScore(scoreTeam2);
    }

    /** get the current period of play*/
    public int getGamePeriod() {
        return period.getCurrentPeriod();
    }

    /** addScore method*/
    public void addScore(Team scoringTeam, ScoringMethods scoringMethod){
        scoringTeam.setScore(getScoreTeam1()+scoringMethod.getPointsAdded());
    }

    /** getScoring Methods*/
    public ArrayList<ScoringMethods> getScoringMethods(){
        return scoringMethods;
    }

    /** start game method*/
    public void startTheGame(boolean start){
        gameOver = false;
    }

    /** method to end the current period of game  */
    public void endCurrentPeriod(boolean end){
        period.setCurrentPeriod(period.getCurrentPeriod()+1);
    }

    /** method to get the lenght of the period*/
    public String getLengthOfPeriod(){
       return getPeriod().getLength();
    }

    /** get the game period object for the class */
    public GamePeriod getPeriod() {
        return period;
    }

    /** method to get the name of the period */
    public String getPeriodName(){
        return period.getName();
    }

    /** is the game over?*/
    public boolean checkGameOver(){

        if (getPeriod().getCurrentPeriod() == getPeriod().getTotalPeriods()){
            gameOver = true;
        }

        return gameOver;
    }

    /** declare the winning team */
    public String winningTeam(){

        String winner;

        if (getScoreTeam1() > getScoreTeam2()){
            winner = team1.getName();
        }
        else if (getScoreTeam2() > getScoreTeam1()){
            winner = team2.getName();
        }
        else{
            winner = "no winner, game tied" ;
        }

        return winner;
    }
}
