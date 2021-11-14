public class FoodItem {
    private int weight;
    private double enjoyment;

    public FoodItem(int weight, double enjoyment) { //argument constructor
        this.weight = weight;
        this.enjoyment = enjoyment;
    }

    public FoodItem(){ //no argument constructor
        weight = 0;
        enjoyment = 0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(double enjoyment) {
        this.enjoyment = enjoyment;
    }
}
