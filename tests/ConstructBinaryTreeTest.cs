namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;
    using System;

    [TestClass]
    public class ConstructBinaryTreeTest
    {
        [TestMethod]
        public void TestNotCompleteTree()
        {
            TreeNode expected = Helper.CreateTree(TreeType.NotCompleteTree);
            int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
            int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessIteratively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNoRightChildTree()
        {
            TreeNode expected = Helper.CreateTree(TreeType.NoRightChildTree);
            int[] preOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] inOrder = new int[] { 5, 4, 3, 2, 1 };

            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessIteratively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNoLeftChildTree()
        {
            int[] preOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] inOrder = new int[] { 1, 2, 3, 4, 5 };
            TreeNode expected = Helper.CreateTree(TreeType.NoLeftChildTree);

            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessIteratively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestOnlyRootTree()
        {
            int[] preOrder = new int[] { 1 };
            int[] inOrder = new int[] { 1 };
            TreeNode expected = new TreeNode(1);

            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessIteratively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestCompleteTree()
        {
            int[] preOrder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
            int[] inOrder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
            TreeNode expected = Helper.CreateTree(TreeType.CompleteTree);

            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
            Assert.IsTrue(Helper.CompareBinaryTree(expected, ConstructBinaryTree.ProcessIteratively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNull()
        {
            Assert.IsNull(ConstructBinaryTree.ProcessRecursively(null, null));
            Assert.IsNull(ConstructBinaryTree.ProcessIteratively(null, null));
        }

        [TestMethod]
        public void TestEmptyArray()
        {
            Assert.IsNull(ConstructBinaryTree.ProcessRecursively(new int[0], new int[0]));
            Assert.IsNull(ConstructBinaryTree.ProcessIteratively(new int[0], new int[0]));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInvalidInput()
        {
            int[] preOrder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
            int[] inOrder = new int[] { 4, 2, 8, 1, 6, 3, 7 };

            ConstructBinaryTree.ProcessRecursively(preOrder, inOrder);
            ConstructBinaryTree.ProcessIteratively(preOrder, inOrder);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestArrayLengthNotMatch()
        {
            int[] preOrder = new int[] { 1 };
            int[] inOrder = new int[] { 2, 1 };

            ConstructBinaryTree.ProcessRecursively(preOrder, inOrder);
            ConstructBinaryTree.ProcessIteratively(preOrder, inOrder);
        }
    }
}
