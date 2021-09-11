import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterUSDToEuroTest {

    CashRegisterUSDToEuro cashRegister = new CashRegisterUSDToEuro();

    @Test
    void sumTotalDollarsAndCentsPaid() {
        assertEquals(1500,cashRegister.sumTotalDollarsAndCentsPaid(0,1,1,0,0,0,0,0));
    }

    @Test
    void totalPriceInCents() {
        assertEquals(1441,cashRegister.totalPriceInCents("14.41"));
    }

    @Test
    void changeFromUSToEuroCurrency() {
        assertEquals(50,cashRegister.changeFromUSToEuroCurrency(59));
        assertEquals(0,cashRegister.changeFromUSToEuroCurrency(0));
        assertEquals(1012,cashRegister.changeFromUSToEuroCurrency(1201));
        assertEquals(1498,cashRegister.changeFromUSToEuroCurrency(1779));
    }

    @Test
    void printAmount() {
    }

    @Test
    void displayUnitsOfChangeInEuroCurrency() {
        assertEquals("Return to costumer, 1 Fifty Euro Cent coins",cashRegister.displayUnitsOfChangeInEuroCurrency(50,0,1,1,0,0,0,0,0));

    }

    /** Method to use in order to use the CashRegisterUSDToEuro.java class, first input the item price as a string using a decimal point and then number of bills or coins the costumer paid with,
     *  just the number, input it into the method after the price in the order twenty dollars, ten dollars, five dollars, one dollar, quarter, dime, nickel and pennie.
      */
    @Test
    void computeChange() {
        cashRegister.computeChange("14.41",0,1,1,0,0,0,0,0);
        assertEquals("Change amount: 0.50 euros\nReturn to costumer, 1 Fifty Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("46.85",4,1,0,0,0,0,0,20);
        assertEquals("Change amount: 36.50 euros\nReturn to costumer, 1 Twenty Euro Bills, 1 Ten Euro Bills, 1 Five Euro Bills, 1 One Euro Bills, 1 Fifty Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("1264.14",8,40,100,2,0,4,100,20001);
        assertEquals("Change amount: 2.76 euros\nReturn to costumer, 2 One Euro Bills, 1 Fifty Euro Cent coins, 1 Twenty Euro Cent coins, 1 Five Euro Cent coins, 1 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("11",0,0,0,10,0,0,50,0);
        assertEquals("Change amount: 1.27 euros\nReturn to costumer, 1 One Euro Bills, 1 Twenty Euro Cent coins, 1 Five Euro Cent coins, 2 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("123.02",5,0,0,20,4,0,50,0);
        assertEquals("Change amount: 0.41 euros\nReturn to costumer, 2 Twenty Euro Cent coins, 1 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("51.0",0,8,0,0,0,1,0,1);
        assertEquals("Change amount: 24.51 euros\nReturn to costumer, 2 Ten Euro Bills, 4 One Euro Bills, 1 Fifty Euro Cent coins, 1 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("72.41",1,2,2,20,21,1,1,6);
        assertEquals("Change amount: 2.57 euros\nReturn to costumer, 2 One Euro Bills, 1 Fifty Euro Cent coins, 1 Five Euro Cent coins, 2 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("111.23",0,0,22,0,5,0,0,6);
        assertEquals("Change amount: 0.07 euros\nReturn to costumer, 1 Five Euro Cent coins, 2 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("41.29",0,10,4,0,0,0,0,0);
        assertEquals("Change amount: 66.27 euros\nReturn to costumer, 6 Ten Euro Bills, 1 Five Euro Bills, 1 One Euro Bills, 1 Twenty Euro Cent coins, 1 Five Euro Cent coins, 2 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("1",1,0,0,0,0,0,0,0);
        assertEquals("Change amount: 16.00 euros\nReturn to costumer, 1 Ten Euro Bills, 1 Five Euro Bills, 1 One Euro Bills\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("20",0,1,2,0,0,0,0,0);
        assertEquals("Change amount: 0.00 euros\nNo bills or coins to return\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("4.12",1,0,0,0,0,0,0,0);
        assertEquals("Change amount: 13.37 euros\nReturn to costumer, 1 Ten Euro Bills, 3 One Euro Bills, 1 Twenty Euro Cent coins, 1 Ten Euro Cent coins, 1 Five Euro Cent coins, 2 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("21.99",0,3,0,0,0,0,1,0);
        assertEquals("Change amount: 6.79 euros\nReturn to costumer, 1 Five Euro Bills, 1 One Euro Bills, 1 Fifty Euro Cent coins, 1 Twenty Euro Cent coins, 1 Five Euro Cent coins, 4 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("429.81",0,0,80,30,0,0,0,0);
        assertEquals("Change amount: 0.16 euros\nReturn to costumer, 1 Ten Euro Cent coins, 1 Five Euro Cent coins, 1 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("500.02",0,0,110,0,0,0,0,0);
        assertEquals("Change amount: 42.08 euros\nReturn to costumer, 8 Five Euro Bills, 2 One Euro Bills, 1 Five Euro Cent coins, 3 One Euro Cent coins\n",cashRegister.getDisplayChangeInEuroUnits());

        cashRegister.computeChange("0",0,0,0,0,0,0,0,0);
        assertEquals("Change amount: 0.00 euros\nNo bills or coins to return\n",cashRegister.getDisplayChangeInEuroUnits());

    }
}