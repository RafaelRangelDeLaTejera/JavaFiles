public class CashRegisterUSDToEuro {

    private final int conversionRate = 8419;

    private String displayChangeInEuroUnits;

    public CashRegisterUSDToEuro() {

        displayChangeInEuroUnits = "";

    }

    public String getDisplayChangeInEuroUnits() {
        return displayChangeInEuroUnits;
    }

    public void setDisplayChangeInEuroUnits(String displayChangeInEuroUnits) {
        this.displayChangeInEuroUnits = displayChangeInEuroUnits;
    }

    public int sumTotalDollarsAndCentsPaid(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent){

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

        changeInEuroCents = (centsUS*conversionRate)/10000;

        if ((centsUS*conversionRate)%10000 != 0)  //(centsUS*conversionRate)%10000 != 0
        {
            changeInEuroCents++;
        }


        return changeInEuroCents;
    }

    public String amountToReturn(int totalCents){

        String amount;
        int wholeUnits = totalCents/100;
        int decimalUnits = totalCents%100;

        if (decimalUnits == 0){
            amount = wholeUnits + ".00";
        }
        else if (decimalUnits < 10)
        {
            amount = wholeUnits + ".0" + decimalUnits;
        }
        else
        {
            amount = wholeUnits + "." + decimalUnits;
        }

        return amount;
    }

    public String displayUnitsOfChangeInEuroCurrency(int totalChangeInCents, int twentyBills, int tenBills, int fiveBills, int oneBills, int twentyFiveCent, int tenCent, int fiveCent, int oneCent){
        /**determine which bills and coins will be used to pay back */

        if (totalChangeInCents == 0 ){
            setDisplayChangeInEuroUnits("No bills or coins to return");
        }
        else {
            setDisplayChangeInEuroUnits("Return to costumer");

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

            noOfTwentyEuroBills = determineUnits(totalChangeInCents, twentyBills, 2000);
            totalChangeInCents -= noOfTwentyEuroBills * 2000;
            noOfTenEuroBills = determineUnits(totalChangeInCents, tenBills, 1000);
            totalChangeInCents -= noOfTenEuroBills * 1000;
            noOfFiveEuroBills = determineUnits(totalChangeInCents, fiveBills, 500);
            totalChangeInCents -= noOfFiveEuroBills * 500;
            noOfOneEuroBills = determineUnits(totalChangeInCents, oneBills, 100);
            totalChangeInCents -= noOfOneEuroBills * 100;

            if (totalChangeInCents != 0) {
                noOfTwentyEuroBills += totalChangeInCents / 2000;
                totalChangeInCents = totalChangeInCents % 2000;

                noOfTenEuroBills += totalChangeInCents / 1000;
                totalChangeInCents = totalChangeInCents % 1000;

                noOfFiveEuroBills += totalChangeInCents / 500;
                totalChangeInCents = totalChangeInCents % 500;

                noOfOneEuroBills += totalChangeInCents / 100;
                totalChangeInCents = totalChangeInCents % 100;

                noOfFiftyCentCoins += totalChangeInCents / 50;
                totalChangeInCents = totalChangeInCents % 50;

                noOfTwentyCentCoins += totalChangeInCents / 20;
                totalChangeInCents = totalChangeInCents % 20;

                noOfTenCentCoins += totalChangeInCents / 10;
                totalChangeInCents = totalChangeInCents % 10;

                noOfFiveCentCoins += totalChangeInCents / 5;
                totalChangeInCents = totalChangeInCents % 5;

                noOfTOneCentCoins += totalChangeInCents;
                totalChangeInCents -= totalChangeInCents;
            }

            checkUnits("Twenty Euro Bills", noOfTwentyEuroBills);
            checkUnits("Ten Euro Bills", noOfTenEuroBills);
            checkUnits("Five Euro Bills", noOfFiveEuroBills);
            checkUnits("One Euro Bills", noOfOneEuroBills);
            checkUnits("Fifty Euro Cent coins", noOfFiftyCentCoins);
            checkUnits("Twenty Euro Cent coins", noOfTwentyCentCoins);
            checkUnits("Ten Euro Cent coins", noOfTenCentCoins);
            checkUnits("Five Euro Cent coins", noOfFiveCentCoins);
            checkUnits("One Euro Cent coins", noOfTOneCentCoins);
        }
        //System.out.println(getDisplayChangeInEuroUnits());

        return getDisplayChangeInEuroUnits();

    }

    public int determineUnits(int totalCents, int noOfUnit, int valueInCents){
        int noOfEuroBills = 0;
        if (noOfUnit !=0 && totalCents/valueInCents > 0){
            if (noOfUnit >= totalCents/valueInCents){
                noOfEuroBills = totalCents/valueInCents;

            }
            else if (noOfUnit < totalCents/valueInCents){
                noOfEuroBills = noOfUnit;
            }
            else if (noOfUnit == 0){
                noOfEuroBills = 0;
            }
        }
        return noOfEuroBills;
    }

    public void checkUnits(String Unit, int unitNumber){
        if (unitNumber!=0){
            setDisplayChangeInEuroUnits(getDisplayChangeInEuroUnits() + ", " + unitNumber + " " + Unit);
        }
    }



    public void computeChange(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies){

        int priceInUSCents = totalPriceInCents(price);

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/

        int amountPaidInUSCents = sumTotalDollarsAndCentsPaid(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);

         int changeInUSCents = amountPaidInUSCents - priceInUSCents;

        int changeInEuroCents = changeFromUSToEuroCurrency(changeInUSCents);

        amountToReturn(changeInEuroCents);

        setDisplayChangeInEuroUnits("Change amount: " + amountToReturn(changeInEuroCents) + " euros" + "\n" + displayUnitsOfChangeInEuroCurrency(changeInEuroCents,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies)+"\n");

        System.out.print(getDisplayChangeInEuroUnits());
        //System.out.print(displayUnitsOfChangeInEuroCurrency(changeInEuroCents,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies));
    }
}
