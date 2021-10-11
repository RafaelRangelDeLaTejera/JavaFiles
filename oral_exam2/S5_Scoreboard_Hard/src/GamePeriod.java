public class GamePeriod {
    private String length;
    private String name;
    private int currentPeriod;
    private int totalPeriods;

    public GamePeriod(String length, String name, int currentPeriod) {
        this.length = length;
        this.name = name;
        this.currentPeriod = currentPeriod;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(int currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public int getTotalPeriods() {
        return totalPeriods;
    }

    public void setTotalPeriods(int totalPeriods) {
        this.totalPeriods = totalPeriods;
    }
}
