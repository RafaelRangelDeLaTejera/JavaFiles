import java.util.Locale;

public class CashRegister {

    /**class private member variables */
    private int dollarsPaid;
    private int centsPaid;

    /**
     *
     */
    public CashRegister(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies) {
        System.out.println(price);

        /** to make computations with bills and coin easier have the price in whole and decimal units */
        /** get whole units and convert the string value to an int value */
        String wholeNumber = price.substring(0, price.indexOf("."));
        System.out.println(wholeNumber);
        int wholeUSDAmount = Integer.parseInt(wholeNumber);

        //** get decimal units from input string and convert them to integers, this will be the cents
        String decimalNumber = price.substring(price.indexOf(".")+1);
        System.out.println(decimalNumber);
        int decimalUSDAmount = Integer.parseInt(decimalNumber);

        System.out.println(wholeUSDAmount + "." + decimalUSDAmount);


    }

    public int sumDollars(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {
        int sum = 0;

        /**get the sum of the dollars from the cents, if they ad up to dollars*/


        sum = twentyDollars + tenDollars + fiveDollars + oneDollar;

        return sum;
    }

    public void sumCents(int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {
        //devide and use %
    }
}

//