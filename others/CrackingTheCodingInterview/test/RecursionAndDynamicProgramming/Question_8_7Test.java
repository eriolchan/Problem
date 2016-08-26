package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Question_8_7Test {

    @Test
    public void testGetPermutations_Odd() {
        String s = "abc";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("abc");
        expected.add("bac");
        expected.add("bca");
        expected.add("acb");
        expected.add("cab");
        expected.add("cba");
        ArrayList<String> actual = Question_8_7.getPermutationsRecursively(s);
        assertEquals(expected, actual);
        
        actual = Question_8_7.getPermutationsByRolling(s);
        HelperTest.assertArrayEqualsIgnoreOrdinal(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Even() {
        String s = "abcd";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("abcd");
        expected.add("bacd");
        expected.add("bcad");
        expected.add("bcda");
        expected.add("acbd");
        expected.add("cabd");
        expected.add("cbad");
        expected.add("cbda");
        expected.add("acdb");
        expected.add("cadb");
        expected.add("cdab");
        expected.add("cdba");
        expected.add("abdc");
        expected.add("badc");
        expected.add("bdac");
        expected.add("bdca");
        expected.add("adbc");
        expected.add("dabc");
        expected.add("dbac");
        expected.add("dbca");
        expected.add("adcb");
        expected.add("dacb");
        expected.add("dcab");
        expected.add("dcba");
        ArrayList<String> actual = Question_8_7.getPermutationsRecursively(s);
        assertEquals(expected, actual);
        
        actual = Question_8_7.getPermutationsByRolling(s);
        HelperTest.assertArrayEqualsIgnoreOrdinal(expected, actual);
    }
    
    @Test
    public void testGetPermutations_One() {
        String s = "a";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(s);
        ArrayList<String> actual = Question_8_7.getPermutationsRecursively(s);
        assertEquals(expected, actual);
        
        actual = Question_8_7.getPermutationsByRolling(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Empty() {
        String s = "";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(s);
        ArrayList<String> actual = Question_8_7.getPermutationsRecursively(s);
        assertEquals(expected, actual);
        
        actual = Question_8_7.getPermutationsByRolling(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Null() {
        String s = null;
        
        ArrayList<String> actual = Question_8_7.getPermutationsRecursively(s);
        assertNull(actual);
        
        actual = Question_8_7.getPermutationsByRolling(s);
        assertNull(actual);
    }
}
