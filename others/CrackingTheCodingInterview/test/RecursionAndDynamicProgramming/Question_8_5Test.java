package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_8_5Test {

    @Test
    public void testMinProduct_SmallIsOdd() {
        int a = 13;
        int b = 15;
        
        int expected = 13 * 15;
        int actual = Question_8_5.minProduct(a, b);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMinProduct_SmallIsEven() {
        int a = 13;
        int b = 12;
        
        int expected = 13 * 12;
        int actual = Question_8_5.minProduct(a, b);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMinProduct_SmallIsOne() {
        int a = 13;
        int b = 1;
        
        int expected = 13;
        int actual = Question_8_5.minProduct(a, b);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMinProduct_Zero() {
        int a = 0;
        int b = 13;
        
        int expected = 0;
        int actual = Question_8_5.minProduct(a, b);
        assertEquals(expected, actual);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testMinProduct_Invalid() {
        int a = -3;
        int b = 13;
        
        Question_8_5.minProduct(a, b);
    }
}
