package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_2Test {

    @Test
    public void testReverse_LengthIsOdd() {
        char[] s = new char[] { 'a', 'b', 'c', '\0' };
        
        char[] expected = new char[] { 'c', 'b', 'a', '\0' };
        Question_1_2.reverse(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testReverse_LengthIsEven() {
        char[] s = new char[] { 'a', 'b', 'c', 'd', '\0' };
        
        char[] expected = new char[] { 'd', 'c', 'b', 'a', '\0' };
        Question_1_2.reverse(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testReverse_OneElement() {
        char[] s = new char[] { 'a', '\0' };
        
        char[] expected = new char[] { 'a', '\0' };
        Question_1_2.reverse(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testReverse_SameElement() {
        char[] s = new char[] { 'a', 'a', '\0' };
        
        char[] expected = new char[] { 'a', 'a', '\0' };
        Question_1_2.reverse(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testReverse_Empty() {
        char[] s = new char[] { '\0' };
        
        char[] expected = new char[] { '\0' };
        Question_1_2.reverse(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testReverse_Null() {
        char[] s = null;
        
        Question_1_2.reverse(s);
        assertNull(s);
    }
}
