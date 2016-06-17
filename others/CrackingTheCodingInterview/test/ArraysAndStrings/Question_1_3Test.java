package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_3Test {

    @Test
    public void testRemoveDuplicate_NoDuplicate() {
        char[] s = new char[] { 'a', 'b', 'c' };
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        Question_1_3.removeDuplicateByMap(s);
        assertArrayEquals(expected, s);
        
        s = new char[] { 'a', 'b', 'c' };
        Question_1_3.removeDuplicateInPlace(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleDuplicate() {
        char[] s = new char[] { 'a', 'b', 'a', 'b' };
        
        char[] expected = new char[] { 'a', 'b' };
        Question_1_3.removeDuplicateByMap(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'b', 'a', 'b' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleContinuousDuplicate() {
        char[] s = new char[] { 'a', 'a', 'b', 'b' };
        
        char[] expected = new char[] { 'a', 'b' };
        Question_1_3.removeDuplicateByMap(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'a', 'b', 'b' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_OneElement() {
        char[] s = new char[] { 'a' };
        
        char[] expected = new char[] { 'a' };
        Question_1_3.removeDuplicateByMap(s);
        assertArrayEquals(expected, s);
        
        s = new char[] { 'a' };
        Question_1_3.removeDuplicateInPlace(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testRemoveDuplicate_SameElement() {
        char[] s = new char[] { 'a', 'a', 'a' };
        
        char[] expected = new char[] { 'a' };
        Question_1_3.removeDuplicateByMap(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'a', 'a' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_Empty() {
        char[] s = new char[0];
        
        char[] expected = new char[0];
        Question_1_3.removeDuplicateByMap(s);
        assertArrayEquals(expected, s);
        
        s = new char[0];
        Question_1_3.removeDuplicateInPlace(s);
        assertArrayEquals(expected, s);
    }
    
    @Test
    public void testRemoveDuplicate_Null() {
        char[] s = null;
        
        Question_1_3.removeDuplicateByMap(s);
        assertNull(s);
        
        Question_1_3.removeDuplicateInPlace(s);
        assertNull(s);
    }
}
