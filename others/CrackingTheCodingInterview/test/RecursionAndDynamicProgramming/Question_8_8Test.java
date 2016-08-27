package RecursionAndDynamicProgramming;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Question_8_8Test {

    @Test
    public void testGetPermutations_NoDuplicate() {
        String s = "abc";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("abc");
        expected.add("acb");
        expected.add("bac");
        expected.add("bca");
        expected.add("cab");
        expected.add("cba");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Even() {
        String s = "abac";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("aabc");
        expected.add("aacb");
        expected.add("abac");
        expected.add("abca");
        expected.add("acab");
        expected.add("acba");
        expected.add("baac");
        expected.add("baca");
        expected.add("bcaa");
        expected.add("caab");
        expected.add("caba");
        expected.add("cbaa");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Odd() {
        String s = "aab";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("aab");
        expected.add("aba");
        expected.add("baa");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Same() {
        String s = "aaaaa";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("aaaaa");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_One() {
        String s = "a";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Empty() {
        String s = "";
        
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("");
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetPermutations_Null() {
        String s = null;
        
        ArrayList<String> actual = Question_8_8.getPermutations(s);
        assertNull(actual);
    }
}
