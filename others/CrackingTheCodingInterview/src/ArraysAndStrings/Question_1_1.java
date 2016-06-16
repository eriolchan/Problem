package ArraysAndStrings;

/**
 * Question 1.1
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class Question_1_1 {

    // O(n)
    public static boolean isUniqueCharsByASCII(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] visited = new boolean[256];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int index = s.charAt(i);
            if (visited[index]) {
                return false;
            }
            
            visited[index] = true;
        }
        
        return true;
    }
    
    // O(n)
    public static boolean isUniqueCharsByBits(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        final int BITS = 32;
        
        int[] visited = new int[8];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int index = s.charAt(i);
            int block = index / BITS;
            int shift = index % BITS;
            
            if ((visited[block] & (1 << shift)) != 0) {
                return false;
            }
            
            visited[block] |= 1 << shift;
        }
        
        return true;
    }
}
