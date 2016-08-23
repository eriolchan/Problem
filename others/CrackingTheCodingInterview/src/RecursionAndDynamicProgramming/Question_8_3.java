package RecursionAndDynamicProgramming;

/**
 * Question 8.3
 * A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class Question_8_3 {

    public static int findMagic(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        return findMagicRecursively(array, 0, array.length - 1);
    }
    
    private static int findMagicRecursively(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        int midValue = array[mid];
        
        if (midValue == mid) {
            return mid;
        }
        
        int left = findMagicRecursively(array, start, Math.min(mid - 1, midValue));
        if (left >= 0) {
            return left;
        }
        
        int right = findMagicRecursively(array, Math.max(mid + 1, midValue), end);
        
        return right;
    }
}
