package TreesAndGraphs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class Question_4_9Test {

    @Test
    public void testAllSequence_PerfectTree() {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(3));
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>(Arrays.asList(2, 1, 3)));
        expected.add(new LinkedList<Integer>(Arrays.asList(2, 3, 1)));
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAllSequence_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>(Arrays.asList(1)));
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAllSequence_NotPerfectTree() {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(2));
        root.setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(6));
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 2, 5, 4, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 2, 4, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 4, 2, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 4, 6, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 2, 4, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 4, 2, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 4, 6, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 4, 1, 2, 6)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 4, 1, 6, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 4, 6, 1, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 2, 5, 6, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 2, 6, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 6, 2, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 1, 5, 6, 4, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 2, 6, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 6, 2, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 1, 6, 4, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 6, 1, 2, 4)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 6, 1, 4, 2)));
        expected.add(new LinkedList<Integer>(Arrays.asList(3, 5, 6, 4, 1, 2)));
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAllSequence_NoLeftChildTree() {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.getRight().setRight(new TreeNode(3));
        root.getRight().getRight().setRight(new TreeNode(4));
        root.getRight().getRight().getRight().setRight(new TreeNode(5));
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAllSequence_NoRightChildTree() {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(4));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().getLeft().setLeft(new TreeNode(2));
        root.getLeft().getLeft().getLeft().setLeft(new TreeNode(1));
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>(Arrays.asList(5, 4, 3, 2, 1)));
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testAllSequence_Null() {
        TreeNode root = null;
        
        ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
        expected.add(new LinkedList<Integer>());
        ArrayList<LinkedList<Integer>> actual = Question_4_9.allSequence(root);
        assertEquals(expected, actual);
    }
}
