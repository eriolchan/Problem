package ArraysAndStrings;

/**
 * Question 1.7
 * Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
public class Question_1_7 {

    // O(n^2)
    public static boolean rotateMatrixByMirror(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        
        int m = matrix.length;
        if (m == 0 || matrix[0] == null || m != matrix[0].length) {
            return false;
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                swap(matrix, i, j, j, i);
            }
        }
        
        for (int i= 0; i < m / 2; ++i) {
            for (int j = 0; j < m; ++j) {
                swap(matrix, i, j, m - 1 - i, j);
            }
        }
        
        return true;
    }
    
    // O(n^2)
    public static boolean rotateMatrixByRoll(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        
        int m = matrix.length;
        if (m == 0 || matrix[0] == null || m != matrix[0].length) {
            return false;
        }
        
        for (int i = 0; i < m / 2; ++i) {
            int last = m - 1 - i;
            
            for (int j = i; j < last; ++j) {
                int offset = j - i;
                int top = matrix[i][j];
                
                matrix[i][j] = matrix[j][last];
                matrix[j][last] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[last - offset][i];
                matrix[last - offset][i] = top;
            }
        }
        
        return true;
    }
    
    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
