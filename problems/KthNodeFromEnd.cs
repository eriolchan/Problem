namespace Problems
{
    /// <summary>
    /// Problem: 链表中倒数第k个结点
    /// 输入一个链表, 输出该链表中倒数第k个结点。从1开始计数,
    /// 即链表的尾结点是倒数第一个结点。
    /// </summary>
    public class KthNodeFromEnd
    {
        public static ListNode Process(ListNode head, uint k)
        {
            if (head == null || k == 0)
            {
                return null;
            }

            ListNode ahead = head;
            for (int i = 0; i < k - 1; ++i)
            {
                if (ahead.Next != null)
                {
                    ahead = ahead.Next;
                }
                else
                {
                    return null;
                }
            }

            ListNode behind = head;
            while (ahead.Next != null)
            {
                ahead = ahead.Next;
                behind = behind.Next;
            }

            return behind;
        }
    }
}
