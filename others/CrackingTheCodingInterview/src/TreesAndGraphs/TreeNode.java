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
    
    // O(n)
    public static void inOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursively(root.left);
            visit(root);
            inOrderTraversalRecursively(root.right);
        }
    }
    
    // O(n)
    public static void preOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            visit(root);
            preOrderTraversalRecursively(root.left);
            preOrderTraversalRecursively(root.right);
        }
    }
    
    // O(n)
    public static void postOrderTraversalRecursively(TreeNode root) {
        if (root != null) {
            postOrderTraversalRecursively(root.left);
            postOrderTraversalRecursively(root.right);
            visit(root);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        
        final TreeNode other = (TreeNode)obj;
        
        return this.data == other.data;
    }
    
    @Override
    public int hashCode() {
        return data;
    }
    
    private static void visit(TreeNode node) {
        output.append(node.getData());
    }
}
