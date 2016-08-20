package StacksAndQueues;

public class MyQueue<T> {
    
    private InnerNode<T> first;
    private InnerNode<T> last;
    
    public MyQueue() {
        first = null;
        last = null;
    }
    
    public void add(T item) {
        InnerNode<T> t = new InnerNode<T>(item);
        
        if (last != null) {
            last.next = t;
        }
        
        last = t;
        if (first == null) {
            first = last;
        }
    }
    
    public T remove() throws EmptyQueueException {
        if (first == null) {
            throw new EmptyQueueException();
        }
        
        T item = first.data;
        first = first.next;
        
        if (first == null) {
            last = null;
        }
        
        return item;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}
