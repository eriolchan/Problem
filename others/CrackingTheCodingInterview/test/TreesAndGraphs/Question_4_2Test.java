package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_2Test {

    @Test
    public void testCreateMinimalBST_PerfectTree() {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        
        TreeNode expected = new TreeNode(4);
        expected.setLeft(new TreeNode(2));
        expected.getLeft().setLeft(new TreeNode(1));
        expected.getLeft().setRight(new TreeNode(3));
        expected.setRight(new TreeNode(6));
        expected.getRight().setLeft(new TreeNode(5));
        expected.getRight().setRight(new TreeNode(7));
        TreeNode actual = Question_4_2.createMinimalBST(array);
        HelperTest.assertTreeEquals(expected, actual);
    }
    
    @Test
    public void testCreateMinimalBST_LessThanPerfectTree() {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
        
        TreeNode expected = new TreeNode(3);
        expected.setLeft(new TreeNode(1));
        expected.getLeft().setRight(new TreeNode(2));
        expected.setRight(new TreeNode(5));
        expected.getRight().setLeft(new TreeNode(4));
        expected.getRight().setRight(new TreeNode(6));
        TreeNode actual = Question_4_2.createMinimalBST(array);
        HelperTest.assertTreeEquals(expected, actual);
    }
    
    @Test
    public void testCreateMinimalBST_MoreThanPerfectTree() {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        
        TreeNode expected = new TreeNode(4);
        expected.setLeft(new TreeNode(2));
        expected.getLeft().setLeft(new TreeNode(1));
        expected.getLeft().setRight(new TreeNode(3));
        expected.setRight(new TreeNode(6));
        expected.getRight().setLeft(new TreeNode(5));
        expected.getRight().setRight(new TreeNode(7));
        expected.getRight().getRight().setRight(new TreeNode(8));
        TreeNode actual = Question_4_2.createMinimalBST(array);
        HelperTest.assertTreeEquals(expected, actual);
    }
    
    @Test
    public void testCreateMinimalBST_OnlyRoot() {
        int[] array = new int[] { 1 };
        
        TreeNode expected = new TreeNode(1);
        TreeNode actual = Question_4_2.createMinimalBST(array);
        HelperTest.assertTreeEquals(expected, actual);
    }
    
    @Test
    public void testCreateMinimalBST_Empty() {
        int[] array = new int[0];
        
        TreeNode actual = Question_4_2.createMinimalBST(array);
        assertNull(actual);
    }
    
    @Test
    public void testCreateMinimalBST_Null() {
        int[] array = null;
        
        TreeNode actual = Question_4_2.createMinimalBST(array);
        assertNull(actual);
    }
}
