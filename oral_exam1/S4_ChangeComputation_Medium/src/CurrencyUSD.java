import java.util.Currency;

public class CurrencyUSD {

    private int priceDollars;
    private int priceCents;

    public CurrencyUSD(){
        priceDollars = 0;
        priceCents = 0;
    }

    /**shallow copy constructor */
    public CurrencyUSD(CurrencyUSD copyCurrencyUSD){
        this.setPriceDollars(copyCurrencyUSD.getPriceDollars());
        this.setPriceCents(copyCurrencyUSD.getPriceCents());
    }

    public CurrencyUSD(String dollarAmount) {

        /** get the dollars and cents from the amount and store those values as integers*/
        String wholeNumber = dollarAmount.substring(0, dollarAmount.indexOf("."));
        priceDollars = Integer.parseInt(wholeNumber);

        String decimalNumber = dollarAmount.substring(dollarAmount.indexOf(".")+1);
        priceCents = Integer.parseInt(decimalNumber);

    }

    public int getPriceDollars() {
        return priceDollars;
    }

    public int getPriceCents() {
        return priceCents;
    }

    public void setPriceDollars(int priceDollars) {
        this.priceDollars = priceDollars;
    }

    public void setPriceCents(int priceCents) {
        this.priceCents = priceCents;
    }

    public CurrencyUSD substractUSCurrencyAmounts(CurrencyUSD substrahend){
        CurrencyUSD result = new CurrencyUSD();

        result.setPriceDollars(this.getPriceDollars() - substrahend.getPriceDollars());
        result.setPriceCents(this.getPriceCents() - substrahend.getPriceCents());

        return result;
    }
}

/*
    */
/**
     * amount of dollar bills given
     *//*

    private int twentyDollarBills;
    private int tenDollarBills;
    private int fiveDollarBils;
    private int oneDollarBills;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    */
/** setter and getter for twentyDollarBills *//*

    public int getTwentyDollarBills() {
        return twentyDollarBills;
    }

    public void setTwentyDollarBills(int twentyDollarBills) {
        this.twentyDollarBills = twentyDollarBills;
    }

    */
/** setter and getter for tenDollarBills *//*

    public int getTenDollarBills() {
        return tenDollarBills;
    }

    public void setTenDollarBills(int tenDollarBills) {
        this.tenDollarBills = tenDollarBills;
    }

    */
/** setter and getter for fiveDollarBills *//*

    public int getFiveDollarBils() {
        return fiveDollarBils;
    }

    public void setFiveDollarBils(int fiveDollarBils) {
        this.fiveDollarBils = fiveDollarBils;
    }
    */
/** setter and getter for oneDollarBills *//*

    public int getOneDollarBills() {
        return oneDollarBills;
    }

    public void setOneDollarBills(int oneDollarBills) {
        this.oneDollarBills = oneDollarBills;
    }

    */
/** setter and getter for quarters *//*

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    */
/** setter and getter for dimes *//*

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    */
/** setter and getter for nickels *//*

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    */
/** setter and getter for pennies *//*

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }*/
