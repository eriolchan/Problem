package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Question_8_8Test {

    @Test
    public void testGetPermutations_NoDuplicate() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_HasDuplicate() {
        String s = "aba";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("aab");
        expected.add("aba");
        expected.add("baa");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_ConsecutiveDuplicate() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_Odd() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_Even() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_Same() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_One() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_Empty() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPermutations_Null() {
        fail("Not yet implemented");
    }
}
