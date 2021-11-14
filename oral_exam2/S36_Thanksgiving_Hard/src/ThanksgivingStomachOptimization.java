import java.util.ArrayList;

public class ThanksgivingStomachOptimization {

    public ThanksgivingStomachOptimization() {}

    public static double optimizationAlgorithm(FoodItem[] foodList, int capacity){

        double maxEnjoyment = 0; //hold max enjoyment
        double optimalEnjoyment = 0; //variable to return the optimal enjoyment
        int maxItemIndex = -1;

        for(int i = 0; i < foodList.length; i++){ //go over the whole list

            int amount = capacity/foodList[i].getWeight(); // get the unit amount that can fit in the stomach

            double itemEnjoyment = amount*foodList[i].getEnjoyment(); //get the total enjoyment level reached

            if (maxEnjoyment < itemEnjoyment){
                maxEnjoyment = itemEnjoyment;
                maxItemIndex = i;
            }

        }

        if (maxItemIndex != -1){ //check that a max enjoyment item was found
            optimalEnjoyment+=maxEnjoyment;
            capacity = capacity%foodList[maxItemIndex].getWeight(); //reduce the capacity left
            System.out.print(optimalEnjoyment + " " + capacity + " ");
            optimalEnjoyment+=optimizationAlgorithm(foodList,capacity);
        }

            return optimalEnjoyment;


    }
}
