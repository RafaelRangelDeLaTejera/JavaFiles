import java.util.ArrayList;

public class Soccer extends Sports{
    /** soccer constructor, subclass of sports abstract class */
    public Soccer(String team1,String team2) {
        super(team1, team2);
    }

    @Override
    public void addScore(int scoringMethodNo) {
        if (scoringMethodNo == 1){
            setScore(1,getScore()[0] +1); //team 1 scores touchdown
        }
        else if (scoringMethodNo == 2){
            setScore(2,getScore()[0] +1);
        }
        else if (scoringMethodNo == 3){
            endCurrentPeriod();
        }
    }

    @Override
    public String getScoringMethods() {
        return  "1 for " + getTeams(1) + " goal\n" +
                "2 for " + getTeams(2) + " goal\n" +
                "3 to end quarter";
    }

    @Override
    public String getLengthOfPeriod() {
        return "45 minutes";
    }

    @Override
    public String getPeriodName() {
        return "half";
    }

    @Override
    public void checkGameOver() {
        if (getCurrentPeriod() == 3){
            setGameOver(true);
        }
    }

}
