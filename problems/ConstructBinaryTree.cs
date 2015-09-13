namespace Problems
{
    using System;
    using System.Collections.Generic;

    /// <summary>
    /// Problem: 重建二叉树
    /// 输入某二叉树的前序遍历和中序遍历的结果, 请重建出该二叉树。
    /// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    /// </summary>
    public class ConstructBinaryTree
    {
        public static TreeNode ProcessRecursively(int[] preOrder, int[] inOrder)
        {
            if (preOrder == null ||
                inOrder == null ||
                preOrder.Length == 0 ||
                inOrder.Length == 0)
            {
                return null;
            }

            if (preOrder.Length != inOrder.Length)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            return ProcessCore(
                preOrder,
                0,
                preOrder.Length - 1,
                inOrder,
                0,
                inOrder.Length - 1);
        }

        private static TreeNode ProcessCore(
            int[] preOrder,
            int startPreOrder,
            int endPreOrder,
            int[] inOrder,
            int startInOrder,
            int endInOrder)
        {
            TreeNode root = new TreeNode(preOrder[startPreOrder]);

            if (startPreOrder == endPreOrder)
            {
                if (startInOrder == endInOrder &&
                    preOrder[startPreOrder] == inOrder[startInOrder])
                {
                    return root;
                }
                else
                {
                    throw new ArgumentException(Constants.InvalidInput);
                }
            }

            int rootInOrder = startInOrder;
            while (rootInOrder <= endInOrder && inOrder[rootInOrder] != root.Value)
            {
                rootInOrder++;
            }
            
            if (rootInOrder == endInOrder && inOrder[rootInOrder] != root.Value)
            {
                throw new ArgumentException(Constants.InvalidInput);
            }

            int leftLength = rootInOrder - startInOrder;
            int leftPreOrderEnd = startPreOrder + leftLength;
            if (leftLength > 0)
            {
                root.Left = ProcessCore(
                    preOrder,
                    startPreOrder + 1,
                    leftPreOrderEnd,
                    inOrder,
                    startInOrder,
                    rootInOrder - 1);
            }

            if (leftLength < endPreOrder - startPreOrder)
            {
                root.Right = ProcessCore(
                    preOrder,
                    leftPreOrderEnd + 1,
                    endPreOrder,
                    inOrder,
                    rootInOrder + 1,
                    endInOrder);
            }

            return root;
        }
        public static TreeNode ProcessIteratively(int[] preOrder, int[] inOrder)
        {
            if (preOrder == null ||
                inOrder == null ||
                preOrder.Length == 0 ||
                inOrder.Length == 0 ||
                preOrder.Length != inOrder.Length)
            {
                return null;
            }

            Dictionary<int, int> orders = new Dictionary<int, int>();
            for(int i = 0; i < inOrder.Length; i++)
            {
                orders.Add(inOrder[i], i);
            }

            TreeNode root = new TreeNode(preOrder[0]);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.Push(root);

            TreeNode current = null;
            TreeNode previous = null;
            for (int i = 1; i < preOrder.Length; i++)
            {
                current = new TreeNode(preOrder[i]);
                if (!orders.ContainsKey(current.Value))
                {
                    throw new ArgumentException(Constants.InvalidInput);
                }

                if (orders[current.Value] < orders[stack.Peek().Value])
                {
                    stack.Peek().Left = current;
                    stack.Push(current);
                }
                else
                {
                    while (stack.Count > 0 &&
                           orders[current.Value] > orders[stack.Peek().Value]) 
                    {
                        previous = stack.Pop();
                    }

                    previous.Right = current;
                    stack.Push(current);
                }

            }

            return root;
        }
    }
}
