namespace Problems
{
    /// <summary>
    /// Problem: 链表是否有环
    /// 判断一个单向链表是否形成了环形结构。
    /// </summary>
    public class FindLoopInList
    {
        public static bool Process(ListNode head)
        {
            if (head == null)
            {
                return false;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast.Next != null && fast.Next.Next != null)
            {
                fast = fast.Next.Next;
                slow = slow.Next;

                if (fast == slow)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
