import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class MinTest {
    private List<String> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<String>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void minNullListTestCase() {
        list = null;
        assertThrows(NullPointerException.class, () -> Min.min((list)));
    }

    @Test
    void minNullElementTestCase()
    {
        list.add (null);
        list.add ("cat");
        assertThrows(NullPointerException.class, () -> Min.min (list));
    }

    @Test
    void minSingleNullElementTestCase()
    {
        list.add (null);
        assertThrows(NullPointerException.class, () -> Min.min (list));
    }

    @Test
    @SuppressWarnings ("unchecked")
    void minMutuallyIncomparableTestCase()
    {
        List arrayList = new ArrayList<>();
        arrayList.add("cat");
        arrayList.add("dog");
        arrayList.add(1);
        assertThrows(ClassCastException.class, () -> Min.min (arrayList));
    }

    @Test
    void minEmptyListTestCase()
    {
        assertThrows(IllegalArgumentException.class, () -> Min.min (list));
    }

    @Test
    void minSingleElementTestCase()
    {
        list.add ("cat");
        Object obj = Min.min(list);
        assertEquals("cat", obj, "Single Element List");
    }

    @Test
    void minDoubleElementTestCase()
    {
        list.add ("dog");
        list.add ("cat");
        Object obj = Min.min (list);
        assertEquals("cat", obj, "Double Element List");
    }
}