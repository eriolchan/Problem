package ArraysAndStrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class HelperTest {

    @Test
    public void testCreateCharArray() {
        String content = "abc";
        int capacity = 10;
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        char[] actual = Helper.createCharArray(capacity, content);
        assertEquals(capacity, actual.length);
        assertEquals('\0', actual[3]);
        assertArrayEquals(expected, getValidString(actual));
    }
    
    public static void assertMatrixEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < actual.length; ++i) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
    
    public static char[] getValidString(char[] s) {
        int i = 0;
        while (s[i] != '\0' && i < s.length) {
            ++i;
        }
        
        return Arrays.copyOf(s, i);
    }
}
