namespace Problems
{
    /// <summary>
    /// Problem: 链表结点
    /// </summary>
    public class ListNode
    {
        public int Value { get; set; }
        public ListNode Next { get; set; }

        public ListNode(int value)
        {
            this.Value = value;
            this.Next = null;
        }

        public static void AddToTail(ref ListNode head, int value)
        {
            ListNode node = new ListNode(value);

            if (head == null)
            {
                head = node;
            }
            else
            {
                ListNode previous = head;
                while (previous.Next != null)
                {
                    previous = previous.Next;
                }

                previous.Next = node;
            }
        }

        public static void RemoveNode(ref ListNode head, int value)
        {
            if (head == null)
            {
                return;
            }

            if (head.Value == value)
            {
                head = head.Next;
            }
            else
            {
                ListNode previous = head;
                while (previous.Next != null && previous.Next.Value != value)
                {
                    previous = previous.Next;
                }

                if (previous.Next != null)
                {
                    previous.Next = previous.Next.Next;
                }
            }
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }

            ListNode other = obj as ListNode;
            if (other == null)
            {
                return false;
            }

            return this.Value == other.Value;
        }

        public override int GetHashCode()
        {
            return this.Value;
        }
    }
}
