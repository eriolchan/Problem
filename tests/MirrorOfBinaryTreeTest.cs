namespace Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Problems;

    [TestClass]
    public class MirrorOfBinaryTreeTest
    {
        [TestMethod]
        public void TestCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.CompleteTree);
            TreeNode expected = new TreeNode(1);
            expected.Left = new TreeNode(3);
            expected.Left.Left = new TreeNode(7);
            expected.Left.Right = new TreeNode(6);
            expected.Right = new TreeNode(2);
            expected.Right.Left = new TreeNode(5);
            expected.Right.Right = new TreeNode(4);

            MirrorOfBinaryTree.Process(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));

            root = Helper.CreateTree(TreeType.CompleteTree);
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));
        }

        [TestMethod]
        public void TestNotCompleteTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NotCompleteTree);
            TreeNode expected = new TreeNode(1);
            expected.Left = new TreeNode(3);
            expected.Left.Left = new TreeNode(6);
            expected.Left.Right = new TreeNode(5);
            expected.Left.Left.Right = new TreeNode(8);
            expected.Right = new TreeNode(2);
            expected.Right.Right = new TreeNode(4);
            expected.Right.Right.Left = new TreeNode(7);

            MirrorOfBinaryTree.Process(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));

            root = Helper.CreateTree(TreeType.NotCompleteTree);
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));
        }

        [TestMethod]
        public void TestNoLeftChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoLeftChildTree);
            TreeNode expected = Helper.CreateTree(TreeType.NoRightChildTree);

            MirrorOfBinaryTree.Process(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));

            root = Helper.CreateTree(TreeType.NoLeftChildTree);
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));
        }

        [TestMethod]
        public void TestNoRightChildTree()
        {
            TreeNode root = Helper.CreateTree(TreeType.NoRightChildTree);
            TreeNode expected = Helper.CreateTree(TreeType.NoLeftChildTree);

            MirrorOfBinaryTree.Process(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));

            root = Helper.CreateTree(TreeType.NoRightChildTree);
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));
        }

        [TestMethod]
        public void TestOnlyOneNode()
        {
            TreeNode root = new TreeNode(1);
            TreeNode expected = new TreeNode(1);

            MirrorOfBinaryTree.Process(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));

            root = new TreeNode(1);
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsTrue(Helper.CompareBinaryTree(expected, root));
        }

        [TestMethod]
        public void TestNull()
        {
            TreeNode root = null;

            MirrorOfBinaryTree.Process(root);
            Assert.IsNull(root);

            root = null;
            MirrorOfBinaryTree.ProcessRecursively(root);
            Assert.IsNull(root);
        }
    }
}
