package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_10Test {

    @Test
    public void testContainsTree_True() {
        TreeNode n1 = HelperTest.createNotPerfectTree();
        TreeNode n2 = new TreeNode(7);
        
        assertTrue(Question_4_10.containsTreeByDFS(n1, n2));
        assertTrue(Question_4_10.containsTreeByString(n1, n2));
        
        n2 = new TreeNode(3);
        n2.setLeft(new TreeNode(5));
        n2.setRight(new TreeNode(6));
        n2.getRight().setLeft(new TreeNode(8));
        assertTrue(Question_4_10.containsTreeByDFS(n1, n2));
        assertTrue(Question_4_10.containsTreeByString(n1, n2));
    }
    
    @Test
    public void testContainsTree_False() {
        TreeNode n1 = HelperTest.createNotPerfectTree();
        TreeNode n2 = new TreeNode(9);
        
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
        
        n2 = new TreeNode(3);
        n2.setLeft(new TreeNode(5));
        n2.setRight(new TreeNode(6));
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
        
        n2.getRight().setLeft(new TreeNode(7));;
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
    }
    
    @Test
    public void testContainsTree_Same() {
        TreeNode n1 = HelperTest.createNotPerfectTree();
        TreeNode n2 = HelperTest.createNotPerfectTree();
        
        assertTrue(Question_4_10.containsTreeByDFS(n1, n2));
        assertTrue(Question_4_10.containsTreeByString(n1, n2));
    }
    
    @Test
    public void testContainsTree_FirstIsSubTree() {
        TreeNode n1 = new TreeNode(3);
        n1.setLeft(new TreeNode(5));
        n1.setRight(new TreeNode(6));
        n1.getRight().setLeft(new TreeNode(8));
        TreeNode n2 = HelperTest.createNotPerfectTree();
        
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
    }
    
    @Test
    public void testContainsTree_OnlyRoot() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        
        assertTrue(Question_4_10.containsTreeByDFS(n1, n2));
        assertTrue(Question_4_10.containsTreeByString(n1, n2));
        
        n2 = new TreeNode(2);
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
    }
    
    @Test
    public void testContainsTree_Null() {
        TreeNode n1 = null;
        TreeNode n2 = new TreeNode(1);
        
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
        
        n1 = new TreeNode(1);
        n2 = null;
        assertFalse(Question_4_10.containsTreeByDFS(n1, n2));
        assertFalse(Question_4_10.containsTreeByString(n1, n2));
    }
}
