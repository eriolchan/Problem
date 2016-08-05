package TreesAndGraphs;

import static org.junit.Assert.*;

public class HelperTest {

    public static TreeNode createNotPerfectTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().getLeft().setRight(new TreeNode(7));
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(6));
        root.getRight().getRight().setLeft(new TreeNode(8));
        
        return root;
    }
    
    public static TreeNode createNoRightChildTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(4));
        root.getLeft().getLeft().getLeft().setLeft(new TreeNode(5));
        
        return root;
    }
    
    public static TreeNode createNoLeftChildTree() {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.getRight().setRight(new TreeNode(3));
        root.getRight().getRight().setRight(new TreeNode(4));
        root.getRight().getRight().getRight().setRight(new TreeNode(5));
        
        return root;
    }
    
    public static TreeNode createPerfectTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        
        return root;
    }
    
    public static void assertTreeEquals(TreeNode expected, TreeNode actual) {
        if (expected != null && actual != null) {
            assertEquals(expected, actual);
            assertTreeEquals(expected.getLeft(), actual.getLeft());
            assertTreeEquals(expected.getRight(), actual.getRight());
        } else {
            assertTrue(expected == null && actual == null);
        }
    }
}
