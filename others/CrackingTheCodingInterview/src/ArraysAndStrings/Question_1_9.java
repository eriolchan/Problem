package ArraysAndStrings;

/**
 * Question 1.9
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A parlindrome is a word or phrase that is the same forwards and backwards.
 */
public class Question_1_9 {
    
    // O(n)
    public static boolean isPermutationOfPalindromeByMap(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] state = new boolean[256];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int index = s.charAt(i);
            state[index] = !state[index];
        }
        
        int count = 0;
        for (int i = 0; i < state.length; ++i) {
            if (state[i]) {
                ++count;
            }
        }
        
        return count <= 1;
    }
    
    // Assume all chars are from a ~ z and case insensitive.
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
