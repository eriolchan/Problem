package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_4Test {

    @Test
    public void testAdd_SameLength() {
        Node n1 = Node.createLinkedList(new int[] { 3, 1, 5 });
        Node n2 = Node.createLinkedList(new int[] { 5, 9, 2 });
        
        Node expected = Node.createLinkedList(new int[] { 8, 0, 8});
        Node actual = Question_2_4.add(n1, n2);
        NodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_DifferentLength() {
        Node n1 = Node.createLinkedList(new int[] { 2, 1 });
        Node n2 = Node.createLinkedList(new int[] { 3, 2, 1 });
        
        Node expected = Node.createLinkedList(new int[] { 5, 3, 1});
        Node actual = Question_2_4.add(n1, n2);
        NodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_ExtraCounter() {
        Node n1 = Node.createLinkedList(new int[] { 1 });
        Node n2 = Node.createLinkedList(new int[] { 9, 9 });
        
        Node expected = Node.createLinkedList(new int[] { 0, 0, 1});
        Node actual = Question_2_4.add(n1, n2);
        NodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_OneElement() {
        Node n1 = Node.createLinkedList(new int[] { 1 });
        Node n2 = Node.createLinkedList(new int[] { 1 });
        
        Node expected = Node.createLinkedList(new int[] { 2 });
        Node actual = Question_2_4.add(n1, n2);
        NodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_Null() {
        Node n1 = null;
        Node n2 = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node actual = Question_2_4.add(n1, n2);
        NodeTest.assertLinkedListEquals(n2, actual);
        
        n2 = null;
        actual = Question_2_4.add(n1, n2);
        assertNull(actual);
    }
}
