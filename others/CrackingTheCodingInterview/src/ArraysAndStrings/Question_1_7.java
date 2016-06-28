package ArraysAndStrings;

/**
 * Question 1.7
 * Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
public class Question_1_7 {

    // O(n^2)
    public static void rotateMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        
        int m = matrix.length;
        if (m == 0 || matrix[0] == null || m != matrix[0].length) {
            return;
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
    }
    
    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
