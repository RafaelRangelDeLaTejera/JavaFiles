public class ChangeInEuroCurrencyUnits {

    private int totalEuroCents = 0;
    private String unitsOfChangeInEuro;

    public ChangeInEuroCurrencyUnits(CurrencyUSD changeInDollars, int usedTwentyDollarBills, int usedTenDollarBills, int usedFiveDollarBills, int usedOneDollarBills, int usedQuarters, int usedDimes, int usedNickels, int usedPennies) {

        unitsOfChangeInEuro = "Please return to costumer";
        changeUSDToEuros(changeInDollars);
        computeUnitsOfChangeInEuro(usedTwentyDollarBills,usedTenDollarBills,usedFiveDollarBills,usedOneDollarBills,usedQuarters,usedDimes,usedNickels,usedPennies);
    }

    public String getUnitsOfChangeInEuro() {
        return unitsOfChangeInEuro;
    }

    public void setUnitsOfChangeInEuro(String unitsOfChangeInEuro) {
        this.unitsOfChangeInEuro = unitsOfChangeInEuro;
    }

    public int getTotalEuroCents() {
        return totalEuroCents;
    }

    public void setTotalEuroCents(int totalEuroCents) {
        this.totalEuroCents = totalEuroCents;
    }


    public void changeUSDToEuros(CurrencyUSD dollarsToChange){
        /** convert dollars to Euros with conversion factor of 1 USD = 0.8419 Euros and keeping the int precision of using whole units and cents of currency separately to avoid double or float imprecision */
        int totalAmountOfCentEuros = (dollarsToChange.getTotalUSCents()*8419)/10000;
        System.out.println(dollarsToChange.getTotalUSCents());
        System.out.println(totalAmountOfCentEuros);

        /**check if exact amount was reached, if not then go over by smallest amount (one cent Euro)*/
        if ((dollarsToChange.getTotalUSCents()*8419)%10000 != 0) ;
        {
            totalAmountOfCentEuros++;

            this.setTotalEuroCents(totalAmountOfCentEuros);
            System.out.println(getTotalEuroCents());


        }
    }

    public void computeUnitsOfChangeInEuro(int twentyBills, int tenBills, int fiveBills, int oneBills, int twentyFiveCent, int tenCent, int fiveCent, int oneCent){
        /**determine which bills and coins will be used to pay back */

        int noOfTwentyEuroBills = 0;
        int noOfTenEuroBills = 0;
        int noOfFiveEuroBills = 0;
        int noOfOneEuroBills = 0;
        int noOfFiftyCentCoins = 0;
        int noOfTwentyCentCoins = 0;
        int noOfTenCentCoins = 0;
        int noOfFiveCentCoins = 0;
        int noOfTOneCentCoins = 0;

        noOfTwentyEuroBills = determineUnits(twentyBills,2000);
        noOfTenEuroBills = determineUnits(tenBills,1000);
        noOfFiveEuroBills = determineUnits(fiveBills,500);
        noOfOneEuroBills = determineUnits(oneBills,100);
        noOfTenCentCoins = determineUnits(tenCent,10);
        noOfFiveCentCoins= determineUnits(fiveCent,5);
        noOfTOneCentCoins = determineUnits(oneCent,1);

        if (getTotalEuroCents() != 0){
            noOfTwentyEuroBills += determineUnits(noOfTwentyEuroBills+1,2000);
            noOfTenEuroBills += determineUnits(noOfTenEuroBills+1,1000);
            noOfFiveEuroBills += determineUnits(noOfFiveEuroBills +1,500);
            noOfOneEuroBills += determineUnits(noOfOneEuroBills+1,100);
            noOfFiftyCentCoins += determineUnits(noOfFiftyCentCoins+1,50);
            noOfTwentyCentCoins += determineUnits(noOfTwentyCentCoins+1,20);
            noOfTenCentCoins += determineUnits(noOfTenCentCoins+1,10);
            noOfFiveCentCoins += determineUnits(noOfFiveCentCoins+1,5);
            noOfTOneCentCoins += determineUnits(noOfTOneCentCoins+1,1);
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

    public int determineUnits(int noOfUnit, int valueInCents){
        int noOfEuroBills = 0;
        if (noOfUnit !=0 && getTotalEuroCents()/valueInCents > 0){
            if (noOfUnit >= getTotalEuroCents()/valueInCents){
                 noOfEuroBills = getTotalEuroCents()/valueInCents;
                setTotalEuroCents(getTotalEuroCents()%valueInCents);
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
}





/*//amount of euro bills to be returned
    private int twentyEuroBills;
    private int tenEuroBills;
    private int fiveEuroBills;
    private int oneEuroBill;
    private int fiftyCentEuroCoin;
    private int twentyCentEuroCoin;
    private int tenCentEuroCoin;
    private int fiveCentEuroCoin;
    private int oneCentEuroCoin;

    *//** setter and getter for twentyEuroBills *//*
    public int getTwentyEuroBills() {
        return twentyEuroBills;
    }

    public void setTwentyEuroBills(int twentyEuroBills) {
        this.twentyEuroBills = twentyEuroBills;
    }
    *//** setter and getter for tenEuroBills *//*
    public int getTenEuroBills() {
        return tenEuroBills;
    }

    public void setTenEuroBills(int tenEuroBills) {
        this.tenEuroBills = tenEuroBills;
    }
    *//** setter and getter for fiveEuroBills *//*
    public int getFiveEuroBills() {
        return fiveEuroBills;
    }

    public void setFiveEuroBills(int fiveEuroBills) {
        this.fiveEuroBills = fiveEuroBills;
    }
    *//** setter and getter for oneEuroBill *//*
    public int getOneEuroBill() {
        return oneEuroBill;
    }

    public void setOneEuroBill(int oneEuroBill) {
        this.oneEuroBill = oneEuroBill;
    }

    *//** setter and getter for fiftyCentEuroCoin *//*
    public int getFiftyCentEuroCoin() {
        return fiftyCentEuroCoin;
    }

    public void setFiftyCentEuroCoin(int fiftyCentEuroCoin) {
        this.fiftyCentEuroCoin = fiftyCentEuroCoin;
    }
    *//** setter and getter for twentyCentEuroCoin *//*
    public int getTwentyCentEuroCoin() {
        return twentyCentEuroCoin;
    }

    public void setTwentyCentEuroCoin(int twentyCentEuroCoin) {
        this.twentyCentEuroCoin = twentyCentEuroCoin;
    }
    *//** setter and getter for tenCentEuroCoin *//*
    public int getTenCentEuroCoin() {
        return tenCentEuroCoin;
    }

    public void setTenCentEuroCoin(int tenCentEuroCoin) {
        this.tenCentEuroCoin = tenCentEuroCoin;
    }

    *//** setter and getter for fiveCentEuroCoin *//*
    public int getFiveCentEuroCoin() {
        return fiveCentEuroCoin;
    }

    public void setFiveCentEuroCoin(int fiveCentEuroCoin) {
        this.fiveCentEuroCoin = fiveCentEuroCoin;
    }

    *//** setter and getter for oneCentEuroCoin*//*
    public int getOneCentEuroCoin() {
        return oneCentEuroCoin;
    }

    public void setOneCentEuroCoin(int oneCentEuroCoin) {
        this.oneCentEuroCoin = oneCentEuroCoin;
    }
*/
