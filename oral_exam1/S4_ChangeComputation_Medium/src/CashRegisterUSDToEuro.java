/**
 * CashRegisterClass
 */
public class CashRegisterUSDToEuro {

    /**
     * Final instance data member conversion rate of type int, which is the value in Euro Cents of 1000 US cents, when the program is used this
     * can be change according to the conversion rate at the time of usage, this is declared as an instance variable in order for it to be
     * easier to change for the user
     */
    private final int conversionRate = 8419;

    /**
     * Instance data member of type String that will hold the string to be displayed after computation with the change amount in Euros and the Euro bills and coins to be given to costumer
     */
    private String displayChangeInEuroUnits;

    /**
     * CashRegister no parameter constructor that initializes the displayChangeInEuroUnits to an empty string
     */
    public CashRegisterUSDToEuro() {

        displayChangeInEuroUnits = "";

    }

    /**
     * public getter for the displayChangeInEuroUnits instance variable
     * @return the string held in the instance variable displayChangeInEuroUnits
     */
    public String getDisplayChangeInEuroUnits() {
        return displayChangeInEuroUnits;
    }

    /**
     * setter for the displayChangeInEuroUnits instance variable
     * @param displayChangeInEuroUnits the string to be held in the displayChangeInEuroUnits
     */
    public void setDisplayChangeInEuroUnits(String displayChangeInEuroUnits) {
        this.displayChangeInEuroUnits = displayChangeInEuroUnits;
    }

    /**
     * sumTotalUSCentsPaid method to add up all the bills and coins the costumer paid with and get the total amount in US cents
     * @param twentyDollars number of twenty dollar bills the costumer paid with
     * @param tenDollars number of ten dollar bills the costumer paid with
     * @param fiveDollars number of five dollar bills the costumer paid with
     * @param oneDollar number of one dollar bills the costumer paid with
     * @param twentyFiveCents number of quarters the costumer paid with
     * @param tenCents number of dimes the costumer paid with
     * @param fiveCents number of nickels the costumer paid with
     * @param oneCent number of pennies the costumer paid with
     * @return int with the total amount the costumer paid with in US cents
     */
    public int sumTotalUSCentsPaid(int twentyDollars, int tenDollars, int fiveDollars, int oneDollar, int twentyFiveCents, int tenCents, int fiveCents, int oneCent){

        int cents = twentyDollars*2000 + tenDollars*1000 + fiveDollars*500 + oneDollar*100 + twentyFiveCents*25 + tenCents*10 + fiveCents*5 + oneCent;

        return cents;
    }

    /**
     * method that takes in the price of the item as a string and then changes that value to an int with the total value in US Cents.
     * the method changes the whole dollars before the point (if there is a point) into int and turns the dollars into cents and whats after t
     * the point is also changed into an int but now just added to the previous obtained cents, this way getting the total value in cents.
     * @param dollarAmount string with the item price
     * @return int holding the price of the item in USCents
     */
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

    /**
     * method to change a passed in US cents amount to Euro cents using the instance variable conversionFactor (edit the variable on its definition in case the conversion factor has changed)
     * if the conversion was not exact, one cent was added to the Euro cents value
     * @param centsUS the amouont of US cents that needs to be converted into Euro cents
     * @return the value of the US cents in Euro cents
     */
    public int changeFromUSToEuroCurrency(int centsUS){
        int changeInEuroCents;

        changeInEuroCents = (centsUS*conversionRate)/10000;

        if ((centsUS*conversionRate)%10000 != 0)  //(centsUS*conversionRate)%10000 != 0
        {
            changeInEuroCents++;
        }


        return changeInEuroCents;
    }

    /**
     * method to change the value of the totalCents to be given, into normal convention of whole Euros and cents instead of just the cents
     * @param totalCents the amount of cents to be given to the costumer
     * @return string holding the quantity in normal currency convention (whole unit point cents)
     */
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

