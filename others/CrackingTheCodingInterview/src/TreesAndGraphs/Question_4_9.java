package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Question 4.9
 * A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print
 * all possible arrays that could have led to this tree.
 */
public class Question_4_9 {

    // O(n^3)
    public static ArrayList<LinkedList<Integer>> allSequence(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        
        if (root == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(root.getData());
        
        ArrayList<LinkedList<Integer>> leftSequence = allSequence(root.getLeft());
        ArrayList<LinkedList<Integer>> rightSequence = allSequence(root.getRight());
        
        for (LinkedList<Integer> left : leftSequence) {
            for (LinkedList<Integer> right : rightSequence) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        
        return result;
    }
    
    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                   ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<Integer>();
            result.addAll(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
