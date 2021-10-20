public class Basketball extends Sports{
    public Basketball(String team1, String team2) {
        super(team1, team2);
    }

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

    @Override
    public String getLengthOfPeriod() {
        return "12 minutes\n";
    }

    @Override
    public String getPeriodName() {
        return "quarter";
    }

    @Override
    public void checkGameOver() {
        if (getCurrentPeriod()==5){
            setGameOver(true);
        }
    }
}
