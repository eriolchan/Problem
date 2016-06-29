package ArraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_1_7Test {

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
        assertTrue(Question_1_7.rotateMatrixByMirror(matrix));
        HelperTest.assertMatrixEquals(expected, matrix);
        
        matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
        };
        assertTrue(Question_1_7.rotateMatrixByRoll(matrix));
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
        assertTrue(Question_1_7.rotateMatrixByMirror(matrix));
        HelperTest.assertMatrixEquals(expected, matrix);
        
        matrix = new int[][] {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
        };
        assertTrue(Question_1_7.rotateMatrixByRoll(matrix));
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
        assertTrue(Question_1_7.rotateMatrixByMirror(matrix));
        HelperTest.assertMatrixEquals(expected, matrix);
        
        matrix = new int[][] {
            { 1 },
        };
        assertTrue(Question_1_7.rotateMatrixByRoll(matrix));
        HelperTest.assertMatrixEquals(expected, matrix);
    }
    
    @Test
    public void testRotateMatrix_DifferentDimension() {
        int[][] matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        
        assertFalse(Question_1_7.rotateMatrixByMirror(matrix));
        assertFalse(Question_1_7.rotateMatrixByRoll(matrix));
    }
    
    @Test
    public void testRotateMatrix_DimensionIsZero() {
        int[][] matrix = new int[][] {
            new int[0],
        };
        
        assertFalse(Question_1_7.rotateMatrixByMirror(matrix));
        assertFalse(Question_1_7.rotateMatrixByRoll(matrix));
        
        matrix = new int[0][];
        assertFalse(Question_1_7.rotateMatrixByMirror(matrix));
        assertFalse(Question_1_7.rotateMatrixByRoll(matrix));
    }
    
    @Test
    public void testRotateMatrix_Null() {
        int[][] matrix = null;
        
        assertFalse(Question_1_7.rotateMatrixByMirror(matrix));
        assertNull(matrix);
        
        assertFalse(Question_1_7.rotateMatrixByRoll(matrix));
        assertNull(matrix);
    }
}
