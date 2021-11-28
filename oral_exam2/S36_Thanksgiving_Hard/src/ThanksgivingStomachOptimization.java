import java.util.ArrayList;

/**
 * class that optimizes the usage of a stomach according to the weight and level of enjoyment of several thanksgiving food items
 */
public class ThanksgivingStomachOptimization {

    /**
     * no argument constructor with no process of initialization since no object of this class is instantiated in driver
     */
    public ThanksgivingStomachOptimization() {}

    /**
     * method that computes the optimal level of enjoyment through recursion
     * @param foodList array of food items
     * @param capacity double stomach capacity
     * @return the optimal level of enjoyment
     */
    public static double optimizationAlgorithm(FoodItem[] foodList, double capacity){

        double maxEnjoymentPerVolumeUnit = 0; //hold max enjoyment
        double optimalEnjoyment = 0; //variable to return the optimal enjoyment
        int maxItemIndex=-1; // initialized to compile

        double enjoymentPerVolumeUnit; //to calculate enjoyment per volume unit of the food items

        for(int i = 0; i < foodList.length; i++){ //go over the whole list
            if ((int)(capacity/foodList[i].getWeight())!=0){ //if the weight fits into the capacity

                // get and store the enjoyment Per volume unit
            enjoymentPerVolumeUnit = foodList[i].getEnjoyment()/foodList[i].getWeight();

            if (maxEnjoymentPerVolumeUnit <= enjoymentPerVolumeUnit && capacity!=0){ //store the maximum level per volume unit
                maxEnjoymentPerVolumeUnit = enjoymentPerVolumeUnit;
                maxItemIndex = i;
            }}

        }

        if (maxItemIndex != -1){ //check that a max enjoyment item with appropriate volume was found

        int amount = ((int)(capacity/foodList[maxItemIndex].getWeight())); //get the amount of that food item that will be consumed

            optimalEnjoyment+= amount*foodList[maxItemIndex].getEnjoyment(); //add the corresponding level of enjoyment units

            capacity = capacity - amount*foodList[maxItemIndex].getWeight(); //reduce the capacity left

            optimalEnjoyment+=optimizationAlgorithm(foodList,capacity); //recursively call this method to get the next best item and so on until no other can be found
        }

            return optimalEnjoyment; //base case, no max enjoyment item was found

    }
}
