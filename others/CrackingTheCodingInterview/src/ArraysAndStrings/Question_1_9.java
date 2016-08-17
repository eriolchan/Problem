package ArraysAndStrings;

/**
 * Question 1.9
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring.
 */
public class Question_1_9 {

    // O(m+n)
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        
        return isSubstring(s1 + s1, s2);
    }
    
    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
