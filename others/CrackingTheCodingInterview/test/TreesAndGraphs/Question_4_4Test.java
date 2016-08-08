package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_4Test {

    @Test
    public void testIsBalanced_DifferIsZero() {
        TreeNode root = HelperTest.createPerfectTree();
        
        assertTrue(Question_4_4.isBalanced(root));
    }
    
    @Test
    public void testIsBalanced_DifferIsOne() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(4));
        
        assertTrue(Question_4_4.isBalanced(root));
    }
    
    @Test
    public void testIsBalanced_NotBalanced() {
        TreeNode root = HelperTest.createNoLeftChildTree();
        
        assertFalse(Question_4_4.isBalanced(root));
        
        root = HelperTest.createNotPerfectTree();
        assertFalse(Question_4_4.isBalanced(root));
    }
    
    @Test
    public void testIsBalanced_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        assertTrue(Question_4_4.isBalanced(root));
    }
    
    @Test
    public void testIsBalanced_Null() {
        TreeNode root = null;
        
        assertTrue(Question_4_4.isBalanced(root));
    }
}
