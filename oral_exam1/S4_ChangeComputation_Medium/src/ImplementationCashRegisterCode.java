import java.util.Scanner;

public class ImplementationCashRegisterCode {
    public static void main(String[] args) {

        /** create input object of the scanner class to read in from the user
         * the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        /** Promp user to enter item price */
        System.out.print("Enter the Items's price, use decimal point for cents:");

        /** read in from user the next input available */
        String price = input.next();

        CashRegister cashRegister = new CashRegister(price);

    }
}
