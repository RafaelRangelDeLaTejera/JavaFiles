public class Football extends Sports{
    public Football(String team1, String team2) {
        super(team1, team2);
    }

    @Override
    public void addScore(int scoringMethodNo) {
        if (scoringMethodNo == 1){
            setScore(1,getScore()[0] +7); //team 1 scores touchdown
        }
        else if (scoringMethodNo == 2){
            setScore(1,getScore()[0] +3);
        }
        else if (scoringMethodNo == 3){
            setScore(1,getScore()[0] +1);
        }
        else if (scoringMethodNo == 4){
            setScore(1,getScore()[0] +2);
        }
        else if (scoringMethodNo == 5){
            setScore(1,getScore()[0] +2);
        }
        else if (scoringMethodNo == 6){
            setScore(2,getScore()[1] +7);
        }
        else if (scoringMethodNo == 7){
            setScore(2,getScore()[1] +3);
        }
        else if (scoringMethodNo == 8){
            setScore(2,getScore()[1] +1);
        }
        else if (scoringMethodNo == 9){
            setScore(2,getScore()[1] +2);
        }
        else if (scoringMethodNo == 10){
            setScore(2,getScore()[1] +2);
        }
        else if (scoringMethodNo == 11){
            endCurrentPeriod();
        }

    }

    @Override
    public String getScoringMethods() {
        return  "1 for " + getTeams(1) + " touchdown\n" +
                "2 for " + getTeams(1) + " field goal\n" +
                "3 for " + getTeams(1) + " extra point\n" +
                "4 for " + getTeams(1) + " two point conversion\n" +
                "5 for " + getTeams(1) + " safety\n" +
                "6 for " + getTeams(2) + " touchdown\n" +
                "7 for " + getTeams(2) + " field goal\n" +
                "8 for " + getTeams(2) + " extra point\n" +
                "9 for " + getTeams(2) + " two point conversion\n" +
                "10 for " + getTeams(2) + " safety\n" +
                "11 to end quarter\n";
    }

    @Override
    public String getLengthOfPeriod() {
        return "15 minutes";
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
