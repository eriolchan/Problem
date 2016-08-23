package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_8_3Test {

    @Test
    public void testFindMagic_Exist() {
        int[] array = new int[] { -40, -20, -1, 1, 2, 5, 7, 8, 9, 12, 13 };
        
        int expected = 5;
        int actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
        
        array = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
        expected = 7;
        actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
        
        array = new int[] { 0, 2, 4, 6, 8, 10, 15, 17, 29, 30, 43 };
        expected = 0;
        actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMagic_HasDuplicateValue() {
        int[] array = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
        
        int expected = 2;
        int actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
        
        array = new int[] { -40, -20, -1, 1, 2, 7, 7, 7, 9, 12, 13 };
        expected = 7;
        actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMagic_NotExist() {
        int[] array = new int[] { -10, -5, 0, 2, 5, 7, 9, 15, 20, 22, 33 };
        
        int expected = -1;
        int actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
        
        array = new int[] { -10, -5, 0, 2, 2, 7, 9, 15, 20, 22, 33 };
        expected = -1;
        actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMagic_Empty() {
        int[] array = new int[0];
        
        int expected = -1;
        int actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMagic_Null() {
        int[] array = null;
        
        int expected = -1;
        int actual = Question_8_3.findMagic(array);
        assertEquals(expected, actual);
    }
}
