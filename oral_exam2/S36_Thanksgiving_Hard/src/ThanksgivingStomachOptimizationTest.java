import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUNIT test class for the optimization algorithm with several test cases
 */
class ThanksgivingStomachOptimizationTest {

    /**
     * test the optimization algorithm with several test cases
     */
    @Test
    void optimizationAlgorithm() {
        FoodItem turkey = new FoodItem("turkey");
        FoodItem pie = new FoodItem("pie");
        FoodItem potatoes = new FoodItem("potatoes");
        FoodItem gravy = new FoodItem("gravy");
        FoodItem stuffing = new FoodItem("stuffing");
        FoodItem cranberries = new FoodItem("cranberries");
        FoodItem casserole = new FoodItem("casserole");

        FoodItem[] foods = {turkey,pie,potatoes,gravy,stuffing,cranberries,casserole};

        //first test values
        foods[0].setWeight(3);
        foods[0].setEnjoyment(4);
        foods[1].setWeight(2);
        foods[1].setEnjoyment(2);
        foods[2].setWeight(4);
        foods[2].setEnjoyment(5);
        foods[3].setWeight(10);
        foods[3].setEnjoyment(10);
        foods[4].setWeight(2);
        foods[4].setEnjoyment(3);
        foods[5].setWeight(7);
        foods[5].setEnjoyment(5);
        foods[6].setWeight(12);
        foods[6].setEnjoyment(17);
        assertEquals(30, ThanksgivingStomachOptimization.optimizationAlgorithm(foods,20));

        //second test values
        foods[0].setWeight(3);
        foods[0].setEnjoyment(4);
        foods[1].setWeight(2);
        foods[1].setEnjoyment(2);
        foods[2].setWeight(4);
        foods[2].setEnjoyment(5);
        foods[3].setWeight(1);
        foods[3].setEnjoyment(1);
        foods[4].setWeight(2);
        foods[4].setEnjoyment(3);
        foods[5].setWeight(10);
        foods[5].setEnjoyment(14);
        foods[6].setWeight(15);
        foods[6].setEnjoyment(24);
        assertEquals(64, ThanksgivingStomachOptimization.optimizationAlgorithm(foods,41));

        //third test values
        foods[0].setWeight(3);
        foods[0].setEnjoyment(5);
        foods[1].setWeight(4);
        foods[1].setEnjoyment(12);
        foods[2].setWeight(1);
        foods[2].setEnjoyment(1);
        foods[3].setWeight(2);
        foods[3].setEnjoyment(5);
        foods[4].setWeight(1);
        foods[4].setEnjoyment(1);
        foods[5].setWeight(2);
        foods[5].setEnjoyment(2);
        foods[6].setWeight(3);
        foods[6].setEnjoyment(3);
        assertEquals(18, ThanksgivingStomachOptimization.optimizationAlgorithm(foods,7));

        //fourth test values
        foods[0].setWeight(3);
        foods[0].setEnjoyment(6);
        foods[1].setWeight(4);
        foods[1].setEnjoyment(9);
        foods[2].setWeight(1);
        foods[2].setEnjoyment(0.5);
        foods[3].setWeight(2);
        foods[3].setEnjoyment(4);
        foods[4].setWeight(1);
        foods[4].setEnjoyment(1);
        foods[5].setWeight(2);
        foods[5].setEnjoyment(2);
        foods[6].setWeight(3);
        foods[6].setEnjoyment(3);
        assertEquals(19, ThanksgivingStomachOptimization.optimizationAlgorithm(foods,9));

        //fifth test values
        foods[0].setWeight(6);
        foods[0].setEnjoyment(7);
        foods[1].setWeight(7);
        foods[1].setEnjoyment(8);
        foods[2].setWeight(8);
        foods[2].setEnjoyment(9);
        foods[3].setWeight(9);
        foods[3].setEnjoyment(10);
        foods[4].setWeight(10);
        foods[4].setEnjoyment(11);
        foods[5].setWeight(11);
        foods[5].setEnjoyment(12);
        foods[6].setWeight(12);
        foods[6].setEnjoyment(13);
        assertEquals(0, ThanksgivingStomachOptimization.optimizationAlgorithm(foods,5));
    }
}