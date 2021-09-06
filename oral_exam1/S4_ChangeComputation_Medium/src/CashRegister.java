import java.util.Locale;

public class CashRegister {


    /**
     * constructor
     */
    public CashRegister(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies) {
        System.out.println(price);

//        /** to make computations with bills and coin easier have the price in whole and decimal units */
//        /** get whole units and convert the string value to an int value */
//        String wholeNumber = price.substring(0, price.indexOf("."));
//        System.out.println(wholeNumber);
//        int priceDollars = Integer.parseInt(wholeNumber);
//
//        /** get decimal units from input string and convert them to integers, this will be the cents */
//        String decimalNumber = price.substring(price.indexOf(".")+1);
//        System.out.println(decimalNumber);
//        int priceCents = Integer.parseInt(decimalNumber);
        CurrencyUSD itemPriceInUSCurrency = new CurrencyUSD(price);

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*//*
        *//**class private member variables *//*
        int dollarsPaid = sumDollars(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);
        int centsPaid = sumCents(quarters, dimes, nickels, pennies);*/
        CurrencyUSD amountInUSCurrency = new CurrencyUSD(sumTotalDollarsAndCents(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies));

//       /**Get the amount of change in USD that that will be returned to the user*/
//        int changeInUSDollars = dollarsPaid - priceDollars;
//        int changeInUSCents = centsPaid - priceCents;
        CurrencyUSD changeInUSD = new CurrencyUSD(amountInUSCurrency.substractUSCurrencyAmounts(itemPriceInUSCurrency));
        ChangeInEuroCurrencyUnits changeForCostumer = new ChangeInEuroCurrencyUnits(changeInUSD,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);


    }

    /**sum of Dollars and cents */
    public String sumTotalDollarsAndCents(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent){
        String totalUSD = "";
        String cents = "00";

        int dollarCentSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)/100;

        int sum = twentyDollars*20 + tenDollars*10 + fiveDollars*5 + oneDollar + dollarCentSum;

        int centSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)%100;

        if (centSum != 0){
            cents = String.valueOf(centSum);
        }

        totalUSD = String.valueOf(sum) + "." + cents;

        return totalUSD;
    }

    public int sumDollars(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {

        /**get the sum of the dollars from the cents, by summing all the cents up and dividing them by a 100 using int division, since a 100 cents are 1 dollar*/
        int dollarCentSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)/100;

        int sum = twentyDollars*20 + tenDollars*10 + fiveDollars*5 + oneDollar + dollarCentSum;

        return sum;
    }

    public int sumCents(int twentyFiveCents, int tenCents, int fiveCents, int oneCent) {
        /** get the total remaining cents on the amount paid with using the modulus operand */
        int centSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)%100;

        return centSum;
    }

    public String changeDollarsToEuro(int dollarsUS, int centsUSD) {
        String euros = "";

        /** convert dollars to Euros with conversion factor of 1 USD = 0.8419 Euros and keeping the int precision of using whole units and cents of currency separately to avoid double or float imprecision */
        int totalAmountOfCentEuros = (dollarsUS * 8419) / 100 + (centsUSD * 8419) / 10000;

        int wholeEuros = totalAmountOfCentEuros / 100; //dont need to worry about USD cent because they cant add up to one euro since one dollar is just 0.84 of a dollar
        int centEuros = totalAmountOfCentEuros % 100;

        /**check if exact amount was reached, if not then go over by smallest amount (one cent Euro)*/
        if (((dollarsUS * 8419) % 100) != 0 || ((centsUSD * 8419) % 10000 != 0)) ;
        {
            centEuros++;

            if (centEuros % 100 == 0) //in case the cents added up to one Euro when the cent was added
            {
                centEuros = 0;
                wholeEuros++;
            }
        }
        return "yes";
    }
    /*public String changeUSCentsToEuroCents(int )

        *//**if statement to check how much of each bill of cent will be returned as change*//*
        int returnTwentyEuroBills = wholeEuros/20;
        int returnTenEuroBills = wholeEuros/10;
        int returnFiveEuroBills = wholeEuros/5;
        int returnOneEuroBills = wholeEuros;

        int returnFiftyEuroCoins = centEuros/50;
        int returnTwentyEuroCoins = centEuros/20;
        int returnTenEuroCoins = centEuros/10;
        int returnFiveEuroCoins = centEuros/5;
        int returnOneEuroCoins = centEuros;

        return euros;
    }*/

    /**
     * method to check what bills the costumer paid with to return change in preferably those same bills
     */
    /*public void checkBillsPayedWith(){

    }*/
}

//