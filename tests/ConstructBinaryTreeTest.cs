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
            int[] preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
            int[] inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

            Assert.AreEqual(true, Helper.CompareBinaryTree(
                Helper.CreateTree(TreeType.NotCompleteTree),
                ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNoRightChildTree()
        {
            int[] preOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] inOrder = new int[] { 5, 4, 3, 2, 1 };

            Assert.AreEqual(true, Helper.CompareBinaryTree(
                Helper.CreateTree(TreeType.NoRightChildTree),
                ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNoLeftChildTree()
        {
            int[] preOrder = new int[] { 1, 2, 3, 4, 5 };
            int[] inOrder = new int[] { 1, 2, 3, 4, 5 };

            Assert.AreEqual(true, Helper.CompareBinaryTree(
                Helper.CreateTree(TreeType.NoLeftChildTree),
                ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestOnlyRootTree()
        {
            int[] preOrder = new int[] { 1 };
            int[] inOrder = new int[] { 1 };

            Assert.AreEqual(true, Helper.CompareBinaryTree(
                new TreeNode(1),
                ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestCompleteTree()
        {
            int[] preOrder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
            int[] inOrder = new int[] { 4, 2, 5, 1, 6, 3, 7 };

            Assert.AreEqual(true, Helper.CompareBinaryTree(
                Helper.CreateTree(TreeType.CompleteTree),
                ConstructBinaryTree.ProcessRecursively(preOrder, inOrder)));
        }

        [TestMethod]
        public void TestNull()
        {
            Assert.IsNull(ConstructBinaryTree.ProcessRecursively(null, null));
            Assert.IsNull(ConstructBinaryTree.ProcessRecursively(new int[0], new int[0]));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TestInvalidInput()
        {
            int[] preOrder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
            int[] inOrder = new int[] { 4, 2, 8, 1, 6, 3, 7 };

            ConstructBinaryTree.ProcessRecursively(preOrder, inOrder);
        }
    }
}
