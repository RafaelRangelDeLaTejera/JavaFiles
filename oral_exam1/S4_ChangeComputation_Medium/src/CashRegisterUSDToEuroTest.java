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
    }

    @Test
    void printAmount() {
    }

    @Test
    void displayUnitsOfChangeInEuroCurrency() {

    }

    @Test
    void determineUnits() {
    }

    @Test
    void checkUnits() {
    }

    @Test
    void computeChange() {
        assertEquals("Give back to costumer, 1 fifty Euro cent coin",cashRegister.computeChange("14.41",);)
    }
}