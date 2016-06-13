package ArraysAndStrings;

/**
 * Question 1.7
 * Write an algorithm such that if an element in an M*N matrix is 0,
 * its entire row and column is set to 0.
 */
public class Question_1_7 {

    // O(n^2)
    public static void SetZero(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        
        int m = matrix.length;
        if (m == 0 || matrix[0] == null) {
            return;
        }
        
        int n = matrix[0].length;
        if (n == 0) {
            return;
        }
        
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
