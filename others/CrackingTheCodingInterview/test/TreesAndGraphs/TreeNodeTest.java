package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void testInOrderTraversal_NotPerfectTree() {
        TreeNode root = HelperTest.createNotPerfectTree();
        String expected = "47215386";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testInOrderTraversal_NoRightChildTree() {
        TreeNode root = HelperTest.createNoRightChildTree();
        String expected = "54321";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testInOrderTraversal_NoLeftChildTree() {
        TreeNode root = HelperTest.createNoLeftChildTree();
        String expected = "12345";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testInOrderTraversal_PerfectTree() {
        TreeNode root = HelperTest.createPerfectTree();
        String expected = "4251637";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testInOrderTraversal_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        String expected = "1";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testInOrderTraversal_Null() {
        TreeNode root = null;
        String expected = "";
        
        TreeNode.inOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_NotPerfectTree() {
        TreeNode root = HelperTest.createNotPerfectTree();
        String expected = "12473568";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_NoRightChildTree() {
        TreeNode root = HelperTest.createNoRightChildTree();
        String expected = "12345";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_NoLeftChildTree() {
        TreeNode root = HelperTest.createNoLeftChildTree();
        String expected = "12345";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_PerfectTree() {
        TreeNode root = HelperTest.createPerfectTree();
        String expected = "1245367";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        String expected = "1";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPreOrderTraversal_Null() {
        TreeNode root = null;
        String expected = "";
        
        TreeNode.preOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_NotPerfectTree() {
        TreeNode root = HelperTest.createNotPerfectTree();
        String expected = "74258631";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_NoRightChildTree() {
        TreeNode root = HelperTest.createNoRightChildTree();
        String expected = "54321";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_NoLeftChildTree() {
        TreeNode root = HelperTest.createNoLeftChildTree();
        String expected = "54321";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_PerfectTree() {
        TreeNode root = HelperTest.createPerfectTree();
        String expected = "4526731";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        String expected = "1";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
    
    @Test
    public void testPostOrderTraversal_Null() {
        TreeNode root = null;
        String expected = "";
        
        TreeNode.postOrderTraversalRecursively(root);
        assertEquals(expected, TreeNode.getResult());
    }
}
