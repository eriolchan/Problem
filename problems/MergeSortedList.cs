namespace Problems
{
    using System;

    /// <summary>
    /// Problem: 合并两个排序的链表
    /// 输入两个递增排序的链表, 合并这两个链表并使新链表
    /// 中的结点仍然是按照递增排序的。
    /// </summary>
    public class MergeSortedList
    {
        public static ListNode Process(ListNode first, ListNode second)
        {
            if (first == null)
            {
                return second;
            }

            if (second == null)
            {
                return first;
            }

            ListNode newHead = new ListNode(-1);

            ListNode previous = newHead;
            while (first != null && second != null)
            {
                if (first.Value <= second.Value)
                {
                    previous.Next = first;
                    first = first.Next;
                }
                else
                {
                    previous.Next = second;
                    second = second.Next;
                }

                previous = previous.Next;
            }

            if (first != null)
            {
                previous.Next = first;
            }

            if (second != null)
            {
                previous.Next = second;
            }

            return newHead.Next;
        }

        public static ListNode Process_Recursively(ListNode first, ListNode second)
        {
            if (first == null)
            {
                return second;
            }

            if (second == null)
            {
                return first;
            }

            ListNode newHead = null;
            if (first.Value <= second.Value)
            {
                newHead = first;
                newHead.Next = Process_Recursively(first.Next, second);
            }
            else
            {
                newHead = second;
                newHead.Next = Process_Recursively(first, second.Next);
            }

            return newHead;
        }
    }
}
