namespace Problems
{
    /// <summary>
    /// Problem: 链表的中间结点
    /// 如果链表中结点总数为奇数, 返回中间结点; 如果结点总数是偶数,
    /// 返回中间两个结点的任意一个。
    /// </summary>
    public class FindMiddleNodeOfList
    {
        public static ListNode Process(ListNode head)
        {
            if (head == null)
            {
                return null;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast.Next != null && fast.Next.Next != null)
            {
                fast = fast.Next.Next;
                slow = slow.Next;
            }

            return slow;
        }
    }
}
