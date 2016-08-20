package RecursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * Question 8.1
 * A child is running up a staircase with n steps and can hop
 * either 1 step, 2 steps, or 3 steps at a time. Implement a method
 * to count how many possible ways the child can run up the stairs.
 */
public class Question_8_1 {

    // O(n)
    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        
        return countWaysRecursively(n, memo);
    }
    
    private static int countWaysRecursively(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        
        if (n == 0) {
            return 1;
        }
        
        if (memo[n] > -1) {
            return memo[n];
        }
        
        memo[n] = countWaysRecursively(n - 1, memo) + countWaysRecursively(n - 2, memo) +
                  countWaysRecursively(n - 3, memo);
        
        return memo[n];
    }
}
