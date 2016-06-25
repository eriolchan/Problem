package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_10Test {

    @Test
    public void testOneEditAway_Insert() {
        String s1 = "abc";
        String s2 = "dabc";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "abdc";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "abcd";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_Replace() {
        String s1 = "abc";
        String s2 = "dbc";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "adc";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "abd";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_Remove() {
        String s1 = "abc";
        String s2 = "bc";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "ac";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "ab";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_NoEdit() {
        String s1 = "abc";
        String s2 = "abc";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_SameChars() {
        String s1 = "aaa";
        String s2 = "aaaa";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_OneChar() {
        String s1 = "a";
        String s2 = "ab";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "b";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_MoreThanOneEdit() {
        String s1 = "abc";
        String s2 = "acbdc";
        
        assertFalse(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "a";
        assertFalse(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "axy";
        assertFalse(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "acbe";
        assertFalse(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_Empty() {
        String s1 = "";
        String s2 = "";
        
        assertTrue(Question_1_10.oneEditAway(s1, s2));
        
        s2 = "a";
        assertTrue(Question_1_10.oneEditAway(s1, s2));
    }
    
    @Test
    public void testOneEditAway_Null() {
        String s1 = null;
        String s2 = "abc";
        
        assertFalse(Question_1_10.oneEditAway(s1, s2));
    }
}
