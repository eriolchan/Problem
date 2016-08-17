package TreesAndGraphs;

/**
 * Question 4.10
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 * is identical to T2.
 */
public class Question_4_10 {

    //O(n+m)
    public static boolean containsTreeByString(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return false;
        }
        
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        
        getOrderString(n1, builder1);
        getOrderString(n2, builder2);
        
        return builder1.indexOf(builder2.toString()) != -1;
    }
    
    // O(n+km)
    public static boolean containsTreeByDFS(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return false;
        }
        
        return subTree(n1, n2);
    }
    
    private static void getOrderString(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("X");
            return;
        }
        
        builder.append(root.getData());
        getOrderString(root.getLeft(), builder);
        getOrderString(root.getRight(), builder);
    }
    
    private static boolean subTree(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return false;
        }
        
        if (n1.getData() == n2.getData() && matchTree(n1, n2)) {
            return true;
        }
        
        return subTree(n1.getLeft(), n2) || subTree(n1.getRight(), n2);
    }
    
    private static boolean matchTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        
        if (n1 == null || n2 == null) {
            return false;
        }
        
        if (n1.getData() != n2.getData()) {
            return false;
        }
        
        return matchTree(n1.getLeft(), n2.getLeft()) && matchTree(n1.getRight(), n2.getRight());
    }
}
