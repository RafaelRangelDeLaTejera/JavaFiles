/**
 * class to create object to simulate a food item for thanksgiving
 */
public class FoodItem {

    /**
     *
     */
    private double weight;

    /**
     *
     */
    private double enjoyment;

    /**
     *
     */
    private String name;

    /**
     * FoodItem constructor that takes in 3 parameters, weight, enjoyment and name.It creates the object assigning the passed in values to the corresponding field
     * @param weight the weight of the item as a double
     * @param enjoyment the level of enjoyment as a double
     * @param name the string holding the name of the item
     */
    public FoodItem(double weight, double enjoyment, String name) {
        this.weight = weight;
        this.enjoyment = enjoyment;
        this.name = name;
    }

    /**
     * Food item constructor that takes the name of the food item and sets default values of 0 to the weight and enjoyment members
     * @param name the name of the food item
     */
    public FoodItem(String name){
        weight = 0;
        enjoyment = 0;
        this.name = name;
    }

    /**
     * getter for the weight of the food item
     * @return double value of the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * setter for the weight of the food item
     * @param weight the double value to be assigned to the food item weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * getter for the level of enjoyment of the food item
     * @return the double value of the level of enjoyment
     */
    public double getEnjoyment() {
        return enjoyment;
    }

    /**
     * setter for the level of enjoyment of the food item
     * @param enjoyment the double value to be assigned to the food item enjoyment
     */
    public void setEnjoyment(double enjoyment) {
        this.enjoyment = enjoyment;
    }

    /**
     * getter for the name of the food item
     * @return the string holding the name of the food item
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the food item
     * @param name the string with the name to be assigned to the food item name member
     */
    public void setName(String name) {
        this.name = name;
    }
}
