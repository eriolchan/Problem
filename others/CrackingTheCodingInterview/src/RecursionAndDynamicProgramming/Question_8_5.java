package RecursionAndDynamicProgramming;

/**
 * Question 8.5
 * Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator). You can use addition, subtraction, and bit shifting,
 * but you should minimize the number of those operations.
 */
public class Question_8_5 {

    // O(log n)
    public static int minProduct(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException();
        }
        
        int small = a < b ? a : b;
        int big = a > b ? a : b;
        
        return minProductRecursively(small, big);
    }
    
    private static int minProductRecursively(int small, int big) {
        if (small == 0) {
            return 0;
        }
        
        if (small == 1) {
            return big;
        }
        
        int halfProduct = minProductRecursively(small >> 1, big);
        if ((small & 1) > 0) {
            return halfProduct + halfProduct + big;
        } else {
            return halfProduct + halfProduct;
        }
    }
}
