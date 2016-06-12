package ArraysAndStrings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Question_1_3Test {

    @Test
    public void testRemoveDuplicate_NoDuplicate() {
        char[] s = new char[] { 'a', 'b', 'c', '\0' };
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        Question_1_3.removeDuplicateByASCII(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'b', 'c', '\0' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleDuplicate() {
        char[] s = new char[] { 'a', 'b', 'a', 'b', '\0' };
        
        char[] expected = new char[] { 'a', 'b' };
        Question_1_3.removeDuplicateByASCII(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'b', 'a', 'b', '\0' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_OneElement() {
        char[] s = new char[] { 'a', '\0' };
        
        char[] expected = new char[] { 'a' };
        Question_1_3.removeDuplicateByASCII(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', '\0' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_SameElement() {
        char[] s = new char[] { 'a', 'a', 'a', '\0' };
        
        char[] expected = new char[] { 'a' };
        Question_1_3.removeDuplicateByASCII(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { 'a', 'a', 'a', '\0' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_Empty() {
        char[] s = new char[] { '\0' };
        
        char[] expected = new char[0];
        Question_1_3.removeDuplicateByASCII(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
        
        s = new char[] { '\0' };
        Question_1_3.removeDuplicateInPlace(s);
        actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testRemoveDuplicate_Null() {
        char[] s = null;
        
        Question_1_3.removeDuplicateByASCII(s);
        assertNull(s);
        
        Question_1_3.removeDuplicateInPlace(s);
        assertNull(s);
    }
}
