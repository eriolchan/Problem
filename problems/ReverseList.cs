namespace Problems
{
    /// <summary>
    /// Problem: 反转链表
    /// 定义一个函数, 输入一个链表的头结点, 反转该链表
    /// 并输出反转后的头结点。假设链表没有环。
    /// </summary>
    public class ReverseList
    {
        public static ListNode Process(ListNode head)
        {
            ListNode newHead = null;
            ListNode previous = null;
            ListNode current = head;
            ListNode next = null;

            while (current != null)
            {
                next = current.Next;
                if (next == null)
                {
                    newHead = current;
                }

                current.Next = previous;
                previous = current;
                current = next;
            }

            return newHead;
        }

        public static ListNode Process_Recursively(ListNode head)
        {
            if (head == null || head.Next == null)
            {
                return head;
            }

            ListNode newHead = Process_Recursively(head.Next);
            head.Next.Next = head;
            head.Next = null;

            return newHead;
        }
    }
}
