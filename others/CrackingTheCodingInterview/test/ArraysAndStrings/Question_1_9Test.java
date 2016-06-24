package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_9Test {

    @Test
    public void testIsPermutationOfPalindrome_LengthIsOdd() {
        String s = "ababc";
        
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_LengthIsEven() {
        String s = "abab";
        
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_SameChars() {
        String s = "aaaa";
        
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
        
        s = "aaaaa";
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_OneElement() {
        String s = "a";
        
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_MoreThanOneOdd() {
        String s = "abcdab";
        
        assertFalse(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertFalse(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_NoSameChar() {
        String s = "abcde";
        
        assertFalse(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertFalse(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_ExactPalindrome() {
        String s = "abccba";
        
        assertTrue(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertTrue(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_Empty() {
        String s = "";
        
        assertFalse(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertFalse(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
    
    @Test
    public void testIsPermutationOfPalindrome_Null() {
        String s = null;
        
        assertFalse(Question_1_9.isPermutationOfPalindromeByMap(s));
        assertFalse(Question_1_9.isPermutationOfPalindromeByBits(s));
    }
}
