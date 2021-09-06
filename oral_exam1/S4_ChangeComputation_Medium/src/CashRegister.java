import java.util.Locale;

public class CashRegister {

    /**
     *
     */
    public CashRegister(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies) {
        System.out.println(price);

        /** to make computations with bills and coin easier have the price in whole and decimal units */
        /** get whole units and convert the string value to an int value */
        String wholeNumber = price.substring(0, price.indexOf("."));
        System.out.println(wholeNumber);
        int priceDollars = Integer.parseInt(wholeNumber);

        /** get decimal units from input string and convert them to integers, this will be the cents */
        String decimalNumber = price.substring(price.indexOf(".")+1);
        System.out.println(decimalNumber);
        int priceCents = Integer.parseInt(decimalNumber);

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/
        /**class private member variables */
        int dollarsPaid = sumDollars(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);
        int centsPaid = sumCents(quarters, dimes, nickels, pennies);

       /**Get the amount of change in USD that that will be returned to the user*/
        int changeInUSDollars = dollarsPaid - priceDollars;
        int changeInUSCents = centsPaid - priceCents;

    }

    public int sumDollars(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {


        /**get the sum of the dollars from the cents, by summing all the cents up and dividing them by a 100 using int division, since a 100 cents are 1 dollar*/
        int dollarCentSum = (twentyFiveCents + tenCents + fiveCents + oneCent)/100;

        int sum = twentyDollars + tenDollars + fiveDollars + oneDollar + dollarCentSum;

        return sum;
    }

    public int sumCents(int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {
        /** get the total remaining cents on the amount paid with using the modulus operand */
        int centSum = (twentyFiveCents + tenCents + fiveCents + oneCent)%100;

        return centSum;
    }
}

//