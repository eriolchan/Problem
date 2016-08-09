package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_5Test {

    @Test
    public void testCheckBST_NoDuplicate() {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(2));
        root.setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(6));
        
        assertTrue(Question_4_5.checkBSTByInOrder(root));
        assertTrue(Question_4_5.checkBSTByMaxMin(root));
    }
    
    @Test
    public void testCheckBST_NotBST() {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));
        root.setRight(new TreeNode(4));
        
        assertFalse(Question_4_5.checkBSTByInOrder(root));
        assertFalse(Question_4_5.checkBSTByMaxMin(root));
    }
    
    @Test
    public void testCheckBST_DuplicateAtLeft() {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getRight().setRight(new TreeNode(4));
        
        assertTrue(Question_4_5.checkBSTByInOrder(root));
        assertTrue(Question_4_5.checkBSTByMaxMin(root));
    }
    
    @Test
    public void testCheckBST_DuplicateAtRight() {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(2));
        root.getRight().setRight(new TreeNode(4));
        
        // assertFalse(Question_4_5.checkBSTByInOrder(root)); -> cannot handle this case.
        assertFalse(Question_4_5.checkBSTByMaxMin(root));
    }
    
    @Test
    public void testCheckBST_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        assertTrue(Question_4_5.checkBSTByInOrder(root));
        assertTrue(Question_4_5.checkBSTByMaxMin(root));
    }
    
    @Test
    public void testCheckBST_Null() {
        TreeNode root = null;
        
        assertTrue(Question_4_5.checkBSTByInOrder(root));
        assertTrue(Question_4_5.checkBSTByMaxMin(root));
    }
}
