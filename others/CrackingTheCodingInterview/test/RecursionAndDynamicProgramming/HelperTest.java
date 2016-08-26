package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class HelperTest {

    public static <T> void assertArrayEqualsIgnoreOrdinal(ArrayList<T> expected, ArrayList<T> actual) {
        assertEquals(expected.size(), actual.size());
        
        for (T value : expected) {
            assertTrue(actual.contains(value));
        }
    }
}
