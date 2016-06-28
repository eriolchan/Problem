package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_9Test {

    @Test
    public void testIsRotation_Left() {
        String s1 = "abcd";
        String s2 = "bcda";
        
        assertTrue(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_Right() {
        String s1 = "abcd";
        String s2 = "dabc";
        
        assertTrue(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_Same() {
        String s1 = "abcd";
        String s2 = "abcd";
        
        assertTrue(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_False() {
        String s1 = "abcd";
        String s2 = "acbd";
        
        assertFalse(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_DifferentElement() {
        String s1 = "abcd";
        String s2 = "bcea";
        
        assertFalse(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_DifferentLength() {
        String s1 = "abcd";
        String s2 = "bcd";
        
        assertFalse(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_Empty() {
        String s1 = "";
        String s2 = "bcd";
        
        assertFalse(Question_1_9.isRotation(s1, s2));
    }
    
    @Test
    public void testIsRotation_Null() {
        String s1 = "abc";
        String s2 = null;
        
        assertFalse(Question_1_9.isRotation(s1, s2));
    }
}
