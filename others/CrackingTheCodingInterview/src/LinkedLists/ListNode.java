package LinkedLists;

public class ListNode {

    private int data;
    private ListNode next;
    
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    public ListNode getNext() {
        return next;
    }
    
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    @Override
    public int hashCode() {
        return data;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof ListNode)) {
            return false;
        }
        
        final ListNode other = (ListNode)obj;
        
        return this.data == other.data;
    }
    
    // O(n)
    public void appendToTail(int data) {
        ListNode end = new ListNode(data);
        ListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        
        n.next = end;
    }
    
    // O(n)
    // Assume there is one and only one element in the list whose data matches.
    public static ListNode deleteNode(ListNode head, int data) {
        if (head == null) {
            return null;
        }
        
        if (head.data == data) {
            return head.next;
        }
        
        ListNode node = head;
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
                break;
            }
            
            node = node.next;
        }
        
        return head;
    }
    
    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.getNext();
        }
        
        return len;
    }
}
