import java.util.Scanner;

/**
 * implementation class for the CashRegisterUSDToEuro class.
 * This class interact with the user directly through the terminal asking for direct input and then using a CashRegister object to pass in the values
 * inputted by the user to the computeChange method as parameters for the change in Euros to be computed and display the bills and coins to be returned.
 */
public class ImplementationCashRegisterCode {
    public static void main(String[] args) {


        /* create input object of the scanner class to read in from the user
          the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        // Promp user to enter item price
        System.out.print("Enter the Items's price, use decimal point for cents:");
        // read in from user the next input string available
        String price = input.next();

        /*Prompt user to enter the amount of each bill or coin that was given
        if statement to display the options of the bills or coins depending on the price and prompt the user to type the amount of each unit and then read it in */
        System.out.print("amount of 20 dollar bills given, enter 0 for none or the number given:");
        int twentyDollars = input.nextInt();
        System.out.print("amount of 10 dollar bills given, enter 0 for none or the number given:");
        int tenDollars = input.nextInt();
        System.out.print("amount of 5 dollar bills given, enter 0 for none or the number given:");
        int fiveDollars = input.nextInt();
        System.out.print("amount of 1 dollar bills given, enter 0 for none or the number given:");
        int oneDollars = input.nextInt();
        System.out.print("amount of 25 cent coin (quarter) given, enter 0 for none or the number given:");
        int twentyFiveCents = input.nextInt();
        System.out.print("amount of 10 dollar bills given, enter 0 for none or the number given:");
        int tenCents = input.nextInt();
        System.out.print("amount of 5 dollar bills given, enter 0 for none or the number given:");
        int fiveCents = input.nextInt();
        System.out.print("amount of 1 dollar bills given, enter 0 for none or the number given:");
        int oneCent = input.nextInt();



        /*initialize a CashRegister object to call the computeChange method from the CashRegister class and pass in the values the user provided to calculate the change in Euros
          and display the Euro bills and coins to be returned */

        CashRegisterUSDToEuro cashRegister = new CashRegisterUSDToEuro();
        cashRegister.computeChange(price,twentyDollars,tenDollars,fiveDollars,oneDollars,twentyFiveCents,tenCents,fiveCents,oneCent);

    }
}
