package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_8Test {

    @Test
    public void testFindCommonAncestor_DifferentNode() {
        TreeNode root = buildTestTree();
        
        TreeNode n1 = root.getRight().getLeft();
        TreeNode n2 = root.getRight().getRight();
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
        
        n2 = root.getRight().getRight().getLeft();
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
        
        n1 = root.getLeft().getRight();
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindCommonAncestor_OneIsParent() {
        TreeNode root = buildTestTree();
        
        TreeNode n1 = root.getRight().getRight().getLeft();
        TreeNode n2 = root.getRight().getRight();
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(6, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(6, actual.getData());
        
        n2 = n1;
        n1 = root.getRight();
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(3, actual.getData());
    }
    
    @Test
    public void testFindCommonAncestor_OneIsRoot() {
        TreeNode root = buildTestTree();
        
        TreeNode n1 = root.getLeft().getRight();
        TreeNode n2 = root;
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
        
        n1 = root;
        n2 = root.getRight().getRight();
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindCommonAncestor_Same() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.setRight(new TreeNode(3, root));
        
        TreeNode n1 = root.getLeft();
        TreeNode n2 = n1;
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertEquals(2, actual.getData());
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertEquals(2, actual.getData());
    }
    
    @Test
    public void testFindCommonAncestor_Null() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.setRight(new TreeNode(3, root));
        
        TreeNode n1 = root.getLeft();
        TreeNode n2 = null;
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertNull(actual);
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertNull(actual);
        
        n1 = null;
        n2 = root.getRight();
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertNull(actual);
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertNull(actual);
        
        root = null;
        actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertNull(actual);
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertNull(actual);
    }
    
    @Test
    public void testFindCommonAncestor_NodeNotExist() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.setRight(new TreeNode(3, root));
        
        TreeNode n1 = root.getLeft();
        TreeNode n2 = new TreeNode(4);
        TreeNode actual = Question_4_8.findCommonAncestorWithParentLink(root, n1, n2);
        assertNull(actual);
        actual = Question_4_8.findCommonAncestorWithoutParentLink(root, n1, n2);
        assertNull(actual);
    }
    
    private TreeNode buildTestTree() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2, root));
        root.getLeft().setRight(new TreeNode(4, root.getLeft()));
        root.setRight(new TreeNode(3, root));
        root.getRight().setLeft(new TreeNode(5, root.getRight()));
        root.getRight().setRight(new TreeNode(6, root.getRight()));
        root.getRight().getRight().setLeft(new TreeNode(7, root.getRight().getRight()));
        
        return root;
    }
}
