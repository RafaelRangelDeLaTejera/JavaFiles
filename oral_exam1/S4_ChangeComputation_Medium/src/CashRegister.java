import java.util.Locale;

public class CashRegister {


    private String changeInEuros;

    public CashRegister() {
        changeInEuros = "0.00";
    }

    /**
     * constructor
     */




    public CashRegister(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies) {
        System.out.println(price);

        CurrencyUSD itemPriceInUSCurrency = new CurrencyUSD(price);
        itemPriceInUSCurrency.printUSD();

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/

        CurrencyUSD amountInUSCurrency = new CurrencyUSD(sumTotalDollarsAndCents(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies));
        amountInUSCurrency.printUSD();

        CurrencyUSD changeInUSD = new CurrencyUSD(amountInUSCurrency.substractUSCurrencyAmounts(itemPriceInUSCurrency));
        changeInUSD.printUSD();
        ChangeInEuroCurrencyUnits changeForCostumer = new ChangeInEuroCurrencyUnits(changeInUSD,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);
        changeInEuros = changeForCostumer.getUnitsOfChangeInEuro();
        System.out.println(changeInEuros);

    }

    /**sum of Dollars and cents */
    public String sumTotalDollarsAndCents(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent){
        String totalUSD = "";
        String cents = "00";

        int dollarCentSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)/100;

        int sum = twentyDollars*20 + tenDollars*10 + fiveDollars*5 + oneDollar + dollarCentSum;

        int centSum = (twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent)%100;

        if (centSum != 0 ){
            cents = String.valueOf(centSum);
        }

        totalUSD = String.valueOf(sum) + "." + cents;

        return totalUSD;
    }

    public String computeChange(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies){
        System.out.println(price);

        CurrencyUSD itemPriceInUSCurrency = new CurrencyUSD(price);
        itemPriceInUSCurrency.printUSD();

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/

        CurrencyUSD amountInUSCurrency = new CurrencyUSD(sumTotalDollarsAndCents(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies));
        amountInUSCurrency.printUSD();

        CurrencyUSD changeInUSD = new CurrencyUSD(amountInUSCurrency.substractUSCurrencyAmounts(itemPriceInUSCurrency));
        changeInUSD.printUSD();
        ChangeInEuroCurrencyUnits changeForCostumer = new ChangeInEuroCurrencyUnits(changeInUSD,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);
        changeInEuros = changeForCostumer.getUnitsOfChangeInEuro();
        System.out.println(changeInEuros);

        return changeInEuros;
    }
}

