import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CALCULADORATest {
    CALCULADORA calculadora = new CALCULADORA();

    @Test
    void sumar() {
        int result = calculadora.sumar(5, 5);
        assertEquals(10, result);
        assertTrue(result==10);
    }

    @Test
    void resta() {
        double result = calculadora.resta(5, 5);
        assertEquals(1.0, result);
        assertTrue(result==0.0);
    }
}