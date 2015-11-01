namespace Problems
{
    using System.Collections.Generic;

    /// <summary>
    /// Problem: 二叉树的镜像
    /// 请完成一个函数, 输入一个二叉树, 该函数输出它的镜像。
    /// </summary>
    public class MirrorOfBinaryTree
    {
        public static void Process(TreeNode root)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            TreeNode temp;

            while (current != null || stack.Count > 0)
            {
                while (current != null)
                {
                    stack.Push(current);

                    temp = current.Left;
                    current.Left = current.Right;
                    current.Right = temp;

                    current = current.Left;
                }

                if (stack.Count > 0)
                {
                    current = stack.Pop().Right;
                }
            }
        }

        public static void ProcessRecursively(TreeNode root)
        {
            if (root == null)
            {
                return;
            }

            TreeNode temp = root.Left;
            root.Left = root.Right;
            root.Right = temp;

            if (root.Left != null)
            {
                ProcessRecursively(root.Left);
            }

            if (root.Right != null)
            {
                ProcessRecursively(root.Right);
            }
        }
    }
}
