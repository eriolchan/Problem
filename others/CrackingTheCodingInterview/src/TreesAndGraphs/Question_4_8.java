package TreesAndGraphs;

/**
 * Question 4.8
 * Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 */
public class Question_4_8 {

    // O(n)
    public static TreeNode findCommonAncestorWithParentLink(TreeNode root, TreeNode n1, TreeNode n2) {
        if (!covers(root, n1) || !covers(root, n2)) {
            return null;
        } else if (covers(n1, n2)) {
            return n1;
        } else if (covers(n2, n1)) {
            return n2;
        }
        
        TreeNode sibling = getSibling(n1);
        TreeNode parent = n1.getParent();
        while (!covers(sibling, n2)) {
            sibling = getSibling(parent);
            parent = parent.getParent();
        }
        
        return parent;
    }
    
    // O(n)
    public static TreeNode findCommonAncestorWithoutParentLink(TreeNode root, TreeNode n1, TreeNode n2) {
        Result result = findCommonAncestorRecursively(root, n1, n2);
        if (result.isAncestor) {
            return result.node;
        }
        
        return null;
    }
    
    private static boolean covers(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        
        if (root == node) {
            return true;
        }
        
        return covers(root.getLeft(), node) || covers(root.getRight(), node);
    }
    
    private static TreeNode getSibling(TreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }
        
        TreeNode parent = node.getParent();
        
        return node == parent.getLeft() ? parent.getRight() : parent.getLeft();
    }
    
    private static Result findCommonAncestorRecursively(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return Result.getInstance(null, false);
        }
        
        if (root == n1 && root == n2) {
            return Result.getInstance(root, true);
        }
        
        Result leftResult = findCommonAncestorRecursively(root.getLeft(), n1, n2);
        if (leftResult.isAncestor) {
            return leftResult;
        }
        
        Result rightResult = findCommonAncestorRecursively(root.getRight(), n1, n2);
        if (rightResult.isAncestor) {
            return rightResult;
        }
        
        if (leftResult.node != null && rightResult.node != null) {
            return Result.getInstance(root, true);
        } else if (root == n1 || root == n2) {
            boolean isAncestor = leftResult.node != null || rightResult.node != null;
            return Result.getInstance(root, isAncestor);
        } else {
            return leftResult.node != null ? leftResult : rightResult;
        }
    }
    
    private static class Result {
        private TreeNode node;
        private boolean isAncestor;
        
        private Result(TreeNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
        
        public static Result getInstance(TreeNode node, boolean isAncestor) {
            return new Result(node, isAncestor);
        }
    }
}
