namespace Problems
{
    using System.Collections.Generic;
    using System.Text;

    /// <summary>
    /// Problem: 从尾到头打印链表
    /// 输入一个链表的头节点, 从尾到头反过来打印出每个结点的值。
    /// </summary>
    public class PrintListInReversedOrder
    {
        private static StringBuilder output = new StringBuilder();

        public static void ProcessRecursively(ListNode head)
        {
            if (head == null)
            {
                return;
            }

            ProcessRecursively(head.Next);
            output.Append(head.Value);
        }

        public static void ProcessIteratively(ListNode head)
        {
            Stack<ListNode> stack = new Stack<ListNode>();
            while (head != null)
            {
                stack.Push(head);
                head = head.Next;
            }

            while (stack.Count > 0)
            {
                output.Append(stack.Pop().Value);
            }
        }

        public static string GetResult()
        {
            if (output == null)
            {
                return null;
            }

            string result = output.ToString();
            if (string.IsNullOrEmpty(result))
            {
                return null;
            }

            output.Clear();
            return result;
        }
    }
}
