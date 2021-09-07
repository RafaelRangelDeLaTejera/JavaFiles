import java.util.Currency;

public class CurrencyUSD {

    private int totalUSCents;

    public CurrencyUSD(){
        totalUSCents = 0;
    }

    /**shallow copy constructor */
    public CurrencyUSD(CurrencyUSD copyCurrencyUSD){
        this.setTotalUSCents(copyCurrencyUSD.getTotalUSCents());
    }

    public CurrencyUSD(String dollarAmount) {

        if (dollarAmount.contains(".")){
            String wholeNumber = dollarAmount.substring(0, dollarAmount.indexOf("."));
            String decimalNumber = dollarAmount.substring(dollarAmount.indexOf(".")+1);
            totalUSCents = Integer.parseInt(wholeNumber)*100+Integer.parseInt(decimalNumber);
        }
        else
        {
            totalUSCents = Integer.parseInt(dollarAmount)*100;
        }

        /** get the dollars and cents from the amount and store those values as integers*/


    }

    public int getTotalUSCents() {
        return totalUSCents;
    }

    public void setTotalUSCents(int totalUSCents) {
        this.totalUSCents = totalUSCents;
    }

    public CurrencyUSD substractUSCurrencyAmounts(CurrencyUSD substrahend){
        CurrencyUSD result = new CurrencyUSD();

        result.setTotalUSCents(this.getTotalUSCents() - substrahend.getTotalUSCents());

        return result;
    }

    public void printUSD(){

        int dollars = getTotalUSCents()/100;
        int cents = getTotalUSCents()%100;

        if (cents == 0){
            System.out.println(dollars +"."+cents);
        }
        else
        {
            System.out.println(dollars +"."+cents);
        }
    }

}