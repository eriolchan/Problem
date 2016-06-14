package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_6Test {

    @Test
    public void testRotateMatrix_DimensionIsOdd() {
        int[][] matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
        };
        
        int[][] expected = new int[][] {
            { 3, 6, 9 },
            { 2, 5, 8 },
            { 1, 4, 7 },
        };
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_DimensionIsEven() {
        int[][] matrix = new int[][] {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
        };
        
        int[][] expected = new int[][] {
            { 4, 8, 12, 16 },
            { 3, 7, 11, 15 },
            { 2, 6, 10, 14 },
            { 1, 5, 9 , 13 },
        };
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_DimensionIsOne() {
        int[][] matrix = new int[][] {
            { 1 },
        };
        
        int[][] expected = new int[][] {
            { 1 },
        };
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_DifferentDimension() {
        int[][] matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        
        int[][] expected = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_DimensionIsZero() {
        int[][] matrix = new int[][] {
            new int[0],
        };
        
        int[][] expected = new int[][] {
            new int[0],
        };
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
        
        matrix = new int[0][];
        expected = new int[0][];
        Question_1_6.rotateMatrix(matrix);
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_Null() {
        int[][] matrix = null;
        
        Question_1_6.rotateMatrix(matrix);
        assertNull(matrix);
    }
}
