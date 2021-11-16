import java.util.ArrayList;

public class ThanksgivingStomachOptimization {

    public ThanksgivingStomachOptimization() {}

    public static double optimizationAlgorithm(FoodItem[] foodList, double capacity){

        double maxEnjoymentPerVolumeUnit = 0; //hold max enjoyment
        double optimalEnjoyment = 0; //variable to return the optimal enjoyment
        int maxItemIndex=-1;

        double enjoymentPerVolumeUnit = 0;

        for(int i = 0; i < foodList.length; i++){ //go over the whole list
            if ((int)(capacity/foodList[i].getWeight())!=0){ //if the weight fits into the capacity
           // int amount = capacity/foodList[i].getWeight(); // get the unit amount that can fit in the stomach
            enjoymentPerVolumeUnit = foodList[i].getEnjoyment()/foodList[i].getWeight();

                //System.out.print(optimalEnjoyment + " " + capacity + " ");

            // double itemEnjoyment = amount*foodList[i].getEnjoyment(); //get the total enjoyment level reached

            if (maxEnjoymentPerVolumeUnit <= enjoymentPerVolumeUnit && capacity!=0){
                maxEnjoymentPerVolumeUnit = enjoymentPerVolumeUnit;
                maxItemIndex = i;
            }}

        }

        if (maxItemIndex != -1){ //check that a max enjoyment item was found

        int amount = (int)(capacity/foodList[maxItemIndex].getWeight());
            optimalEnjoyment+= amount*foodList[maxItemIndex].getEnjoyment();
            capacity = capacity - amount*foodList[maxItemIndex].getWeight(); //reduce the capacity left

            System.out.print(optimalEnjoyment + " " + capacity + " ");

            optimalEnjoyment+=optimizationAlgorithm(foodList,capacity);
        }

            return optimalEnjoyment;


    }
}
