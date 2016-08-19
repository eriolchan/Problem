package TreesAndGraphs;

import java.util.Random;

/**
 * Question 4.11
 * You are implementing a binary search tree class from scratch, which, in addition
 * to insert, find and delete, has a method getRandomNode() which return a random node from
 * the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for getRandomNode, and explain how you would implement the rest of the methods.
 */
public class Question_4_11 {

    private BSTreeNode root;
    
    public Question_4_11() {
        root = null;
    }
    
    public int size() {
        return root == null ? 0 : root.getSize();
    }
    
    public void insertInOrder(int data) {
        if (root == null) {
            root = new BSTreeNode(data);
        } else {
            root.insertInOrder(data);
        }
    }
    
    public BSTreeNode getRandomNode() {
        if (root == null) {
            return null;
        }
        
        Random random = new Random();
        int i = random.nextInt(size());
        
        return root.getIthNode(i);
    }
    
    public BSTreeNode find(int data) {
        if (root == null) {
            return null;
        }
        
        return root.find(data);
    }
}

class BSTreeNode {

    private int data;
    private int size;
    private BSTreeNode left;
    private BSTreeNode right;
    
    public BSTreeNode(int data) {
        this.data = data;
        this.size = 1;
        left = null;
        right = null;
    }
    
    public int getData() {
        return data;
    }
    
    public int getSize() {
        return size;
    }
    
    // O(log n)
    public void insertInOrder(int data) {
        if (data <= this.data) {
            if (left == null) {
                left = new BSTreeNode(data);
            } else {
                left.insertInOrder(data);
            }
        } else {
            if (right == null) {
                right = new BSTreeNode(data);
            } else {
                right.insertInOrder(data);
            }
        }
        
        ++size;
    }
    
    // O(log n)
    public BSTreeNode getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size;
        
        if (i == leftSize) {
            return this;
        } else if (i < leftSize) {
            return left.getIthNode(i);
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }
    
    public BSTreeNode find(int data) {
        if (data == this.data) {
            return this;
        } else if (data < this.data) {
            return left != null ? left.find(data) : null;
        } else {
            return right != null ? right.find(data) : null;
        }
    }
}
