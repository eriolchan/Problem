package StacksAndQueues;

public class MyStack<T> {
    
    private InnerNode<T> top = null;
    
    public void push(T item) {
        InnerNode<T> t = new InnerNode<T>(item);
        t.next = top;
        top = t;
    }
    
    public T peek() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        
        return top.data;
    }
    
    public T pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        
        T item = top.data;
        top = top.next;
        
        return item;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
}
