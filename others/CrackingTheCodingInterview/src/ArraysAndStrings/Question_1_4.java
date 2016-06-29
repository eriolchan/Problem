package ArraysAndStrings;

/**
 * Question 1.4
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A parlindrome is a word or phrase that is the same forwards and backwards.
 */
public class Question_1_4 {
    
    // O(n)
    public static boolean isPermutationOfPalindromeByMap(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] toggle = new boolean[256];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int index = s.charAt(i);
            toggle[index] = !toggle[index];
        }
        
        int oddCount = 0;
        for (int i = 0; i < toggle.length; ++i) {
            if (toggle[i]) {
                ++oddCount;
            }
        }
        
        return oddCount <= 1;
    }
    
    // O(n)
    // Assume all chars are from a to z and case insensitive.
    public static boolean isPermutationOfPalindromeByBits(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int vector = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            int shift = c - 'a';
            int mask = 1 << shift;
            
            if ((vector & mask) == 0) {
                vector |= mask;
            } else {
                vector &= ~mask;
            }
        }
        
        return (vector & (vector - 1)) == 0;
    }
}
