import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    private PrimeNumbers primeNumbers;

    @BeforeEach
    void setUp() {
        primeNumbers = new PrimeNumbers();
    }

    @Test
    public void testComputePrimesCastedString() {
        assertThrows(NumberFormatException.class, () -> primeNumbers.computePrimes(Integer.parseInt("number")));
    }

    @Test
    public void testComputePrimesCastedObject() {
        assertThrows(ClassCastException.class, () -> primeNumbers.computePrimes((Integer) new Object()));
    }

    @Test
    public void testComputePrimesNull() {
        assertThrows(NullPointerException.class, () -> primeNumbers.computePrimes((Integer) null));
    }

    @Test
    public void testComputePrimesForPositiveNumbers() {
        primeNumbers.computePrimes(5);
        assertEquals("[2, 3, 5, 7, 11]", primeNumbers.toString(), "Expected first 5 primes");
    }

    @Test
    public void testComputePrimesForZero() {
        primeNumbers.computePrimes(0);
        assertEquals("[]", primeNumbers.toString(), "Expected an empty list for n=0");
    }

    @Test
    public void testComputePrimesForNegativeNumbers() {
        primeNumbers.computePrimes(-5);
        assertEquals("[]", primeNumbers.toString(), "Expected an empty list for negative n");
    }

    @Test
    public void testComputePrimesForSkippingPrimesEndingIn9() {
        primeNumbers.computePrimes(10);
        assertFalse(primeNumbers.toString().contains("9"), "Expected 9 to be skipped");
        assertFalse(primeNumbers.toString().contains("19"), "Expected 19 to be skipped");
    }

    @Test
    public void testIterator() {
        primeNumbers.computePrimes(5);
        Iterator<Integer> iterator = primeNumbers.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals((Integer) 2, iterator.next(), "Expected first prime to be 2");
        assertEquals((Integer) 3, iterator.next(), "Expected second prime to be 3");
        assertEquals((Integer) 5, iterator.next(), "Expected third prime to be 5");
        assertEquals((Integer) 7, iterator.next(), "Expected fourth prime to be 7");
        assertEquals((Integer) 11, iterator.next(), "Expected fifth prime to be 11");
        assertFalse(iterator.hasNext(), "Iterator should not have any more elements");
    }

    @Test
    public void testIteratorWithoutComputePrimes() {
        Iterator<Integer> iterator = primeNumbers.iterator();
        assertFalse(iterator.hasNext(), "Iterator should not have any elements if computePrimes not called");
        assertThrows(NoSuchElementException.class, () -> iterator.next(),
                "Iterator should throw exception when trying to get next element without computing primes");
    }

    @Test
    public void testConsecutiveComputePrimesCalls() {
        primeNumbers.computePrimes(5);
        primeNumbers.computePrimes(5);
        assertEquals(5, primeNumbers.toString().split(",").length,
                "List should contain only 5 primes despite consecutive calls");
    }

    @Test
    public void testPrimesAround19() {
        primeNumbers.computePrimes(10);
        System.out.println(primeNumbers.toString());
        assertTrue(primeNumbers.toString().contains("17"), "Expected 17 to be included");
        assertFalse(primeNumbers.toString().contains("19"), "Expected 19 to be skipped");
        assertTrue(primeNumbers.toString().contains("23"), "Expected 23 to be included");
    }

    @Test
    public void testComputePrimesForJustAboveZero() {
        primeNumbers.computePrimes(1);
        assertEquals("[2]", primeNumbers.toString(), "Expected list with only the first prime for n=1");
    }

    @Test
    public void testComputePrimesForJustBelowZero() {
        primeNumbers.computePrimes(-1);
        assertEquals("[]", primeNumbers.toString(), "Expected an empty list for n=-1");
    }

}