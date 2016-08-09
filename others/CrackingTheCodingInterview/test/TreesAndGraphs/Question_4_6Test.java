package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_6Test {

    @Test
    public void testInOrderSuccessor_HasRightChild() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.getLeft().setRight(new TreeNode(3, root.getLeft()));
        root.setRight(new TreeNode(4, root));
        
        TreeNode node = root.getLeft();
        TreeNode actual = Question_4_6.inOrderSuccessor(node);
        assertEquals(3, actual.getData());
        
        root.getLeft().getRight().setRight(new TreeNode(5, root.getLeft().getRight()));
        actual = Question_4_6.inOrderSuccessor(node);
        assertEquals(3, actual.getData());
        
        root.getLeft().getRight().setLeft(new TreeNode(6, root.getLeft().getRight()));
        actual = Question_4_6.inOrderSuccessor(node);
        assertEquals(6, actual.getData());
    }
    
    @Test
    public void testInOrderSuccessor_NoRightChildAndNodeIsLeftChild() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.getLeft().setLeft(new TreeNode(3, root.getLeft()));
        root.setRight(new TreeNode(4, root));
        
        TreeNode node = root.getLeft();
        TreeNode actual = Question_4_6.inOrderSuccessor(node);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testInOrderSuccessor_NoRightChildAndNodeIsRightChild() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.getLeft().setLeft(new TreeNode(3, root.getLeft()));
        root.getLeft().setRight(new TreeNode(4, root.getLeft()));
        root.getLeft().getRight().setLeft(new TreeNode(5, root.getLeft().getRight()));
        root.setRight(new TreeNode(6, root));
        
        TreeNode node = root.getLeft().getRight();
        TreeNode actual = Question_4_6.inOrderSuccessor(node);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testInOrderSuccessor_Last() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.setRight(new TreeNode(3, root));
        
        TreeNode node = root.getRight();
        TreeNode actual = Question_4_6.inOrderSuccessor(node);
        assertNull(actual);
    }
    
    @Test
    public void testInOrderSuccessor_NoRightChildAndNodeIsRoot() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        
        TreeNode node = root.getRight();
        TreeNode actual = Question_4_6.inOrderSuccessor(node);
        assertNull(actual);
    }
    
    @Test
    public void testInOrderSuccessor_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        TreeNode actual = Question_4_6.inOrderSuccessor(root);
        assertNull(actual);
    }
    
    @Test
    public void testInOrderSuccessor_Null() {
        TreeNode root = null;
        
        TreeNode actual = Question_4_6.inOrderSuccessor(root);
        assertNull(actual);
    }
}
