public class Basketball extends Sports{
    public Basketball(String team1, String team2) {
        super(team1, team2);
        getPeriod().setName("quarter");
        getPeriod().setLength("12 minutes");
        getPeriod().setTotalPeriods(4);
        ScoringMethods freeThrow = new ScoringMethods(1);
        ScoringMethods twoPointer = new ScoringMethods(2);
        ScoringMethods threePointer = new ScoringMethods(3);
        getScoringMethods().add(freeThrow);
        getScoringMethods().add(twoPointer);
        getScoringMethods().add(threePointer);
    }
}
