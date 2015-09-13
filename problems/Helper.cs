namespace Problems
{
    using System;
    using System.Text;

    public static class Helper
    {
        public static readonly Random random = new Random();

        public static void Swap(int[] array, int first, int second)
        {
            if (array == null || first == second)
            {
                return;
            }

            if (first < 0 ||
                second < 0 ||
                first >= array.Length ||
                second >= array.Length)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            int temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }

        public static string Output(StringBuilder output)
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

        public static bool CompareLinkedList(ListNode first, ListNode second)
        {
            if (first == second)
            {
                return true;
            }

            if (first == null || second == null)
            {
                return false;
            }

            bool result = true;
            while (first != null && second != null)
            {
                if (!first.Equals(second))
                {
                    result = false;
                    break;
                }

                first = first.Next;
                second = second.Next;
            }

            return result && first == null && second == null;
        }

        public static bool CompareBinaryTree(TreeNode first, TreeNode second)
        {
            if (first == second)
            {
                return true;
            }

            if (first == null || second == null)
            {
                return false;
            }

            if (!first.Equals(second))
            {
                return false;
            }

            return CompareBinaryTree(first.Left, second.Left) &&
                   CompareBinaryTree(first.Right, second.Right);
        }

        public static char[] CreateArray(string content, int length)
        {
            char[] result = new char[length];
            content.ToCharArray().CopyTo(result, 0);

            return result;
        }

        public static int[] CreateArray(int[] content, int length)
        {
            int[] result = new int[length];
            content.CopyTo(result, 0);

            return result;
        }

        public static TreeNode CreateTree(TreeType type)
        {
            switch (type)
            {
                case TreeType.CompleteTree:
                    return CreateCompleteTree();
                case TreeType.NotCompleteTree:
                    return CreateNotCompleteTree();
                case TreeType.NoRightChildTree:
                    return CreateNoRightChildTree();
                case TreeType.NoLeftChildTree:
                    return CreateNoLeftChildTree();
                default:
                    return null;
            }
        }

        private static TreeNode CreateNotCompleteTree()
        {
            TreeNode root = new TreeNode(1);
            root.Left = new TreeNode(2);
            root.Left.Left = new TreeNode(4);
            root.Left.Left.Right = new TreeNode(7);
            root.Right = new TreeNode(3);
            root.Right.Left = new TreeNode(5);
            root.Right.Right = new TreeNode(6);
            root.Right.Right.Left = new TreeNode(8);

            return root;
        }

        private static TreeNode CreateNoRightChildTree()
        {
            TreeNode root = new TreeNode(1);
            root.Left = new TreeNode(2);
            root.Left.Left = new TreeNode(3);
            root.Left.Left.Left = new TreeNode(4);
            root.Left.Left.Left.Left = new TreeNode(5);

            return root;
        }

        private static TreeNode CreateNoLeftChildTree()
        {
            TreeNode root = new TreeNode(1);
            root.Right = new TreeNode(2);
            root.Right.Right = new TreeNode(3);
            root.Right.Right.Right = new TreeNode(4);
            root.Right.Right.Right.Right = new TreeNode(5);

            return root;
        }

        private static TreeNode CreateCompleteTree()
        {
            TreeNode root = new TreeNode(1);
            root.Left = new TreeNode(2);
            root.Left.Left = new TreeNode(4);
            root.Left.Right = new TreeNode(5);
            root.Right = new TreeNode(3);
            root.Right.Left = new TreeNode(6);
            root.Right.Right = new TreeNode(7);

            return root;
        }
    }
}
