import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BoundedQueueTest {

    private BoundedQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new BoundedQueue(5); // for example, capacity is set to 5
    }

    @Test
    public void testConstructorNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedQueue(-1),
                "Constructor should throw exception for negative capacity");
    }

    @Test
    public void testEnQueueNullElement() {
        assertThrows(NullPointerException.class, () -> queue.enQueue(null),
                "EnQueue should throw exception for null element");
    }

    @Test
    public void testEnQueueFullQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        assertThrows(IllegalStateException.class, () -> queue.enQueue(6),
                "EnQueue should throw exception for full queue");
    }

    @Test
    public void testDeQueueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.deQueue(),
                "DeQueue should throw exception for empty queue");
    }

    @Test
    public void testDeQueue() {
        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(1, queue.deQueue(), "DeQueue should return the first element enQueued");
        assertEquals(2, queue.deQueue(), "DeQueue should return the next first element enQueued");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        queue.enQueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enQueue operation");
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull(), "Queue should not be full initially");
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        assertTrue(queue.isFull(), "Queue should be full after enQueueing capacity number of elements");
    }

    @Test
    public void testToString() {
        assertEquals("[]", queue.toString(), "Empty queue should return empty brackets");
        queue.enQueue(1);
        assertEquals("[1]", queue.toString(), "Queue with one element should return that element");
        queue.enQueue(2);
        assertEquals("[1, 2]", queue.toString(), "Queue with two elements should return those elements in order");
    }
}