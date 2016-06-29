package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_6Test {

    @Test
    public void testCompress() {
        String s = "abbcccdddd";
        
        assertEquals("ab2c3d4", Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_Duplicate() {
        String s = "aabbbaaaaccccc";
        
        assertEquals("a2b3a4c5", Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_CountIsMoreThan10() {
        String s = "aaabbbbbbbbbbbbc";
        
        assertEquals("a3b12c", Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_NoCompress() {
        String s = "abcde";
        
        assertEquals(s, Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_Same() {
        String s = "aaaaa";
        
        assertEquals("a5", Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_OneChar() {
        String s = "a";
        
        assertEquals(s, Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_Empty() {
        String s = "";
        
        assertEquals(s, Question_1_6.compress(s));
    }
    
    @Test
    public void testCompress_Null() {
        String s = null;
        
        assertNull(Question_1_6.compress(s));
    }
}
