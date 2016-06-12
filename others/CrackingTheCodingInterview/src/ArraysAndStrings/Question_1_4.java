package ArraysAndStrings;

import java.util.Arrays;

/**
 * Question 1.4
 * Write a method to decide if two strings are anagrams or not.
 */
public class Question_1_4 {
    
    /**
     * Complexity: O(n)
     */
    public static boolean isAnagramByCount(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2 || len1 == 0) {
            return false;
        }
        
        int[] counter = new int[256];
        for (int i = 0; i < counter.length; ++i) {
            counter[i] = 0;
        }
        
        for (int i = 0; i < len1; ++i) {
            int index = (int)s1.charAt(i);
            ++counter[index];
            
            index = (int)s2.charAt(i);
            --counter[index];
        }
        
        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Complexity: O(nlogn)
     */
    public static boolean isAnagramBySort(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2 || len1 == 0) {
            return false;
        }
        
        return sort(s1).equals(sort(s2));
    }
    
    private static String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        
        return new String(charArray);
    }
}
