package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Question 8.8
 * Write a method to compute all permutations of a string whose characters
 * are not necessarily unique. The list of permutations should not have duplicates.
 */
public class Question_8_8 {

    public static ArrayList<String> getPermutations(String s) {
        if (s == null) {
            return null;
        }
        
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> wordCount = buildHashMap(s);
        getPermutationsRecursively(wordCount, "", s.length(), result);
        
        return result;
    }
    
    private static void getPermutationsRecursively(HashMap<Character, Integer> wordCount, String prefix,
                                                   int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        
        for (Character c : wordCount.keySet()) {
            int count = wordCount.get(c);
            if (count > 0) {
                wordCount.put(c, count - 1);
                getPermutationsRecursively(wordCount, prefix + c, remaining - 1, result);
                wordCount.put(c, count);
            }
        }
    }
    
    private static HashMap<Character, Integer> buildHashMap(String s) {
        HashMap<Character, Integer> wordCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int count = wordCount.containsKey(c) ? wordCount.get(c) : 0;
            wordCount.put(c, count + 1);
        }
        
        return wordCount;
    }
}
