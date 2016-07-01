package ArraysAndStrings;

/**
 * Question 1.5
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit
 * (or zero edit) away.
 */
public class Question_1_5 {

    // O(n)
    public static boolean oneEditAway(String s1, String s2) {
        if (s1 == null || s1 == null) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        
        String shorter = len1 < len2 ? s1 : s2;
        String longer = len1 < len2 ? s2 : s1;
        
        return checkOneEditAway(shorter, longer);
    }
    
    private static boolean checkOneEditAway(String shorter, String longer) {
        boolean foundDifference = false;
        int i = 0;
        int j = 0;
        int len1 = shorter.length();
        int len2 = longer.length();
        
        while (i < len1 && j < len2) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                
                foundDifference = true;
                if (len1 == len2) {
                    ++i;
                }
            } else {
                ++i;
            }
            
            ++j;
        }
        
        return true;
    }
}
