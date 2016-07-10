package StacksAndQueues;

class InnerNode<T> {
    T data;
    InnerNode<T> next;
    
    public InnerNode(T data) {
        this.data = data;
    }
}