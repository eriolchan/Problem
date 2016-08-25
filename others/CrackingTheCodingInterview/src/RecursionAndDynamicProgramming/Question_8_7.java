package RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Question 8.7
 * Write a method to compute all permutations of a string of unique characters.
 */
public class Question_8_7 {

    public static ArrayList<String> getPermutationsRecursively(String s) {
        if (s == null) {
            return null;
        }
        
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        
        char first = s.charAt(0);
        ArrayList<String> words = getPermutationsRecursively(s.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); ++i) {
                result.add(insertCharAt(word, first, i));
            }
        }
        
        return result;
    }
    
    public static ArrayList<String> getPermutationsByRolling(String s) {
        if (s == null) {
            return null;
        }
        
        return getPermutationsCore("", s);
    }
    
    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        
        return start + c + end;
    }
    
    private static ArrayList<String> getPermutationsCore(String prefix, String remainder) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (remainder.length() == 0) {
            result.add(prefix);
        }
    }
}
