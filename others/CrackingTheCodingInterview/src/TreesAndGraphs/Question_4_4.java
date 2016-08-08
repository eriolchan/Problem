package TreesAndGraphs;

/**
 * Question 4.4
 * Implement a function to check if a binary tree is balanced. The balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class Question_4_4 {

    // O(n)
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    private static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == -1) {
            return -1;
        }
        
        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -1) {
            return -1;
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
