import java.util.ArrayList;

public class ThanskgivingStomachOptimization {

    public ThanskgivingStomachOptimization() {}

    public static int optimizationAlgorithm(FoodItem[] foodList, int capacity){

        int maxEnjoyment = 0;
        int totalEnjoyment = 0;
        int maxItemIndex = -1;

        for(int i = 0; i < foodList.length; i++){ //go over the whole list

            int amount = capacity/foodList[i].getWeight(); // get the unit amount that can fit in the stomach

            int volumeEnjoyment = amount*foodList[i].getEnjoyment(); //get the total enjoyment level reached

            if (maxEnjoyment < volumeEnjoyment){
                maxEnjoyment = volumeEnjoyment;
                maxItemIndex = i;
            }

        }

        if (maxItemIndex != -1){ //check that a max enjoynment item was found
            totalEnjoyment+=maxEnjoyment;
            capacity = capacity%foodList[maxItemIndex].getWeight(); //reduce the capacity left
            totalEnjoyment+=optimizationAlgorithm(foodList,capacity);
        }

            return totalEnjoyment;


    }
}
