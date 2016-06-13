package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {

    @Test
    public void testGetArrayLength() {
        char[] s = new char[] { 'a', 'b', 'c', '\0' };
        
        int actual = Helper.getStringLength(s);
        assertEquals(3, actual);
    }
    
    @Test
    public void testGetArrayLength_ZeroLength() {
        char[] s = new char[] { '\0' };
        
        int actual = Helper.getStringLength(s);
        assertEquals(0, actual);
   }
    
    @Test
    public void testGetArrayLength_Truncate() {
        char[] s = new char[] { 'a', 'b', '\0', 'c' };
        
        int actual = Helper.getStringLength(s);
        assertEquals(2, actual);
    }
    
    @Test
    public void testGetValidString() {
        char[] s = new char[] { 'a', 'b', 'c', '\0' };
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGetValidString_ZeroLength() {
        char[] s = new char[] { '\0' };
        
        char[] expected = new char[0];
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGetValidString_Truncate() {
        char[] s = new char[] { 'a', 'b', '\0', 'c' };
        
        char[] expected = new char[] { 'a', 'b' };
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testCreateCharArray() {
        String content = "abc";
        int capacity = 10;
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        char[] actual = Helper.createCharArray(capacity, content);
        assertEquals(capacity, actual.length);
        assertEquals('\0', actual[3]);
        assertArrayEquals(expected, Helper.getValidString(actual));
    }
    
    public static void assertMatrixEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < actual.length; ++i) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}
