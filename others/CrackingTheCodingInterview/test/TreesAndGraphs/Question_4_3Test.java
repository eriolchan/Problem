package TreesAndGraphs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class Question_4_3Test {

    @Test
    public void testCreateLinkedListByDFS_NotPerfectTree() {
        TreeNode root = HelperTest.createNotPerfectTree();
        
        ArrayList<LinkedList<TreeNode>> expected = createListOfList(new int[][] {
            { 1 },
            { 2, 3 },
            {4, 5, 6 },
            {7, 8 },
        });
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLinkedListByBFS(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateLinkedListByDFS_NoLeftChildTree() {
        TreeNode root = HelperTest.createNoLeftChildTree();
        
        ArrayList<LinkedList<TreeNode>> expected = createListOfList(new int[][] {
            { 1 },
            { 2 },
            { 3 },
            { 4 },
            { 5 },
        });
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLinkedListByBFS(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateLinkedListByDFS_NoRightChildTree() {
        TreeNode root = HelperTest.createNoRightChildTree();
        
        ArrayList<LinkedList<TreeNode>> expected = createListOfList(new int[][] {
            { 1 },
            { 2 },
            { 3 },
            { 4 },
            { 5 },
        });
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLinkedListByBFS(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateLinkedListByDFS_PerfectTree() {
        TreeNode root = HelperTest.createPerfectTree();
        
        ArrayList<LinkedList<TreeNode>> expected = createListOfList(new int[][] {
            { 1 },
            { 2, 3 },
            {4, 5, 6, 7 },
        });
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLinkedListByBFS(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateLinkedListByDFS_OnlyRoot() {
        TreeNode root = new TreeNode(1);
        
        ArrayList<LinkedList<TreeNode>> expected = createListOfList(new int[][] {
            { 1 },
        });
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLinkedListByBFS(root);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCreateLinkedListByDFS_Null() {
        TreeNode root = null;
        
        ArrayList<LinkedList<TreeNode>> expected = new ArrayList<LinkedList<TreeNode>>();
        ArrayList<LinkedList<TreeNode>> actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
        
        actual = Question_4_3.createLevelLinkedListByDFS(root);
        assertEquals(expected, actual);
    }
    
    private static ArrayList<LinkedList<TreeNode>> createListOfList(int[][] data) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        for (int[] list : data) {
            LinkedList<TreeNode> treeNodeList = new LinkedList<TreeNode>();
            for (int value : list) {
                treeNodeList.add(new TreeNode(value));
            }
            
            result.add(treeNodeList);
        }
        
        return result;
    }
}
