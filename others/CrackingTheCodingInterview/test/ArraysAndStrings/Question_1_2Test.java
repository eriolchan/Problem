package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_2Test {

    @Test
    public void testIsPermutation_UniqueChars() {
        String s1 = "abcd";
        String s2 = "acbd";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertTrue(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertTrue(actual);
    }
    
    @Test
    public void testIsPermutation_DuplicatedChar() {
        String s1 = "ababa";
        String s2 = "aaabb";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertTrue(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertTrue(actual);
    }
    
    @Test
    public void testIsPermutation_SameString() {
        String s1 = "abcd";
        String s2 = "abcd";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertTrue(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertTrue(actual);
    }
    
    @Test
    public void testIsPermutation_SameElement() {
        String s1 = "aaa";
        String s2 = "aaa";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertTrue(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertTrue(actual);
    }
    
    @Test
    public void testIsPermutation_OneChar() {
        String s1 = "a";
        String s2 = "a";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertTrue(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertTrue(actual);
    }
    
    @Test
    public void testIsPermutation_False() {
        String s1 = "abc";
        String s2 = "cda";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertFalse(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertFalse(actual);
    }
    
    @Test
    public void testIsPermutation_DifferentLength() {
        String s1 = "abc";
        String s2 = "ab";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertFalse(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertFalse(actual);
    }
    
    @Test
    public void testIsPermutation_Empty() {
        String s1 = "abc";
        String s2 = "";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertFalse(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertFalse(actual);
    }
    
    @Test
    public void testIsPermutation_Null() {
        String s1 = null;
        String s2 = "abc";
        
        boolean actual = Question_1_2.isPermutationByMap(s1, s2);
        assertFalse(actual);
        
        actual = Question_1_2.isPermutationBySort(s1, s2);
        assertFalse(actual);
    }
}
