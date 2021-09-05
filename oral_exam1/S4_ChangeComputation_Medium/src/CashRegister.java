import java.math.BigDecimal;

public class CashRegister {
    /** setter and getter for getCost private member */
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /** setter and getter for twentyDollarBills */
     public int getTwentyDollarBills() {
     return twentyDollarBills;
     }

     public void setTwentyDollarBills(int twentyDollarBills) {
     this.twentyDollarBills = twentyDollarBills;
     }

    /** setter and getter for tenDollarBills */
    public int getTenDollarBills() {
        return tenDollarBills;
    }

    public void setTenDollarBills(int tenDollarBills) {
        this.tenDollarBills = tenDollarBills;
    }

    /** setter and getter for fiveDollarBills */
    public int getFiveDollarBils() {
        return fiveDollarBils;
    }

    public void setFiveDollarBils(int fiveDollarBils) {
        this.fiveDollarBils = fiveDollarBils;
    }
    /** setter and getter for oneDollarBills */
    public int getOneDollarBills() {
        return oneDollarBills;
    }

    public void setOneDollarBills(int oneDollarBills) {
        this.oneDollarBills = oneDollarBills;
    }

    /** setter and getter for quarters */
    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /** setter and getter for dimes */
    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /** setter and getter for nickels */
    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /** setter and getter for pennies */
    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
    /** setter and getter for twentyEuroBills */
    public int getTwentyEuroBills() {
        return twentyEuroBills;
    }

    public void setTwentyEuroBills(int twentyEuroBills) {
        this.twentyEuroBills = twentyEuroBills;
    }
    /** setter and getter for tenEuroBills */
    public int getTenEuroBills() {
        return tenEuroBills;
    }

    public void setTenEuroBills(int tenEuroBills) {
        this.tenEuroBills = tenEuroBills;
    }
    /** setter and getter for fiveEuroBills */
    public int getFiveEuroBills() {
        return fiveEuroBills;
    }

    public void setFiveEuroBills(int fiveEuroBills) {
        this.fiveEuroBills = fiveEuroBills;
    }
    /** setter and getter for oneEuroBill */
    public int getOneEuroBill() {
        return oneEuroBill;
    }

    public void setOneEuroBill(int oneEuroBill) {
        this.oneEuroBill = oneEuroBill;
    }

    /** setter and getter for fiftyCentEuroCoin */
    public int getFiftyCentEuroCoin() {
        return fiftyCentEuroCoin;
    }

    public void setFiftyCentEuroCoin(int fiftyCentEuroCoin) {
        this.fiftyCentEuroCoin = fiftyCentEuroCoin;
    }
    /** setter and getter for twentyCentEuroCoin */
    public int getTwentyCentEuroCoin() {
        return twentyCentEuroCoin;
    }

    public void setTwentyCentEuroCoin(int twentyCentEuroCoin) {
        this.twentyCentEuroCoin = twentyCentEuroCoin;
    }
    /** setter and getter for tenCentEuroCoin */
    public int getTenCentEuroCoin() {
        return tenCentEuroCoin;
    }

    public void setTenCentEuroCoin(int tenCentEuroCoin) {
        this.tenCentEuroCoin = tenCentEuroCoin;
    }

    /** setter and getter for fiveCentEuroCoin */
    public int getFiveCentEuroCoin() {
        return fiveCentEuroCoin;
    }

    public void setFiveCentEuroCoin(int fiveCentEuroCoin) {
        this.fiveCentEuroCoin = fiveCentEuroCoin;
    }

    /** setter and getter for oneCentEuroCoin*/
    public int getOneCentEuroCoin() {
        return oneCentEuroCoin;
    }

    public void setOneCentEuroCoin(int oneCentEuroCoin) {
        this.oneCentEuroCoin = oneCentEuroCoin;
    }

    /**Initialize class members*/
    //hold input item price from user
    private BigDecimal cost;

    //amount of dollar bills given
    private int twentyDollarBills;
    private int tenDollarBills;
    private int fiveDollarBils;
    private int oneDollarBills;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    //amount of euro bills to be returned
    private int twentyEuroBills;
    private int tenEuroBills;
    private int fiveEuroBills;
    private int oneEuroBill;
    private int fiftyCentEuroCoin;
    private int twentyCentEuroCoin;
    private int tenCentEuroCoin;
    private int fiveCentEuroCoin;
    private int oneCentEuroCoin;

}
