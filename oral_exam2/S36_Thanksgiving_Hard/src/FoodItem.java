public class FoodItem {
    private int weight;
    private int enjoyment;

    public FoodItem(int weight, int enjoyment) { //argument constructor
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

    public int getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(int enjoyment) {
        this.enjoyment = enjoyment;
    }
}
