package TreesAndGraphs;

/**
 * Question 4.5
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Question_4_5 {

    private static Integer last;
    
    // O(n)
    public static boolean checkBSTByInOrder(TreeNode root) {
        last = null;
        return checkBSTByInOrderRecursively(root);
    }
    
    // O(n)
    public static boolean checkBSTByMaxMin(TreeNode root) {
        return checkBSTByMaxMinRecursively(root, null, null);
    }
    
    private static boolean checkBSTByInOrderRecursively(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if(!checkBSTByInOrderRecursively(root.getLeft())) {
            return false;
        }
        
        if (last != null && last > root.getData()) {
            return false;
        }
        
        last = root.getData();
        
        if (!checkBSTByInOrderRecursively(root.getRight())) {
            return false;
        }
        
        return true;
    }
    
    private static boolean checkBSTByMaxMinRecursively(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        if ((min != null && root.getData() <= min) || (max != null && root.getData() > max)) {
            return false;
        }
        
        return checkBSTByMaxMinRecursively(root.getLeft(), min, root.getData()) &&
               checkBSTByMaxMinRecursively(root.getRight(), root.getData(), max);
    }
}
