import java.util.ArrayList;

public class Soccer extends Sports{
    /** soccer constructor, subclass of sports abstract class */
    public Soccer(String team1,String team2) {
        super(team1, team2);
        getPeriod().setName("half");
        getPeriod().setLength("45 minutes");
        getPeriod().setTotalPeriods(2);
        ScoringMethods goal = new ScoringMethods(1);
        getScoringMethods().add(goal);
    }

}
