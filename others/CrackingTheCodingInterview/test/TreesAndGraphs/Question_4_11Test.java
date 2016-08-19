package TreesAndGraphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_4_11Test {

    @Test
    public void testBSTreeNode() {
        Question_4_11 tree = new Question_4_11();
        tree.insertInOrder(3);
        tree.insertInOrder(1);
        tree.insertInOrder(2);
        tree.insertInOrder(5);
        tree.insertInOrder(4);
        tree.insertInOrder(6);
        
        BSTreeNode actual = tree.find(1);
        assertEquals(1, actual.getData());
        
        actual = tree.find(9);
        assertNull(actual);
        
        BSTreeNode r1 = tree.getRandomNode();
        BSTreeNode r2 = tree.getRandomNode();
        assertNotEquals(r1.getData(), r2.getData());
    }
    
    @Test
    public void testBSTreeNode_Null() {
        Question_4_11 tree = new Question_4_11();
        
        BSTreeNode actual = tree.find(1);
        assertNull(actual);
        
        BSTreeNode r = tree.getRandomNode();
        assertNull(r);
    }
}
