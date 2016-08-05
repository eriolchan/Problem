package TreesAndGraphs;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> array;
    
    public MinHeap(ArrayList<Integer> array) {
        this.array = array;
        buildHeap();
    }
    
    // O(log n)
    public Integer extractMin() throws EmptyHeapException {
        if (array.size() == 0) {
            throw new EmptyHeapException();
        }
        
        Integer result = array.get(0);
        if (array.size() > 1) {
            swap(0, array.size() - 1);
            array.remove(array.size() - 1);
            bubbleDown(0);
        } else {
            array.remove(0);
        }
        
        return result;
    }
    
    // O(log n)
    public void insert(Integer value) {
        array.add(value);
        bubbleUp(array.size() - 1);
    }
    
    private void buildHeap() {
        for (int i = array.size() / 2 - 1; i >= 0; --i) {
            bubbleDown(i);
        }
    }
    
    private void bubbleDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        
        if (left < array.size() && array.get(left) < array.get(smallest)) {
            smallest = left;
        }
        
        if (right < array.size() && array.get(right) < array.get(smallest)) {
            smallest = right;
        }
        
        if (smallest != index) {
            swap(smallest, index);
            bubbleDown(smallest);
        }
    }
    
    private void bubbleUp(int index) {
        int parent = (index - 1) / 2;
        
        while (parent >= 0) {
            if (array.get(index) < array.get(parent)) {
                swap(index, parent);
                index = parent;
                parent = (index - 1) / 2;
            } else {
                break;
            }
        }
    }
    
    private void swap(int a, int b) {
        int temp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);
    }
}

class EmptyHeapException extends Exception {
    private static final long serialVersionUID = 1L;
}