    /**
     * method that will determine the amount of each bill or coin to be given to costumer according to the change that needs to be returned and to the bills paid with, to give back the unit bills
     * the user paid with if possible, if not then just check what units to return according to the change that is left
     * @param totalChangeInCents total change in Euro cents to be returned
     * @param twentyBills number of twenty dollar bills the costumer paid with
     * @param tenBills number of ten dollar bills the costumer paid with
     * @param fiveBills number of five dollar bills the costumer paid with
     * @param oneBills number of one dollar bills the costumer paid with
     * @return string holding the instructions of what bills or coins to return to give to costumer
     */
    public String displayUnitsOfChangeInEuroCurrency(int totalChangeInCents, int twentyBills, int tenBills, int fiveBills, int oneBills){
        /**determine which bills and coins will be used to pay back */

        if (totalChangeInCents == 0 ){
            setDisplayChangeInEuroUnits("No bills or coins to give");
        }
        else {
            setDisplayChangeInEuroUnits("Give to costumer");

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

        return getDisplayChangeInEuroUnits();

    }

    /**
     * method used in displayUnitsOfChangeInEuroCurrency method to determine what bills should be given to user, according to the bills they paid with.
     * @param totalCents total Euro cents of change left
     * @param noOfUnit no of that specific bill the user paid with
     * @param valueInCents value in cents of the specific bill
     * @return number of bills that should be given to user according to what they first paid with
     */
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

    /**
     * method to check what bills and coins need to be givento user, if any value of that unit needs to be given to costumer, the methods adds the value with proper formating to the displayChangeInEuro
     * to let the user know what number of that bill or coint they need to give to costumer
     * @param Unit string that holds the name of the bill or coin to check
     * @param unitNumber number of that bill or coin that was used
     */
    public void checkUnits(String Unit, int unitNumber){
        if (unitNumber!=0){
            setDisplayChangeInEuroUnits(getDisplayChangeInEuroUnits() + ", " + unitNumber + " " + Unit);
        }
    }


    /**
     *method that gets called when you want to use the CashRegister class. Pass in the price of the item in USD and the amount of each bill and coin that the costumer paid with. The method will compute the
     * change to return to user and convert it to Euro currency, then display the Euro bills or coins that need to be given to costumer for the change, if possible the program will give back the unit bills
     * the costumer paid with. If the change conversion from USD to Euro is not exact, the program will go over the smallest Euro unit, one cent , to avoid any loss for the costumer.
     * @param price string holding the item price in USD, the price should be entered with a decimal point if it includes cents
     * @param twentyDollarBills int holding the number of twenty dollar bills paid with
     * @param tenDollarBills int holding the number of ten dollar bills paid with
     * @param fiveDollarBills int holding the number of five dollar bills paid with
     * @param oneDollarBills int holding the number of one dollar bills paid with
     * @param quarters int holding the number of quarters paid with
     * @param dimes int holding the number of dimes paid with
     * @param nickels int holding the number of nickels paid with
     * @param pennies int holding the number of pennies paid with
     */
    public void computeChange(String price, int twentyDollarBills, int tenDollarBills, int fiveDollarBills, int oneDollarBills, int quarters, int dimes, int nickels, int pennies){

        int priceInUSCents = totalPriceInCents(price);

        /**get the sum of the dollars and cents the costumer paid using the sumDollars and sumCents instance methods*/

        int amountPaidInUSCents = sumTotalUSCentsPaid(twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills, quarters, dimes, nickels, pennies);

         int changeInUSCents = amountPaidInUSCents - priceInUSCents;

        int changeInEuroCents = changeFromUSToEuroCurrency(changeInUSCents);

        amountToReturn(changeInEuroCents);

        setDisplayChangeInEuroUnits("Change amount: " + amountToReturn(changeInEuroCents) + " euros" + "\n" + displayUnitsOfChangeInEuroCurrency(changeInEuroCents,twentyDollarBills, tenDollarBills, fiveDollarBills, oneDollarBills)+"\n");

        System.out.print(getDisplayChangeInEuroUnits());

    }
}
