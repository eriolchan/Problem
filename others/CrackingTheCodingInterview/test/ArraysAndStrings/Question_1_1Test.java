package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_1Test {
    
    @Test
    public void testIsUniqueChars_Unique() {
        String s = "abc";
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertTrue(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertTrue(actual);
    }
    
    @Test
    public void testIsUniqueChars_HasDepuplicate() {
        String s = "aba";
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertFalse(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertFalse(actual);
    }
    
    @Test
    public void testIsUniqueChars_OneChar() {
        String s = "a";
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertTrue(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertTrue(actual);
    }
    
    @Test
    public void testIsUniqueChars_SameChars() {
        String s = "aaa";
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertFalse(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertFalse(actual);
    }
    
    @Test
    public void testIsUniqueChars_Empty() {
        String s = "";
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertFalse(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertFalse(actual);
    }
    
    @Test
    public void testIsUniqueChars_Null() {
        String s = null;
        
        boolean actual = Question_1_1.isUniqueCharsByASCII(s);
        assertFalse(actual);
        
        actual = Question_1_1.isUniqueCharsByBits(s);
        assertFalse(actual);
    }
}
