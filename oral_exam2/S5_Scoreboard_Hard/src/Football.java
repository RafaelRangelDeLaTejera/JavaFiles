public class Football extends Sports{
    public Football(String team1, String team2) {
        super(team1, team2);
        getPeriod().setName("quarter");
        getPeriod().setLength("15 minutes");
        getPeriod().setTotalPeriods(4);
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
}
