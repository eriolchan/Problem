package TreesAndGraphs;

public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;
    
    private static StringBuilder output;
    
    static {
        output = new StringBuilder();
    }
    
    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
    
    public int getData() {
        return data;
    }
    
    public TreeNode getLeft() {
        return left;
    }
    
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    
    public TreeNode getRight() {
        return right;
    }
    
    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    public static String getResult() {
        String result = output.toString();
        output.setLength(0);
        
        return result;
    }
    
    public static void inOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursively(root.left);
            output.append(root.getData());
            inOrderTraversalRecursively(root.right);
        }
    }
    
    public static void preOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            output.append(root.getData());
            preOrderTraversalRecursively(root.left);
            preOrderTraversalRecursively(root.right);
        }
    }
    
    public static void postOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            postOrderTraversalRecursively(root.left);
            postOrderTraversalRecursively(root.right);
            output.append(root.getData());
        }
    }
}
