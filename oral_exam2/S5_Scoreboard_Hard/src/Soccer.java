import java.util.ArrayList;

/**
 * soccer class that extends from the Sports superclass
 */
public class Soccer extends Sports{


    /**
     * soccer constructor, calls the super constructor from the sports base class and passes in the passed in strings
     * @param team1 string holding the name of the first team
     * @param team2 string holding the name of the second team
     */
    public Soccer(String team1,String team2) {
        super(team1, team2);
    }

    /**
     * method to add the score according to the passed in option from the getScoringMethods called from the command line interface
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
     * method  that returns the string with the options of the scoring methods of the soccer class
     * @return the string containing the scoring methods for the soccer sport
     */
    @Override
    public String getScoringMethods() {
        return  "1 for " + getTeams(1) + " goal\n" +
                "2 for " + getTeams(2) + " goal\n" +
                "3 to end quarter\n";
    }

    /**
     * overridden method to get the length of the soccer period
     * @return string holding "45 minutes" because that is the length of a soccer period
     */
    @Override
    public String getLengthOfPeriod() {
        return "45 minutes\n";
    }

    /**
     * method to get the name of the soccer period which is a half
     * @return "half" string, which is the name of the period
     */
    @Override
    public String getPeriodName() {
        return "half";
    }

    /**
     * overridden, sets game over to true if the two standard game periods have ended
     */
    @Override
    public void checkGameOver() {
        if (getCurrentPeriod() == 3){
            setGameOver(true);
        }
    }

}
