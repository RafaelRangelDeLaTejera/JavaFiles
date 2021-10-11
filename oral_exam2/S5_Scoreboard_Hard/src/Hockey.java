public class Hockey extends Sports{
    public Hockey(String team1, String team2) {
        super(team1, team2);
        getPeriod().setName("period");
        getPeriod().setLength("20 minutes");
        getPeriod().setTotalPeriods(3);
        ScoringMethods goal = new ScoringMethods(1);
        getScoringMethods().add(goal);
    }
}
