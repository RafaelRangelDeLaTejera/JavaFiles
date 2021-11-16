public class FoodItem {
    private double weight;
    private double enjoyment;
    private String name;

    public FoodItem(double weight, double enjoyment, String name) { //argument constructor
        this.weight = weight;
        this.enjoyment = enjoyment;
        this.name = name;
    }

    public FoodItem(String name){
        weight = 0;
        enjoyment = 0;
        this.name = name;
    }

    public double getWeight() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
