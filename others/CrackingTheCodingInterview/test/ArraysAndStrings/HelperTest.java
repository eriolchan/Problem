package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {

    @Test
    public void testGetArrayLength() {
        char[] s = new char[] { 'a', 'b', 'c', '\0' };
        
        int actual = Helper.getArrayLength(s);
        assertEquals(3, actual);
    }

    @Test
    public void testGetArrayLength_ZeroLength() {
        char[] s = new char[] { '\0' };
        
        int actual = Helper.getArrayLength(s);
        assertEquals(0, actual);
   }
    
    @Test
    public void testGetArrayLength_Truncate() {
        char[] s = new char[] { 'a', 'b', '\0', 'c' };
        
        int actual = Helper.getArrayLength(s);
        assertEquals(2, actual);
    }
}
