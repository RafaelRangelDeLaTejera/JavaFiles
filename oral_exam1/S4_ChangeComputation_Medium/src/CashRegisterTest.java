import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    private CashRegister cashRegister = new CashRegister();

    @Test
    void testOneCashRegister() {
        assertEquals("Please return to costumer, 1 Fifty Euro Cents", cashRegister.computeChange("14.41",0,1,1,0,0,0,0,0));
        assertEquals("Please return to costumer, 1 twenty Euro Bills, 1 Ten Euro Bills, 1 Five Euro Bills, 1 One Euro Bills, 1 twenty Euro Cents, 1 ten Euro Cents, 20 One Euro Cents",cashRegister.computeChange("46.85",4,1,0,0,0,0,0,20));
    }
}