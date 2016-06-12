package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_5Test {
    
    @Test
    public void testReplaceSpace_NoSpace() {
        char[] s = Helper.createCharArray(15, "abc");
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtStart() {
        char[] s = Helper.createCharArray(15, " abc");
        
        char[] expected = new char[] { '%', '2', '0', 'a', 'b', 'c' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtMiddle() {
        char[] s = Helper.createCharArray(15, "a bc");
        
        char[] expected = new char[] { 'a', '%', '2', '0', 'b', 'c' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtEnd() {
        char[] s = Helper.createCharArray(15, "abc ");
        
        char[] expected = new char[] { 'a', 'b', 'c', '%', '2', '0' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_MultipleSpace() {
        char[] s = Helper.createCharArray(15, "a b c");
        
        char[] expected = new char[] { 'a', '%', '2', '0', 'b', '%', '2', '0', 'c' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_ConsecutiveSpace() {
        char[] s = Helper.createCharArray(15, "a  bc");
        
        char[] expected = new char[] { 'a', '%', '2', '0', '%', '2', '0', 'b', 'c' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_OnlySpace() {
        char[] s = Helper.createCharArray(15, "   ");
        
        char[] expected = new char[] { '%', '2', '0', '%', '2', '0', '%', '2', '0' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_OneSpace() {
        char[] s = Helper.createCharArray(15, " ");
        
        char[] expected = new char[] { '%', '2', '0' };
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_Empty() {
        char[] s = new char[] { '\0' };
        
        char[] expected = new char[0];
        Question_1_5.replaceSpace(s);
        char[] actual = Helper.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_Null() {
        char[] s = null;
        
        Question_1_5.replaceSpace(s);
        assertNull(s);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testReplaceSpace_InsufficientLength() {
        char[] s = Helper.createCharArray(5, " a ");
        
        Question_1_5.replaceSpace(s);
    }
}
