package TreesAndGraphs;

import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the number
 * of paths that sum to a given value. The path does not need to start or end at
 * the root or a leaf, but it must go downwards (traveling only from parent nodes
 * to child nodes).
 */
public class Question_4_12 {

    // O(n)
    public static int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSumRecursively(root, targetSum, 0, new HashMap<Integer, Integer>());
    }
    
    private static int countPathsWithSumRecursively(TreeNode root, int targetSum, int runningSum,
                                                    HashMap<Integer, Integer> pathCount) {
        if (root == null) {
            return 0;
        }
        
        runningSum += root.getData();
        int sum = runningSum - targetSum;
        int totalCount = pathCount.getOrDefault(sum, 0);
        
        if (runningSum == targetSum) {
            ++totalCount;
        }
        
        IncrementHashMap(pathCount, runningSum, 1);
        totalCount += countPathsWithSumRecursively(root.getLeft(), targetSum, runningSum, pathCount);
        totalCount += countPathsWithSumRecursively(root.getRight(), targetSum, runningSum, pathCount);
        IncrementHashMap(pathCount, runningSum, -1);
        
        return totalCount;
    }
    
    private static void IncrementHashMap(HashMap<Integer, Integer> pathCount, int key, int delta) {
        int newCount = pathCount.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            pathCount.remove(key);
        } else {
            pathCount.put(key, newCount);
        }
    }
}
