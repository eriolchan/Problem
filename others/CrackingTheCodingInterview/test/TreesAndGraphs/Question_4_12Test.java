package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_12Test {

    @Test
    public void testCountPathsWithSum_DifferentPath() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(4));
        root.getLeft().getLeft().setRight(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(7));
        root.getLeft().getRight().setRight(new TreeNode(1));
        root.setRight(new TreeNode(11));
        root.getRight().setRight(new TreeNode(-1));
        root.getRight().getRight().setRight(new TreeNode(8));
        
        int actual = Question_4_12.countPathsWithSum(root, 10);
        assertEquals(5, actual);
        
        actual = Question_4_12.countPathsWithSum(root, 13);
        assertEquals(0, actual);
    }
    
    @Test
    public void testCountPathsWithSum_ExactValueNode() {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(1));
        root.getLeft().setLeft(new TreeNode(-1));
        root.getLeft().getLeft().setRight(new TreeNode(8));
        root.getLeft().setRight(new TreeNode(10));
        root.getLeft().getRight().setLeft(new TreeNode(2));
        root.setRight(new TreeNode(0));
        root.getRight().setRight(new TreeNode(5));
        root.getRight().getRight().setLeft(new TreeNode(5));
        root.getRight().getRight().setRight(new TreeNode(10));
        
        int actual = Question_4_12.countPathsWithSum(root, 10);
        assertEquals(7, actual);
    }
    
    @Test
    public void testCountPathsWithSum_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        int actual = Question_4_12.countPathsWithSum(root, 1);
        assertEquals(1, actual);
        
        actual = Question_4_12.countPathsWithSum(root, 2);
        assertEquals(0, actual);
    }
    
    @Test
    public void testCountPathsWithSum_Null() {
        TreeNode root = null;
        
        int actual = Question_4_12.countPathsWithSum(root, 1);
        assertEquals(0, actual);
    }
}
