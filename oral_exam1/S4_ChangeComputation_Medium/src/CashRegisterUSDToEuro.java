public class CashRegisterUSDToEuro {

    private int changeInUSDCents;
    private int changeInEuroCents;

    public CashRegisterUSDToEuro() {

    }

    public int sumTotalDollarsAndCents(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent){

        int cents = twentyDollars*2000 + tenDollars*1000 + fiveDollars*500 + oneDollar*100 + twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent;

        return cents;
    }

    public int totalPriceInCents(String dollarAmount) {

        int priceCents = 0;

        if (dollarAmount.contains(".") && dollarAmount.substring(dollarAmount.indexOf(".")+1) != "00" && dollarAmount.substring(dollarAmount.indexOf(".")+1) != "0"){
            String wholeNumber = dollarAmount.substring(0, dollarAmount.indexOf("."));
            String decimalNumber = dollarAmount.substring(dollarAmount.indexOf(".")+1);
            priceCents = Integer.parseInt(wholeNumber)*100+Integer.parseInt(decimalNumber);
        }
        else
        {
            priceCents = Integer.parseInt(dollarAmount)*100;
        }

        return priceCents;

    }

    public int changeFromUSToEuroCurrency(int centsUS){
        int changeInEuroCents;

        changeInEuroCents = (centsUS*8419)/10000;

        if ((centsUS*8419)%10000 != 0) ;
        {
            changeInEuroCents++;
        }

        return changeInEuroCents;
    }

    public void printAmount(int totalCents){

        int wholeUnits = totalCents/100;
        int decimalUnits = totalCents%100;

        if (decimalUnits == 0){
            System.out.println(wholeUnits +"."+decimalUnits);
        }
        else
        {
            System.out.println(wholeUnits +"."+decimalUnits);
        }
    }

    public void displayUnitsOfChangeInEuroCurrency(int totalChangeInCents, int twentyBills, int tenBills, int fiveBills, int oneBills, int twentyFiveCent, int tenCent, int fiveCent, int oneCent){
        /**determine which bills and coins will be used to pay back */

        int centsCount = totalChangeInCents;

        int noOfTwentyEuroBills = 0;
        int noOfTenEuroBills = 0;
        int noOfFiveEuroBills = 0;
        int noOfOneEuroBills = 0;
        int noOfFiftyCentCoins = 0;
        int noOfTwentyCentCoins = 0;
        int noOfTenCentCoins = 0;
        int noOfFiveCentCoins = 0;
        int noOfTOneCentCoins = 0;

        noOfTwentyEuroBills = determineUnits(totalChangeInCents,twentyBills,2000);
        totalChangeInCents -= noOfTwentyEuroBills*2000;
        noOfTenEuroBills = determineUnits(totalChangeInCents,tenBills,1000);
        totalChangeInCents -= noOfTenEuroBills*1000;
        noOfFiveEuroBills = determineUnits(totalChangeInCents,fiveBills,500);
        totalChangeInCents -= noOfFiveEuroBills*500;
        noOfOneEuroBills = determineUnits(totalChangeInCents,oneBills,100);
        totalChangeInCents -= noOfOneEuroBills*100;

        if (getTotalEuroCents() != 0){
            noOfTwentyEuroBills += totalChangeInCents/2000;
            totalChangeInCents = totalChangeInCents%2000;

            noOfTenEuroBills += totalChangeInCents/1000;
            totalChangeInCents = totalChangeInCents%1000;

            noOfFiveEuroBills += totalChangeInCents/500;
            totalChangeInCents = totalChangeInCents%500;

            noOfOneEuroBills += totalChangeInCents/100;
            totalChangeInCents = totalChangeInCents%100;

            noOfFiftyCentCoins += totalChangeInCents/50;
            totalChangeInCents = totalChangeInCents%50;
            noOfTwentyCentCoins += totalChangeInCents/20;
            totalChangeInCents = totalChangeInCents%20;
            noOfTenCentCoins += totalChangeInCents/10;
            totalChangeInCents = totalChangeInCents%10;
            noOfFiveCentCoins += totalChangeInCents/5;
            totalChangeInCents = totalChangeInCents%5;
            noOfTOneCentCoins += totalChangeInCents;
            totalChangeInCents = totalChangeInCents%2000;
        }

//        String changeInEuroUnits = "Number of each Bill and Coin to return to costumer: \n" +
//                "20 Euro Bills: " + noOfTwentyEuroBills + "\n" +
//                "10 Euro Bills: " + noOfTenEuroBills + "\n" +
//                "5 Euro Bills: " + noOfFiveEuroBills + "\n" +
//                "1 Euro Bills: " + noOfOneEuroBills + "\n" +
//                "50 Euro Cents: " + noOfFiftyCentCoins + "\n" +
//                "20 Euro Cents: " + noOfTwentyCentCoins + "\n" +
//                "10 Euro Cents: " + noOfTenCentCoins + "\n" +
//                "5 Euro Cents: " + noOfFiveCentCoins + "\n" +
//                "1 Euro Cents: " + noOfTOneCentCoins + "\n";
//
//        System.out.println(changeInEuroUnits);

        checkUnits("twenty Euro Bills",noOfTwentyEuroBills);
        checkUnits("Ten Euro Bills",noOfTenEuroBills);
        checkUnits("Five Euro Bills",noOfFiveEuroBills);
        checkUnits("One Euro Bills",noOfOneEuroBills);
        checkUnits("Fifty Euro Cents",noOfFiftyCentCoins);
        checkUnits("twenty Euro Cents",noOfTwentyCentCoins);
        checkUnits("ten Euro Cents",noOfTenCentCoins);
        checkUnits("Five Euro Cents",noOfFiveCentCoins);
        checkUnits("One Euro Cents",noOfTOneCentCoins);

        //return changeInEuroUnits;
    }

    public int determineUnits(int totalCents, int noOfUnit, int valueInCents){
        int noOfEuroBills = 0;
        if (noOfUnit !=0 && totalCents/valueInCents > 0){
            if (noOfUnit >= totalCents/valueInCents){
                noOfEuroBills = totalCents/valueInCents;

            }
            else if (noOfUnit < getTotalEuroCents()/valueInCents){
                noOfEuroBills = noOfUnit;
                setTotalEuroCents(getTotalEuroCents()-valueInCents*noOfEuroBills);
            }
        }
        return noOfEuroBills;
    }

    public void checkUnits(String Unit, int unitNumber){
        if (unitNumber!=0){
            setUnitsOfChangeInEuro(getUnitsOfChangeInEuro() + ", " + unitNumber + " " + Unit);
        }
    }



    public void computeChange(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies){

        int priceInUSCents = totalPriceInCents(price);

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/

        int amountPaidInUSCents = sumTotalDollarsAndCents(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);

         int changeInUSCents = amountPaidInUSCents - priceInUSCents;

        int changeInEuros = changeFromUSToEuroCurrency(changeInUSCents);

        printAmount(changeInEuros);

        displayUnitsOfChangeInEuroCurrency(int totalChangeInCents, int twentyBills, int tenBills, int fiveBills, int oneBills, int twentyFiveCent, int tenCent, int fiveCent, int oneCent);

        ChangeInEuroCurrencyUnits(changeInUSD,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);
        changeInEuros = changeForCostumer.getUnitsOfChangeInEuro();
        System.out.println(changeInEuros);

        return changeInEuros;
    }
}
