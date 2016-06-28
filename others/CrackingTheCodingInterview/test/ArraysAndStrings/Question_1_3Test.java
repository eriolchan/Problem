package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_3Test {

    @Test
    public void testReplaceSpace_NoSpace() {
        String content = "abc";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { 'a', 'b', 'c' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtStart() {
        String content = " abc";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { '%', '2', '0', 'a', 'b', 'c' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtMiddle() {
        String content = "a bc";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { 'a', '%', '2', '0', 'b', 'c' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_SpaceAtEnd() {
        String content = "abc ";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { 'a', 'b', 'c', '%', '2', '0' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_MultipleSpace() {
        String content = "a b c";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { 'a', '%', '2', '0', 'b', '%', '2', '0', 'c' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_ConsecutiveSpace() {
        String content = "a  bc";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { 'a', '%', '2', '0', '%', '2', '0', 'b', 'c' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_OnlySpace() {
        String content = "   ";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { '%', '2', '0', '%', '2', '0', '%', '2', '0' };
        Question_1_3.replaceSpace(s,content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_OneSpace() {
        String content = " ";
        char[] s = Helper.createCharArray(10, content);
        
        char[] expected = new char[] { '%', '2', '0' };
        Question_1_3.replaceSpace(s, content.length());
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_Empty() {
        char[] s = new char[10];
        
        char[] expected = new char[0];
        Question_1_3.replaceSpace(s, 0);
        char[] actual = HelperTest.getValidString(s);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testReplaceSpace_Null() {
        char[] s = null;
        
        Question_1_3.replaceSpace(s, 0);
        assertNull(s);
    }
}
