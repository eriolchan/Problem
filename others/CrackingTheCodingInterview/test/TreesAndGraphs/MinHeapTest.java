package TreesAndGraphs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MinHeapTest {

    @Test
    public void testMinHeap_NoDuplicate() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(2);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(4);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(2), heap.extractMin());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(new Integer(4), heap.extractMin());
        assertEquals(new Integer(5), heap.extractMin());
    }
    
    @Test
    public void testMinHeap_HasDuplicate() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(2);
        array.add(1);
        array.add(4);
        array.add(1);
        array.add(3);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(2), heap.extractMin());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(new Integer(4), heap.extractMin());
    }
    
    @Test
    public void testMinHeap_InOrder() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(2), heap.extractMin());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(new Integer(4), heap.extractMin());
        assertEquals(new Integer(5), heap.extractMin());
    }
    
    @Test
    public void testMinHeap_InReverseOrder() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(2), heap.extractMin());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(new Integer(4), heap.extractMin());
        assertEquals(new Integer(5), heap.extractMin());
    }
    
    @Test
    public void testMinHeap_Same() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(1);
        array.add(1);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(1), heap.extractMin());
    }
    
    @Test
    public void testMinHeap_OneElement() throws EmptyHeapException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        
        MinHeap heap = new MinHeap(array);
        assertEquals(new Integer(1), heap.extractMin());
    }
    
    @Test(expected=EmptyHeapException.class)
    public void testMinHeap_Empty() throws EmptyHeapException {
        MinHeap heap = new MinHeap(new ArrayList<Integer>());
        
        heap.extractMin();
    }
    
    @Test
    public void testInsert() throws EmptyHeapException {
        MinHeap heap = new MinHeap(new ArrayList<Integer>());
        heap.insert(5);
        heap.insert(1);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        
        assertEquals(new Integer(1), heap.extractMin());
        assertEquals(new Integer(2), heap.extractMin());
        assertEquals(new Integer(3), heap.extractMin());
        assertEquals(new Integer(4), heap.extractMin());
        assertEquals(new Integer(5), heap.extractMin());
    }
}
