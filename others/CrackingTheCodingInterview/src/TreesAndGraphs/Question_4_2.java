package TreesAndGraphs;

/**
 * Question 4.2
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class Question_4_2 {

    public static TreeNode createMinimalBST(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        
        return createBinarySearchTreeCore(array, 0, array.length - 1);
    }
    
    private static TreeNode createBinarySearchTreeCore(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(array[middle]);
        root.setLeft(createBinarySearchTreeCore(array, start, middle - 1));
        root.setRight(createBinarySearchTreeCore(array, middle + 1, end));
        
        return root;
    }
}
