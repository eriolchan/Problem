namespace Problems
{
    using System.Collections.Generic;
    using System.Text;

    /// <summary>
    /// Problem: 树结点
    /// </summary>
    public class TreeNode
    {
        public int Value { get; set; }
        public TreeNode Left { get; set; }
        public TreeNode Right { get; set; }

        private static StringBuilder output = new StringBuilder();

        public static string Result
        {
            get
            {
                return Helper.Output(output);
            }
        }

        public TreeNode(int value)
        {
            this.Value = value;
            this.Left = null;
            this.Right = null;
        }

        public static void PreOrderTraverseRecursively(TreeNode root)
        {
            if (root != null)
            {
                output.Append(root.Value);
                PreOrderTraverseRecursively(root.Left);
                PreOrderTraverseRecursively(root.Right);
            }
        }

        public static void InOrderTraverseRecursively(TreeNode root)
        {
            if (root != null)
            {
                InOrderTraverseRecursively(root.Left);
                output.Append(root.Value);
                InOrderTraverseRecursively(root.Right);
            }
        }

        public static void PostOrderTraverseRecursively(TreeNode root)
        {
            if (root != null)
            {
                PostOrderTraverseRecursively(root.Left);
                PostOrderTraverseRecursively(root.Right);
                output.Append(root.Value);
            }
        }

        public static void PreOrderTraverseIteratively(TreeNode root)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;

            while (current != null || stack.Count > 0)
            {
                while (current != null)
                {
                    output.Append(current.Value);
                    stack.Push(current);
                    current = current.Left;
                }

                if (stack.Count > 0)
                {
                    current = stack.Pop().Right;
                }
            }
        }

        public static void InOrderTraverseIteratively(TreeNode root)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;

            while (current != null || stack.Count > 0)
            {
                while (current != null)
                {
                    stack.Push(current);
                    current = current.Left;
                }

                if (stack.Count > 0)
                {
                    current = stack.Pop();
                    output.Append(current.Value);
                    current = current.Right;
                }
            }
        }

        public static void PostOrderTraverseIteratively(TreeNode root)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            TreeNode previous = null;

            while (current != null || stack.Count > 0)
            {
                while (current != null)
                {
                    stack.Push(current);
                    current = current.Left;
                }

                current = stack.Peek();
                if (current.Right == null || current.Right == previous)
                {
                    output.Append(current.Value);
                    previous = current;
                    stack.Pop();
                    current = null;
                }
                else
                {
                    current = current.Right;
                }
            }
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
            {
                return false;
            }

            TreeNode other = obj as TreeNode;
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

    public enum TreeType
    {
        CompleteTree,
        NotCompleteTree,
        NoRightChildTree,
        NoLeftChildTree,
    }
}
