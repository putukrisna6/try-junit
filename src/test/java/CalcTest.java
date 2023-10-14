import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void addTwoPositiveIntegersTestCase() {
        assertEquals(8, Calc.add(3, 5));
    }

    @Test
    void addPositiveAndNegativeIntegersTestCase() {
        assertEquals(0, Calc.add(5, -5));
    }

    @Test
    void addTwoNegativeIntegersTestCase() {
        assertEquals(-8, Calc.add(-5, -3));
    }

    @Test
    void addMaxIntegerTestCase() {
        assertEquals(Integer.MAX_VALUE, Calc.add(0, Integer.MAX_VALUE));
    }

    @Test
    void addMinIntegerTestCase() {
        assertEquals(Integer.MIN_VALUE, Calc.add(Integer.MIN_VALUE, 0));
    }

    @Test
    void addIntegerWithParsedStringTestCase() {
        assertThrows(NumberFormatException.class, () -> Calc.add(1, Integer.parseInt("string")));
    }

    @Test
    void addIntegerWithCastedObjectTestCase() {
        assertThrows(ClassCastException.class, () -> Calc.add(1, (Integer) new Object()));
    }

    @Test
    void addOverflowTestCase() {
        assertEquals(Integer.MIN_VALUE, Calc.add(1, Integer.MAX_VALUE));
    }

    @Test
    void addUnderflowTestCase() {
        assertEquals(Integer.MAX_VALUE, Calc.add(Integer.MIN_VALUE, -1));
    }
}