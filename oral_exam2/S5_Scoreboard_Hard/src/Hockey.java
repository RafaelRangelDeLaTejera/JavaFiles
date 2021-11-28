/**
 * hockey class that extends from the Sports superclass to implement a hockey game
 */
public class Hockey extends Sports{

    /**
     * hockey constructor, calls the super constructor from the sports base class and passes in the passed in strings
     * @param team1 string holding the name of the first team
     * @param team2 string holding the name of the second team
     */
    public Hockey(String team1, String team2) {
        super(team1, team2);
    }

    /**
     * method to add the score according to the passed in option from the getScoringMethods called from the command line interface, scoring methods are specific to a hockey game
     * @param scoringMethodNo scoring method option
     */
    @Override
    public void addScore(int scoringMethodNo) {
        if (scoringMethodNo == 1){
            setScore(1,getScore()[0] +1); //team 1 scores touchdown
        }
        else if (scoringMethodNo == 2){
            setScore(2,getScore()[1] +1);
        }
        else if (scoringMethodNo == 3){
            endCurrentPeriod();
        }
    }

    /**
     * method  that returns the string with the options of the scoring methods of the Hockey class
     * @return the string containing the scoring methods for the hockey sport
     */
    @Override
    public String getScoringMethods() {
        return  "1 for " + getTeams(1) + " goal\n" +
                "2 for " + getTeams(2) + " goal\n" +
                "3 to end quarter\n";
    }

    /**
     * method to get the duration of the hockey period
     * @return string holding "20 minutes"
     */
    @Override
    public String getLengthOfPeriod() {
        return "20 minutes\n";
    }

    /**
     * method to get the name of the hockey period
     * @return string holding "period"
     */
    @Override
    public String getPeriodName() {
        return "period";
    }

    /**
     * method to check if the game has ended, this hockey game only has 3 periods so if the current period is 4 it means
     * the game has ended
     */
    @Override
    public void checkGameOver() {
        if (getCurrentPeriod() == 4){
            setGameOver(true);
        }
    }
}
