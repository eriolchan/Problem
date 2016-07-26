package LinkedLists;

/**
 * Question 2.7
 * Given two linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined
 * based on reference, not value.
 */
public class Question_2_7 {

    // O(n)
    public static ListNode findIntersection(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }
        
        int len1 = ListNode.getLength(n1);
        int len2 = ListNode.getLength(n2);
        
        if (len1 > len2) {
            ListNode temp = n1;
            n1 = n2;
            n2 = temp;
        }
        
        for (int i = 0; i < Math.abs(len1 - len2); ++i) {
            n2 = n2.getNext();
        }
        
        while (n1 != n2) {
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        
        return n1;
    }
}
