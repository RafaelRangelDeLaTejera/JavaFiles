import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    private CashRegister cashRegister = new CashRegister();

    @Test
    void testOneCashRegister() {
        assertEquals("Please return to costumer, 1 Fifty Euro Cents", cashRegister.computeChange("14.41",0,1,1,0,0,0,0,0));
        assertEquals("Please return to costumer, 2 twenty Euro Bills, 571 one Euro Cents",cashRegister.computeChange("46.85",4,1,0,0,0,0,0,20));
    }
}