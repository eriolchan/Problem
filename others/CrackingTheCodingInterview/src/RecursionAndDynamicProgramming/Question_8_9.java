package RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Question 8.9
 * Implement an algorithm to print all valid (i.e., properly opened and closed)
 * combinations of n pairs of parentheses.
 */
public class Question_8_9 {

    public static ArrayList<String> generateParens(int n) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (n <= 0) {
            result.add("");
            return result;
        }
        
        char[] str = new char[2 * n];
        addParen(result, str, n, n, 0);
        
        return result;
    }
    
    private static void addParen(ArrayList<String> result, char[] str, int leftRemaining, int rightRemaining, int index) {
        if (leftRemaining < 0 || rightRemaining < leftRemaining) {
            return;
        }
        
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(String.copyValueOf(str));
            return;
        }
        
        str[index] = '(';
        addParen(result, str, leftRemaining - 1, rightRemaining, index + 1);
        
        str[index] = ')';
        addParen(result, str, leftRemaining, rightRemaining - 1, index + 1);
    }
}
