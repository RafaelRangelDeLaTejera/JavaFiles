import java.util.Scanner;

/**
 * driver class for the ThanksgivingStomachOptimization class, this class implements a command line interface for user to to optimize their thanksgiving dinner
 */
public class Driver {

    /**
     * main method to run command line interface implementing the thanksgivingStomachOptimization class
     * @param args for when the program is executed from the command line and special arguments are passed in
     */
    public static void main(String[] args) {

        /* create input object of the scanner class to read in from the user
          the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        // Promp user to enter item price
        System.out.print("Get the optimal enjoyment for your thanksgiving dinner\n");

        System.out.print("Enter the weight of the turkey unit: ");
        // read in from user the next input string available
        double turkeyWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the turkey unit: ");
        // read in from user the next input string available
        double turkeyEnjoyment = input.nextDouble();

        FoodItem turkey = new FoodItem(turkeyWeight,turkeyEnjoyment,"turkey");

        System.out.print("Enter the weight of the pumpkin pie unit: ");
        // read in from user the next input string available
        double pieWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the pumpkin pie unit: ");
        // read in from user the next input string available
        double pieEnjoyment = input.nextDouble();

        FoodItem pumpkinPie = new FoodItem(pieWeight,pieEnjoyment,"pie");

        System.out.print("Enter the weight of the mashed potatoes unit: ");
        // read in from user the next input string available
        double potatoesWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the mashed potatoes unit: ");
        // read in from user the next input string available
        double potatoesEnjoyment = input.nextDouble();

        FoodItem mashedPotatoes = new FoodItem(potatoesWeight,potatoesEnjoyment,"potatoes");

        System.out.print("Enter the weight of the gravy unit: ");
        // read in from user the next input string available
        double gravyWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the gravy unit: ");
        // read in from user the next input string available
        double gravyEnjoyment = input.nextDouble();

        FoodItem gravy = new FoodItem(gravyWeight,gravyEnjoyment,"gravy");

        System.out.print("Enter the weight of the stuffing unit: ");
        // read in from user the next input string available
        double stuffingWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the stuffing unit: ");
        // read in from user the next input string available
        double stuffingEnjoyment = input.nextDouble();

        FoodItem stuffing = new FoodItem(stuffingWeight,stuffingEnjoyment,"stuffing");

        System.out.print("Enter the weight of the cranberries unit: ");
        // read in from user the next input string available
        double cranberriesWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the cranberries unit: ");
        // read in from user the next input string available
        double cranberriesEnjoyment = input.nextDouble();

        FoodItem cranberries = new FoodItem(cranberriesWeight,cranberriesEnjoyment,"cranberries");

        System.out.print("Enter the weight of the casserole unit: ");
        // read in from user the next input string available
        double casseroleWeight = input.nextDouble();
        System.out.print("Enter the enjoyment of the casserole unit: ");
        // read in from user the next input string available
        double casseroleEnjoyment = input.nextDouble();

        FoodItem casserole = new FoodItem(casseroleWeight,casseroleEnjoyment,"casserole");

        System.out.print("Enter the capacity of the Stomach: ");
        double capacity = input.nextDouble();

        FoodItem[] foods = {turkey,pumpkinPie,mashedPotatoes,gravy,stuffing,cranberries,casserole};

        double optimalEnjoyment = ThanksgivingStomachOptimization.optimizationAlgorithm(foods, capacity);
        System.out.print("Optimal enjoyment: " + optimalEnjoyment);

    }
}
