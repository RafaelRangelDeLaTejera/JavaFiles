import java.util.Locale;

public class CashRegister {

    /**
     *
     */
    public CashRegister(String price) {
        System.out.println(price);

        /** to make computations with bills and coint easier have the price in whole and decimal units */
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

}

//, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies