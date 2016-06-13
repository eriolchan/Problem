package LinkedLists;

public class Node {
    
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    public void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        
        n.next = end;
    }
    
    /**
     * Assume there is one and only one element in the list whose data matches.
     */
    public static Node deleteNode(Node head, int data) {
        if (head == null) {
            return null;
        }
        
        if (head.data == data) {
            head = head.next;
        } else {
            Node node = head;
            while (node.next != null) {
                if (node.next.data == data) {
                    node.next = node.next.next;
                    break;
                }
                
                node = node.next;
            }
        }
        
        return head;
    }
}
