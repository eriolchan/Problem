namespace Problems
{
    public static class Helper
    {
        public static ListNode CreateLinkedList(int[] values)
        {
            if (values == null || values.Length == 0)
            {
                return null;
            }

            ListNode head = new ListNode(values[0]);
            ListNode tail = head;

            for (int i = 1; i < values.Length; i++)
            {
                tail.Next = new ListNode(values[i]);
                tail = tail.Next; 
            }

            return head;
        }
    }
}
