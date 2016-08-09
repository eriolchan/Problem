package TreesAndGraphs;

/**
 * Question 4.6
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in
 * a binary tree. You may assume that each node has a link to its parent.
 */
public class Question_4_6 {

    public static TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        if (node.getRight() != null) {
            return leftMostChild(node.getRight());
        }
        
        TreeNode parent = node.getParent();
        while (parent != null && node != parent.getLeft()) {
            node = parent;
            parent = parent.getParent();
        }
        
        return parent;
    }
    
    private static TreeNode leftMostChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        
        return root;
    }
}
