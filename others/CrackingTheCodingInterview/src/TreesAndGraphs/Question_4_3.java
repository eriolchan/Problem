package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Question_4_3 {

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListByDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLinkedListByDFSRecursively(root, lists, 0);
        
        return lists;
    }
    
    public static ArrayList<LinkedList<TreeNode>> createLinkedListByBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        
        while (!list.isEmpty()) {
            lists.add(list);
            
            LinkedList<TreeNode> parent = list;
            list = new LinkedList<TreeNode>();
            
            for (TreeNode node : parent) {
                if (node.getLeft() != null) {
                    list.add(node.getLeft());
                }
                
                if (node.getRight() != null) {
                    list.add(node.getRight());
                }
            }
        }
        
        return lists;
    }
    
    private static void createLinkedListByDFSRecursively(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root != null) {
            if (level == lists.size()) {
                lists.add(new LinkedList<TreeNode>());
            }
            
            lists.get(level).add(root);
            createLinkedListByDFSRecursively(root.getLeft(), lists, level + 1);
            createLinkedListByDFSRecursively(root.getRight(), lists, level + 1);
        }
    }
}
