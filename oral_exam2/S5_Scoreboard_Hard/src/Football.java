public class Football extends Sports{
    public Football(String team1, String team2) {
        super(team1, team2,4);

        ScoringMethods touchdown = new ScoringMethods(6);
        ScoringMethods extraPoint = new ScoringMethods(1);
        ScoringMethods fieldGoal = new ScoringMethods(3);
        ScoringMethods twoPointConversion = new ScoringMethods(2);
        ScoringMethods safety = new ScoringMethods(2);
        getScoringMethods().add(touchdown);
        getScoringMethods().add(extraPoint);
        getScoringMethods().add(fieldGoal);
        getScoringMethods().add(twoPointConversion);
        getScoringMethods().add(safety);
    }

    @Override
    public void addScore(int scoringMethodNo) {
        if (scoringMethodNo == 1){
            setScore(1,getScore()[0] +7);
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
            setScore(2,getScore()[0] +7);
        }
        else if (scoringMethodNo == 7){
            setScore(2,getScore()[0] +3);
        }
        else if (scoringMethodNo == 8){
            setScore(2,getScore()[0] +1);
        }
        else if (scoringMethodNo == 9){
            setScore(2,getScore()[0] +2);
        }
        else if (scoringMethodNo == 10){
            setScore(2,getScore()[0] +2);
        }
        else if (scoringMethodNo == 11){
            endCurrentPeriod();
        }

    }

    @Override
    public String getScoringMethods() {
        String scoringMehods = ""


        return scoringMehods;
    }

    @Override
    public void startTheGame() {
        setCurrenPeriod(1);

    }

    @Override
    public void endCurrentPeriod() {
        setCurrenPeriod(getCurrentPeriod()+1);
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
