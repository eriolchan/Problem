namespace Problems
{
    using System;

    public class ConstructBinaryTree
    {
        public static TreeNode ProcessRecursively(int[] preOrder, int[] inOrder)
        {
            if (preOrder == null ||
                inOrder == null ||
                preOrder.Length == 0 ||
                inOrder.Length == 0 ||
                preOrder.Length != inOrder.Length)
            {
                return null;
            }

            return ProcessCore(
                preOrder,
                0,
                preOrder.Length - 1,
                inOrder,
                0,
                inOrder.Length - 1);
        }

        public static TreeNode ProcessIteratively(int[] preOrder, int[] inOrder)
        {
            return null;
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
    }
}
