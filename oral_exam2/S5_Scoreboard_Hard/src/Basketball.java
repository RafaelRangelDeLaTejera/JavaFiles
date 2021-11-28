/**
 * basketball class that extends from the Sports super class
 */
public class Basketball extends Sports{

    /**
     * basketball constructor, calls the super constructor from the sports base class and passes in the passed in strings
     * @param team1 string holding the name of the first team
     * @param team2 string holding the name of the second team
     */
    public Basketball(String team1, String team2) {
        super(team1, team2);
    }

    /**
     * method to add the score according to the passed in option from the getScoringMethods called from the command line interface, these are all Basketball scoring methods
     * @param scoringMethodNo scoring method option
     */
    @Override
    public void addScore(int scoringMethodNo) {
        if (scoringMethodNo == 1){
            setScore(1,getScore()[0] +2);
        }
        else if (scoringMethodNo == 2){
            setScore(1,getScore()[0] +3);
        }
        else if (scoringMethodNo == 3){
            setScore(1,getScore()[0] +1);
        }
        else if (scoringMethodNo == 4){
            setScore(2,getScore()[1] +2);
        }
        else if (scoringMethodNo == 5){
            setScore(2,getScore()[1] +3);
        }
        else if (scoringMethodNo == 6){
            setScore(2,getScore()[1] +1);
        }
        else if (scoringMethodNo == 7){
            endCurrentPeriod();
        }
    }

    /**
     * method  that returns the string with the options of the scoring methods of the basketball class
     * @return string with the scoring methods specific to a basketball game
     */
    @Override
    public String getScoringMethods() {
        return  "1 for " + getTeams(1) + " two pointer\n" +
                "2 for " + getTeams(1) + " three pointer\n" +
                "3 for " + getTeams(1) + " free throw\n" +
                "4 for " + getTeams(2) + " two pointer\n" +
                "5 for " + getTeams(2) + " three pointer\n" +
                "6 for " + getTeams(2) + " free throw\n" +
                "7 to end quarter\n";
    }

    /**
     * method to get the duration of a basketball game period
     * @return string holding the duration of the basketball period which is "12 minutes"
     */
    @Override
    public String getLengthOfPeriod() {
        return "12 minutes\n";
    }

    /**
     * method to get the name of the basketball game period
     * @return string holding the name of the basketball game period which is "quarter"
     */
    @Override
    public String getPeriodName() {
        return "quarter";
    }

    /**
     * check if the game is over, if the 4 periods of the basketball have been completed, then the game over method is set to true
     */
    @Override
    public void checkGameOver() {
        if (getCurrentPeriod()==5){
            setGameOver(true);
        }
    }
}
